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
import com.jeesite.modules.api.entity.ApiLog;
import com.jeesite.modules.api.service.ApiLogService;

/**
 * api访问记录Controller
 * @author myj
 * @version 2020-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/api/apiLog")
public class ApiLogController extends BaseController {

	@Autowired
	private ApiLogService apiLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ApiLog get(String id, boolean isNewRecord) {
		return apiLogService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
//	@RequiresPermissions("api:apiLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApiLog apiLog, Model model) {
		model.addAttribute("apiLog", apiLog);
		return "modules/api/apiLogList";
	}
	
	/**
	 * 查询列表数据
	 */
//	@RequiresPermissions("api:apiLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ApiLog> listData(ApiLog apiLog, HttpServletRequest request, HttpServletResponse response) {
		apiLog.setPage(new Page<>(request, response));
		Page<ApiLog> page = apiLogService.findPage(apiLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
//	@RequiresPermissions("api:apiLog:view")
	@RequestMapping(value = "form")
	public String form(ApiLog apiLog, Model model) {
		model.addAttribute("apiLog", apiLog);
		return "modules/api/apiLogForm";
	}

	/**
	 * 保存api访问记录
	 */
//	@RequiresPermissions("api:apiLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ApiLog apiLog) {
		apiLogService.save(apiLog);
		return renderResult(Global.TRUE, text("保存api访问记录成功！"));
	}
	
	/**
	 * 删除api访问记录
	 */
//	@RequiresPermissions("api:apiLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ApiLog apiLog) {
		apiLogService.delete(apiLog);
		return renderResult(Global.TRUE, text("删除api访问记录成功！"));
	}
	
}