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
import com.jeesite.modules.sz.entity.SzEnvironmentalHeatingCenter;
import com.jeesite.modules.sz.service.SzEnvironmentalHeatingCenterService;

/**
 * 供热信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalHeatingCenter")
public class SzEnvironmentalHeatingCenterController extends BaseController {

	@Autowired
	private SzEnvironmentalHeatingCenterService szEnvironmentalHeatingCenterService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalHeatingCenter get(String id, boolean isNewRecord) {
		return szEnvironmentalHeatingCenterService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalHeatingCenter:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter, Model model) {
		model.addAttribute("szEnvironmentalHeatingCenter", szEnvironmentalHeatingCenter);
		return "modules/sz/szEnvironmentalHeatingCenterList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalHeatingCenter:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalHeatingCenter> listData(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalHeatingCenter.setPage(new Page<>(request, response));
		Page<SzEnvironmentalHeatingCenter> page = szEnvironmentalHeatingCenterService.findPage(szEnvironmentalHeatingCenter);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalHeatingCenter:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter, Model model) {
		model.addAttribute("szEnvironmentalHeatingCenter", szEnvironmentalHeatingCenter);
		return "modules/sz/szEnvironmentalHeatingCenterForm";
	}

	/**
	 * 保存供热信息
	 */
	@RequiresPermissions("sz:szEnvironmentalHeatingCenter:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		szEnvironmentalHeatingCenterService.save(szEnvironmentalHeatingCenter);
		return renderResult(Global.TRUE, text("保存供热信息成功！"));
	}
	
	/**
	 * 删除供热信息
	 */
	@RequiresPermissions("sz:szEnvironmentalHeatingCenter:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		szEnvironmentalHeatingCenterService.delete(szEnvironmentalHeatingCenter);
		return renderResult(Global.TRUE, text("删除供热信息成功！"));
	}
	
}