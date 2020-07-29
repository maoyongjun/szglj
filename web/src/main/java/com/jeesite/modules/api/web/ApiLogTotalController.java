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
import com.jeesite.modules.api.entity.ApiLogTotal;
import com.jeesite.modules.api.service.ApiLogTotalService;

/**
 * api访问次数统计表Controller
 * @author myj
 * @version 2020-05-29
 */
@Controller
@RequestMapping(value = "${adminPath}/api/apiLogTotal")
public class ApiLogTotalController extends BaseController {

	@Autowired
	private ApiLogTotalService apiLogTotalService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ApiLogTotal get(String id, boolean isNewRecord) {
		return apiLogTotalService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("api:apiLogTotal:view")
	@RequestMapping(value = {"list", ""})
	public String list(ApiLogTotal apiLogTotal, Model model) {
		model.addAttribute("apiLogTotal", apiLogTotal);
		return "modules/api/apiLogTotalList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("api:apiLogTotal:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ApiLogTotal> listData(ApiLogTotal apiLogTotal, HttpServletRequest request, HttpServletResponse response) {
		apiLogTotal.setPage(new Page<>(request, response));
		Page<ApiLogTotal> page = apiLogTotalService.findPage(apiLogTotal);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("api:apiLogTotal:view")
	@RequestMapping(value = "form")
	public String form(ApiLogTotal apiLogTotal, Model model) {
		model.addAttribute("apiLogTotal", apiLogTotal);
		return "modules/api/apiLogTotalForm";
	}

	/**
	 * 保存api访问次数统计表
	 */
	@RequiresPermissions("api:apiLogTotal:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ApiLogTotal apiLogTotal) {
		apiLogTotalService.save(apiLogTotal);
		return renderResult(Global.TRUE, text("保存api访问次数统计表成功！"));
	}
	
	/**
	 * 删除api访问次数统计表
	 */
	@RequiresPermissions("api:apiLogTotal:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ApiLogTotal apiLogTotal) {
		apiLogTotalService.delete(apiLogTotal);
		return renderResult(Global.TRUE, text("删除api访问次数统计表成功！"));
	}
	
}