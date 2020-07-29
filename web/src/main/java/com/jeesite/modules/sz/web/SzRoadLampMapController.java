package com.jeesite.modules.sz.web;

import com.jeesite.modules.sz.util.LightMapKeyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "${adminPath}/sz/szRoadLampMap")
public class SzRoadLampMapController {

    @RequestMapping(value = "/index")
    public ModelAndView index(){

        ModelAndView modelAndView = new ModelAndView("redirect:http://111.50.0.48:7070/web/user/login/api.html?skey="+ LightMapKeyUtil.rsaEncode() +"&lang=zh_CN&map=1");//重定向

        return modelAndView;
    }

}
