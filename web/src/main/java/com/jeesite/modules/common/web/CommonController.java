/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.common.web;

import com.alibaba.fastjson.JSONObject;
import com.jeesite.modules.common.utils.CommonUtils;
import com.jeesite.modules.file.entity.FileUpload;
import com.jeesite.modules.file.service.support.FileUploadServiceExtendSupport;
import com.jeesite.modules.file.utils.FileUploadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CommonController
 *
 * @author chang
 * @version 2020-05-19
 */
@Controller
@RequestMapping(value = "${adminPath}/common/common")
public class CommonController extends FileUploadServiceExtendSupport {

    /**
     * 获取图片地址
     *
     * @param jsonStr
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getImgUrl")
    @ResponseBody
    public Map<String, Object> getImgUrl(@RequestBody String jsonStr, HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonObject = JSONObject.parseObject(jsonStr);

        String bizKey = jsonObject.getString("bizKey");
        String bizType = jsonObject.getString("bizType");

        List<FileUpload> list = FileUploadUtils.findFileUpload(bizKey, bizType);

        String imgUrl = "";
        if (list.size() > 0) {
            imgUrl = request.getContextPath() + CommonUtils.getImgPath(bizKey, bizType);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("imgUrl", imgUrl);

        return map;
    }


}