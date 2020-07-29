package com.jeesite.modules.sz.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jeesite.common.web.http.HttpClientUtils;
import com.jeesite.modules.sz.dao.SzRoadLampAlarmdataDao;
import com.jeesite.modules.sz.entity.SzRoadLampAlarmEntity;
import com.jeesite.modules.sz.entity.SzRoadLampAlarmdata;
import com.jeesite.modules.sz.entity.SzRoadLampLoginEntity;
import com.jeesite.modules.sz.entity.SzRoadLampTotal;
import com.jeesite.modules.sz.util.MD5Util;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft_6455;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("szRoadLampGetDataService")
public class SzRoadLampGetDataService {

    private static Logger logger = LoggerFactory.getLogger(SzRoadLampGetDataService.class);
    private static String alarmDataUrl= "http://%s/api/json?sid=%s&cmd=alarm-realtime&ctrl=count&version=1&lang=zh_CN&pid=%s";
    private static String loginUrl="http://%s/api/json?cmd=login&ctrl=user&version=1&lang=zh_CN";
    private static String heartUrl ="ws://%s/api/ws?sid=%s";
    private static String getTotalDataUrl ="http://%s/api/json?sid=%s&ctrl=overall&version=1&lang=zh_CN&cmd=energy-stats&pid=%s";
    public static WebSocketClient client;
    @Resource
    SzRoadLampAlarmdataDao szRoadLampAlarmdataDao;
    @Resource
    SzRoadLampTotalService szRoadLampTotalService;

    /**
     * 程序入口
     * @param url
     * @param username
     * @param pwd
     * @param pid
     */
    public void run(String url, String username, String pwd, String pid) {
        String password = MD5Util.getMD5Str(pwd);
        String key = login(url, username, password);
        heart(url, key);
        long count = szRoadLampAlarmdataDao.findCount(new SzRoadLampAlarmdata());
        //历史数据只对接一次
        if (count == 0) {
            getAlarmData(url, key, pid);
        }
        getTotalData(url, key, pid);

    }

    /**
     * 获取统计数据
     */
    public void getTotalData(String url, String sid, String pid){
        String countResult = HttpClientUtils.ajaxPostJson(String.format(getTotalDataUrl,url,sid,pid),
                "\""+pid+"\"");
        String jsonTotal = countResult.substring(countResult.indexOf("{"), countResult.lastIndexOf("}") + 1);
        Map json = JSON.parseObject(jsonTotal);
        List<SzRoadLampTotal> list = new ArrayList<SzRoadLampTotal>();
        for(Object key :json.keySet()){
            Object value = json.get(key);
            SzRoadLampTotal lampTotal = new SzRoadLampTotal();
            lampTotal.setKey(key.toString());
            if(value==null){
                value = 0;
            }
            lampTotal.setValue(Double.valueOf(value.toString()));
            list.add(lampTotal);
        }
        for(SzRoadLampTotal lampTotal :  list){
            SzRoadLampTotal condition = new SzRoadLampTotal();
            condition.setKey(lampTotal.getKey());
            List<SzRoadLampTotal> result = szRoadLampTotalService.findList(condition);
            if(result.size()>0){
                lampTotal.setId(result.get(0).getId());
            }
            szRoadLampTotalService.save(lampTotal);
        }


    }

    /**
     * 获取报警数据
     * @param url
     * @param sid
     * @param pid
     */
    public void getAlarmData(String url, String sid, String pid) {
        String countResult = HttpClientUtils.ajaxPostJson(String.format(alarmDataUrl,url,sid,pid),
                "{\"wheres\": [{\"k\": \"pid\", \"o\": \"=\", \"v\": \"" + pid + "\"}]}");
        String jsonCount = countResult.substring(countResult.indexOf("{"), countResult.lastIndexOf("}") + 1);

        Integer count = JSON.parseObject(jsonCount).getInteger("count");

        for (int i = 0; i < count / 1000 + 1; i++) {
            String result = HttpClientUtils.ajaxPostJson(String.format(alarmDataUrl,url,sid,pid),
                    "{\"wheres\": [{\"k\": \"pid\", \"o\": \"=\", \"v\": \"" + pid + "\"}],\"orders\": [],\"page\":\"" + (i + 1) + "\",\"pageSize\":\"1000\"}");
            String alarmData = result.substring(result.indexOf("["), result.lastIndexOf("]") + 1);

            List<SzRoadLampAlarmEntity> alarmEntity = JSON.parseArray(alarmData, SzRoadLampAlarmEntity.class);
            List<SzRoadLampAlarmdata> alarmdatas = new ArrayList<SzRoadLampAlarmdata>();
            for (SzRoadLampAlarmEntity alarm : alarmEntity) {
                SzRoadLampAlarmdata alarmdata = new SzRoadLampAlarmdata();
                BeanUtils.copyProperties(alarm, alarmdata);
                alarmdata.setAlarmid(alarm.getId());
                alarmdatas.add(alarmdata);
            }
            szRoadLampAlarmdataDao.insertBatch(alarmdatas);
        }


    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public  String login(String url, String username, String password) {
        SzRoadLampLoginEntity entity = new SzRoadLampLoginEntity();
        entity.setLangKey("zh_CN");
        entity.setUser(username);
        entity.setPassword(password);
        String result = HttpClientUtils.ajaxPostJson(String.format(loginUrl,url), JSON.toJSONString(entity));
        logger.info("loginUrl:"+String.format(loginUrl,url));
        logger.info("result:"+result);
        String jsonKey = result.substring(result.indexOf("{"), result.indexOf("}") + 1);
        String sid = JSON.parseObject(jsonKey).getString("sid");
        return sid;
    }

    /**
     * 心跳
     */
    public  void heart(String url, String key) {
        //如果未连接，进行连接
        if (client == null || client.isClosed()) {
            try {
                client = new WebSocketClient(new URI(String.format(heartUrl,url,key)), new Draft_6455()) {
                    @Override
                    public void onOpen(ServerHandshake serverHandshake) {
                        logger.debug("握手成功");
                    }

                    @Override
                    public void onMessage(String msg) {
                        logger.debug("收到消息==========" + msg);
                        saveMsg(msg);
                        if (msg.equals("over")) {
                            client.close();
                        }
                    }

                    @Override
                    public void onClose(int i, String s, boolean b) {
                        logger.debug("链接已关闭");
                    }

                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                        logger.debug("发生错误已关闭");
                    }
                };
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }

            client.connect();
            //logger.info(client.getDraft());
            while (client.getReadyState() == ReadyState.NOT_YET_CONNECTED) {
                logger.debug("正在连接...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //连接成功,发送信息
//        client.send("0|login|add-listener|1|1|1||zh_CN||0|{\"cmd\":\"push-lcu\",\"ctrl\":\"status\",\"ver\":\"1\"}");
//        client.send("0|login|add-listener|1|2|1||zh_CN||0|{\"cmd\":\"push-lcu\",\"ctrl\":\"data\",\"ver\":\"1\"}");
//        client.send("0|login|add-listener|1|3|1||zh_CN||0|{\"cmd\":\"push-lcu\",\"ctrl\":\"action\",\"ver\":\"1\"}");
//        client.send("0|login|add-listener|1|4|1||zh_CN||0|{\"cmd\":\"push-alarm\",\"ctrl\":\"alarm\",\"ver\":\"1\"}");
            client.send("0|login|add-listener|1|4|1||zh_CN||0|{\"cmd\":\"push-alarm\",\"ctrl\":\"alarm\",\"ver\":\"1\"}");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {

                        client.send("0|login|heart-beat|1|80|1||zh_CN||0|");
                        try {
                            Thread.sleep(30000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }


    }

    /**
     * 保存接收到的消息
     * @param msg
     */
    public void saveMsg(String msg){

        if(msg.indexOf("push-alarm")!=-1){
            String alarmData = msg.substring(msg.indexOf("{"), msg.lastIndexOf("}") + 1);
            SzRoadLampAlarmEntity alarmEntity = JSON.parseObject(alarmData, SzRoadLampAlarmEntity.class);
            SzRoadLampAlarmdata alarmdata = new SzRoadLampAlarmdata();
            BeanUtils.copyProperties(alarmEntity, alarmdata);
            alarmdata.setAlarmid(alarmEntity.getId());

            //查询是否存在，存在就更新
            SzRoadLampAlarmdata condition = new SzRoadLampAlarmdata();
            condition.setAlarmid(alarmEntity.getId());
            SzRoadLampAlarmdata queryAlarmData = szRoadLampAlarmdataDao.getByEntity(condition);
            if(queryAlarmData!=null){
                alarmdata.setId(queryAlarmData.getId());
                alarmdata.setHandledate(new Date());
                szRoadLampAlarmdataDao.update(alarmdata);
            }else{
                szRoadLampAlarmdataDao.insert(alarmdata);
            }

        }
    }


}
