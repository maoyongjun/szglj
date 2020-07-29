
package com.jeesite.modules.wxapp.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.common.web.http.HttpClientUtils;
import com.jeesite.modules.city.entity.snapshot.CitySnapshot;
import com.jeesite.modules.city.service.snapshot.CitySnapshotService;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.UserService;
import com.jeesite.modules.sys.utils.PwdUtils;
import com.jeesite.modules.wxapp.service.WxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * 微信Controller
 *
 * @author chang
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "wx")
public class WXController extends BaseController {

    @Autowired
    private UserService userService;
    @Autowired
    private WxUserService wxUserService;
    @Autowired
    private CitySnapshotService citySnapshotService;

    private static String SESSION_KEY = "";

    @Value("${server.servlet.context-path}")
    private String contextPath;
    @Value("${file.baseDir}")
    private String baseDir;
    @Value("${wx.appId}")
    private String appId;
    @Value("${wx.appSecret}")
    private String appSecret;

    /**
     * 账户登录成功进入，失败提示账户或密码错误
     *
     * @param jsonStr
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "accountlogin", method = RequestMethod.POST)
    public Map<String, Object> accountlogin(@RequestBody String jsonStr, HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, Object> map = MapUtils.newHashMap();
        ObjectMapper mapper = new ObjectMapper();
        User loginUser = mapper.readValue(jsonStr, User.class);
        JSONObject object = JSONObject.parseObject(jsonStr);
        User user = userService.getByLoginCode(loginUser);
        boolean pwdValid = false;
        if (user != null) {
            pwdValid = PwdUtils.validatePassword(object.getString("password"), user.getPassword());
        } else{
            map.put("code", "error");
            map.put("msg", "该账户不存在");
            return map;
        }
        if (pwdValid) {
            user.setPassword(null);
            map.put("code", "ok");
            map.put("user", user);
        } else {
            map.put("code", "error");
            map.put("msg", "密码错误");
        }

        return map;
    }


    /**
     * 微信登录，验证后台有没有绑定手机号，如果没有，跳转绑定手机号页面，如果有，直接登入上传图片页面
     *
     * @param code
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "wxlogin")
    public Map<String, Object> wxlogin(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("wxlogin start");
        String getUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+appSecret+"&js_code=" + code + "&grant_type=authorization_code";
        String res = HttpClientUtils.get(getUrl);
        JSONObject obj = JSON.parseObject(res);
        Integer errcode = null;
        Map<String, Object> map = MapUtils.newHashMap();

        if (obj.containsKey("errcode")) {
            errcode = obj.getInteger("errcode");
        }
        if (errcode != null && errcode != 0) {
            map.put("code", "error");
        } else {
            String openId = obj.getString("openid");
            User wxUser = wxUserService.getUserByOpenId(openId);
            if (wxUser != null) {
                wxUser.setPassword(null);
                map.put("bindPhone", "1");//已绑定，直接进入主页面
                map.put("user", wxUser);
            } else {
                map.put("bindPhone", "0");//未绑定，需要绑定手机号
            }
            map.put("code", "ok");
            map.put("openId", openId);
        }

        return map;
    }

    /**
     * 绑定手机号
     *
     * @param jsonStr  手机号，密码，确认密码，openId
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "bindPhone")
    public Map<String, Object> bindPhone(@RequestBody String jsonStr, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行 bindPhone");
        Map<String, Object> map = MapUtils.newHashMap();
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        String phone = jsonObject.getString("phone");
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        String confirmPassword = jsonObject.getString("confirmPassword");
        String openId = jsonObject.getString("openId");

        if ("".equals(phone)) {
            map.put("code", "error");
            map.put("msg", "手机号不能为空");
            return map;
        }

        if ("".equals(password) || "".equals(confirmPassword)) {
            map.put("code", "error");
            map.put("msg", "密码不能为空");
            return map;
        }

        if (!password.equals(confirmPassword)) {
            map.put("code", "error");
            map.put("msg", "两次密码不一致");
            return map;
        }

        User query = new User();
        query.setLoginCode(phone);
        User user = userService.getByLoginCode(query);
        if (user != null) {
            map.put("code", "error");
            map.put("msg", "该手机号已使用");
        } else {
            User newUser = new User();
            newUser.setLoginCode(phone);
            newUser.setUserName(userName);
            newUser.setPhone(phone);
            newUser.setWxOpenid(openId);
            newUser.setPassword(password);

            userService.save(newUser);
            map.put("code", "ok");
            map.put("user",newUser);
        }

        return map;
    }

    /**
     * 绑定微信 OpenId
     * @param jsonStr
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "bindWxOpenId")
    public Map<String,Object> bindWxOpenId(@RequestBody String jsonStr, HttpServletRequest request, HttpServletResponse response) throws IOException{
        System.out.println("bindWxOpenId start");
        JSONObject object = JSONObject.parseObject(jsonStr);
        String code = object.getString("code");
        String loginCode = object.getString("loginCode");

        String getUrl = "https://api.weixin.qq.com/sns/jscode2session?appid="+appId+"&secret="+appSecret+"&js_code=" + code + "&grant_type=authorization_code";
        String res = HttpClientUtils.get(getUrl);
        JSONObject obj = JSON.parseObject(res);
        Integer errcode = null;
        Map<String, Object> map = MapUtils.newHashMap();

        if (obj.containsKey("errcode")) {
            errcode = obj.getInteger("errcode");
        }
        if (errcode != null && errcode != 0) {
            map.put("code", "error");
            map.put("msg", "微信绑定请求失败");
        } else {
            String openId = obj.getString("openid");
            User query = new User();
            query.setLoginCode(loginCode);
            User wxUser = userService.getByLoginCode(query);

            User opidUser = wxUserService.getUserByOpenId(openId);
            if(opidUser!=null){
                map.put("code", "error");
                map.put("msg", "该微信已绑定其他手机号");
                return map;
            }

            if (wxUser != null) {
                try {
                    wxUser.setWxOpenid(openId);
                    userService.save(wxUser);
                    map.put("code", "ok");
                }catch (Exception e){
                    map.put("code", "error");
                    map.put("msg", "数据库操作异常");
                }
            } else {
                map.put("code", "error");
                map.put("msg", "数据库操作异常");
            }
        }

        return map;
    }

    /**
     * 解密微信用户信息（暂时不用）
     *
     * @param jsonObject
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "decryptUserInfo")
    public Map<String, Object> decryptUserInfo(@RequestBody JSONObject jsonObject, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String encryptedData = jsonObject.getString("encryptedData");
        String iv = jsonObject.getString("iv");

//        WXCore.decrypt("wxefc891a9a056766d",encryptedData,"",iv);
        Map<String, Object> map = MapUtils.newHashMap();
        boolean val = PwdUtils.validatePassword("admin1", "a21b07a8d1baacf78c7de14bd0730c648fedbbd908d49a4c53b4039b");

        return map;
    }


    /**
     * @param request
     * @param file
     * @return 上传成功返回“success”，上传失败返回“error”
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        System.out.println("执行upload");
        request.setCharacterEncoding("UTF-8");
        logger.info("执行图片上传");
        String uuid = request.getParameter("uuid");
        String userName = request.getParameter("userName");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String description = request.getParameter("description");
        String pic = request.getParameter("pic");

        if (!file.isEmpty()) {
            logger.info("成功获取照片");
            String fileName = file.getOriginalFilename();
            String path = null;
            String type = null;
            type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
            logger.info("图片初始名称为：" + fileName + " 类型为：" + type);
            if (type != null) {
                if ("GIF".equals(type.toUpperCase()) || "PNG".equals(type.toUpperCase()) || "JPG".equals(type.toUpperCase())) {

                    // 项目在容器中实际发布运行的根路径
//                    String realPath = request.getSession().getServletContext().getRealPath("/");
                    String realPath = baseDir + "/userfiles/snapshot/upload/";
                    fileName = (fileName.length() > 10) ? (fileName.substring(fileName.length() - 10)) : fileName;
                    // 自定义的文件名称
                    String trueFileName = String.valueOf(System.currentTimeMillis()) + fileName;
                    // 设置存放图片文件的路径
                    path = realPath + trueFileName;
                    logger.info("存放图片文件的路径:" + path);
                    file.transferTo(new File(path));
                    logger.info("文件成功上传到指定目录下");

                    String picUrl = contextPath + "/userfiles/snapshot/upload/" + trueFileName;

                    CitySnapshot citySnapshot = citySnapshotService.getCitySnapshotByUuid(uuid);

                    if (citySnapshot == null) {
                        citySnapshot = new CitySnapshot();
                        citySnapshot.setUuid(uuid);
                    }

                    citySnapshot.setUserName(userName);
                    citySnapshot.setPhone(phone);
                    citySnapshot.setAddress(address);
                    citySnapshot.setDescription(description);
                    citySnapshot.setEventStatus("0");
                    citySnapshot.setUploadDate(new Date());

                    if ("0".equals(pic)) {
                        citySnapshot.setPicUrl1(picUrl);
                    } else if ("1".equals(pic)) {
                        citySnapshot.setPicUrl2(picUrl);
                    } else if ("2".equals(pic)) {
                        citySnapshot.setPicUrl3(picUrl);
                    }
                    citySnapshotService.save(citySnapshot);

                } else {
                    logger.info("不是我们想要的文件类型,请按要求重新上传");
                    return "error";
                }
            } else {
                logger.info("文件类型为空");
                return "error";
            }
        } else {
            logger.info("没有找到相对应的文件");
            return "error";
        }
        return "ok";
    }


}