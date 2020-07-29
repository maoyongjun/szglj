/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.web;

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
import com.jeesite.modules.sz.entity.SzEnvironmentalWaterManagement;
import com.jeesite.modules.sz.service.SzEnvironmentalWaterManagementService;

/**
 * 自来水厂信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalWaterManagement")
public class SzEnvironmentalWaterManagementController extends BaseController {

	@Autowired
	private SzEnvironmentalWaterManagementService szEnvironmentalWaterManagementService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalWaterManagement get(String id, boolean isNewRecord) {
		return szEnvironmentalWaterManagementService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalWaterManagement:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement, Model model) {
		model.addAttribute("szEnvironmentalWaterManagement", szEnvironmentalWaterManagement);
		return "modules/sz/szEnvironmentalWaterManagementList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalWaterManagement:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalWaterManagement> listData(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalWaterManagement.setPage(new Page<>(request, response));
		Page<SzEnvironmentalWaterManagement> page = szEnvironmentalWaterManagementService.findPage(szEnvironmentalWaterManagement);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalWaterManagement:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement, Model model) {
		model.addAttribute("szEnvironmentalWaterManagement", szEnvironmentalWaterManagement);
		return "modules/sz/szEnvironmentalWaterManagementForm";
	}

	/**
	 * 保存自来水厂信息
	 */
	@RequiresPermissions("sz:szEnvironmentalWaterManagement:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		szEnvironmentalWaterManagementService.save(szEnvironmentalWaterManagement);
		return renderResult(Global.TRUE, text("保存自来水厂信息成功！"));
	}
	
	/**
	 * 删除自来水厂信息
	 */
	@RequiresPermissions("sz:szEnvironmentalWaterManagement:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		szEnvironmentalWaterManagementService.delete(szEnvironmentalWaterManagement);
		return renderResult(Global.TRUE, text("删除自来水厂信息成功！"));
	}
	
}