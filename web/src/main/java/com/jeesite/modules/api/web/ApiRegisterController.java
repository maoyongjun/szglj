/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.api.entity.ApiRegister;
import com.jeesite.modules.api.service.ApiRegisterService;

/**
 * api注册记录Controller
 * @author myj
 * @version 2020-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/api/apiRegister")
public class ApiRegisterController extends BaseController {

	@Autowired
	private ApiRegisterService apiRegisterService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ApiRegister get(String id, boolean isNewRecord) {
		return apiRegisterService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("api:apiRegister:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApiRegister apiRegister, Model model) {
		model.addAttribute("apiRegister", apiRegister);
		return "modules/api/apiRegisterList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("api:apiRegister:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ApiRegister> listData(ApiRegister apiRegister, HttpServletRequest request, HttpServletResponse response) {
		apiRegister.setPage(new Page<>(request, response));
		Page<ApiRegister> page = apiRegisterService.findPage(apiRegister);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("api:apiRegister:view")
	@RequestMapping(value = "form")
	public String form(ApiRegister apiRegister, Model model) {
		model.addAttribute("apiRegister", apiRegister);
		return "modules/api/apiRegisterForm";
	}

	/**
	 * 保存api注册记录
	 */
	@RequiresPermissions("api:apiRegister:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ApiRegister apiRegister) {
		apiRegisterService.save(apiRegister);
		return renderResult(Global.TRUE, text("保存api注册记录成功！"));
	}
	
	/**
	 * 删除api注册记录
	 */
	@RequiresPermissions("api:apiRegister:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ApiRegister apiRegister) {
		apiRegisterService.delete(apiRegister);
		return renderResult(Global.TRUE, text("删除api注册记录成功！"));
	}
	
}