package com.jeesite.modules.sz.service;

import com.alibaba.fastjson.JSON;
import com.jeesite.common.web.http.HttpClientUtils;
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunitymember;
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunityupload;
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxmember;
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxupload;
import com.jeesite.modules.sz.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.net.*;
import java.util.List;

@Service("szRjgsGetDataService")
public class SzRjgsGetDataService {

    private static Logger logger = LoggerFactory.getLogger(SzRjgsGetDataService.class);
    @Resource
    SzEnvironmentalXzzxmemberService szEnvironmentalXzzxmemberService;
    @Resource
    SzEnvironmentalXzzxuploadService szEnvironmentalXzzxuploadService;
    @Resource
    SzEnvironmentalCommunitymemberService szEnvironmentalCommunitymemberService;
    @Resource
    SzEnvironmentalCommunityuploadService szEnvironmentalCommunityuploadService;


    
    public static void main(String[] args) {
        SzRjgsGetDataService service = new SzRjgsGetDataService();
        service.run("http://81.70.27.61:15001/Api/Ycsszglj");
    }

    public void run(String url){
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);
        login(url);
        getXzzxMember(url);
        getXzzxUpload(url);
        getCommunityMember(url);
        getCommunityUpload(url);


    }


    /**
     * 登录
     */
    public void login(String url){
        logger.info(url + "/link");
        String result =  HttpUtil.HttpURLConnectionGet(url + "/link");
        logger.info(result);
    }

    /**
     * 获取机关单位信息
     */
    public void getXzzxMember(String url){
        String result = HttpUtil.HttpURLConnectionGet(url + "/getXzzxMember");
        logger.info("*****************getXzzxMember******"+result);
        List<SzEnvironmentalXzzxmember> szEnvironmentalXzzxmembers = JSON.parseArray(result, SzEnvironmentalXzzxmember.class);
        for(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember:szEnvironmentalXzzxmembers){
            szEnvironmentalXzzxmember.setWjqyId(Integer.valueOf(szEnvironmentalXzzxmember.getId()));
            szEnvironmentalXzzxmemberService.save(szEnvironmentalXzzxmember);
            SzEnvironmentalXzzxmember condition = new SzEnvironmentalXzzxmember();
            condition.setWjqyId(Integer.valueOf(szEnvironmentalXzzxmember.getId()));
            List<SzEnvironmentalXzzxmember> list = szEnvironmentalXzzxmemberService.findList(condition);
            if(list.size()>0){
                szEnvironmentalXzzxmember.setId(list.get(0).getId());
                szEnvironmentalXzzxmemberService.update(szEnvironmentalXzzxmember);
            }else{
                szEnvironmentalXzzxmemberService.insert(szEnvironmentalXzzxmember);
            }
        }

    }

    /**
     * 每日机关单位厨余垃圾与资源垃圾处置数据
     */
    public void getXzzxUpload(String url){
        String result = HttpUtil.HttpURLConnectionGet(url+"/getXzzxUpload");
        logger.info("*****************getXzzxUpload******"+result);
        List<SzEnvironmentalXzzxupload> szEnvironmentalXzzxuploads = JSON.parseArray(result, SzEnvironmentalXzzxupload.class);
        for(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload:szEnvironmentalXzzxuploads){
            szEnvironmentalXzzxupload.setWjqyId(Integer.valueOf(szEnvironmentalXzzxupload.getId()));
            szEnvironmentalXzzxuploadService.save(szEnvironmentalXzzxupload);
            SzEnvironmentalXzzxupload condition = new SzEnvironmentalXzzxupload();
            condition.setWjqyId(Integer.valueOf(szEnvironmentalXzzxupload.getId()));
            List<SzEnvironmentalXzzxupload> list = szEnvironmentalXzzxuploadService.findList(condition);
            if(list.size()>0){
                szEnvironmentalXzzxupload.setId(list.get(0).getId());
                szEnvironmentalXzzxuploadService.update(szEnvironmentalXzzxupload);
            }else{
                szEnvironmentalXzzxuploadService.insert(szEnvironmentalXzzxupload);
            }
        }


    }
    /**
     * 试点社区信息
     */
    public void getCommunityMember(String url){
        String result = HttpUtil.HttpURLConnectionGet(url+"/getCommunityMember");
        logger.info("*****************getCommunityMember******"+result);
        List<SzEnvironmentalCommunitymember> szEnvironmentalCommunitymembers = JSON.parseArray(result, SzEnvironmentalCommunitymember.class);
        for(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember:szEnvironmentalCommunitymembers){
            szEnvironmentalCommunitymember.setWjqyId(Integer.valueOf(szEnvironmentalCommunitymember.getId()));
            SzEnvironmentalCommunitymember condition = new SzEnvironmentalCommunitymember();
            condition.setWjqyId(Integer.valueOf(szEnvironmentalCommunitymember.getId()));
            List<SzEnvironmentalCommunitymember> list = szEnvironmentalCommunitymemberService.findList(condition);
            if(list.size()>0){
                szEnvironmentalCommunitymember.setId(list.get(0).getId());
                szEnvironmentalCommunitymemberService.update(szEnvironmentalCommunitymember);
            }else {
                szEnvironmentalCommunitymemberService.insert(szEnvironmentalCommunitymember);
            }
        }
    }

    /**
     * 每日试点社区厨余垃圾与资源垃圾
     */
    public void getCommunityUpload(String url){
        String result = HttpUtil.HttpURLConnectionGet(url+"/getCommunityUpload");
        logger.info("*****************getCommunityUpload******"+result);
        List<SzEnvironmentalCommunityupload> szEnvironmentalCommunityuploads = JSON.parseArray(result, SzEnvironmentalCommunityupload.class);
        for(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload:szEnvironmentalCommunityuploads){
            szEnvironmentalCommunityupload.setWjqyId(Integer.valueOf(szEnvironmentalCommunityupload.getId()));
            SzEnvironmentalCommunityupload condition = new SzEnvironmentalCommunityupload();
            condition.setWjqyId(Integer.valueOf(szEnvironmentalCommunityupload.getId()));
            List<SzEnvironmentalCommunityupload> list = szEnvironmentalCommunityuploadService.findList(condition);
            if(list.size()>0){
                szEnvironmentalCommunityupload.setId(list.get(0).getId());
                szEnvironmentalCommunityuploadService.update(szEnvironmentalCommunityupload);
            }else {
                szEnvironmentalCommunityuploadService.insert(szEnvironmentalCommunityupload);
            }
        }

    }



}
