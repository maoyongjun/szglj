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
import com.jeesite.modules.sz.entity.SzRoadLamp;
import com.jeesite.modules.sz.service.SzRoadLampService;

/**
 * 路灯信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szRoadLamp")
public class SzRoadLampController extends BaseController {

	@Autowired
	private SzRoadLampService szRoadLampService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzRoadLamp get(String id, boolean isNewRecord) {
		return szRoadLampService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szRoadLamp:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzRoadLamp szRoadLamp, Model model) {
		model.addAttribute("szRoadLamp", szRoadLamp);
		return "modules/sz/szRoadLampList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szRoadLamp:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzRoadLamp> listData(SzRoadLamp szRoadLamp, HttpServletRequest request, HttpServletResponse response) {
		szRoadLamp.setPage(new Page<>(request, response));
		Page<SzRoadLamp> page = szRoadLampService.findPage(szRoadLamp);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szRoadLamp:view")
	@RequestMapping(value = "form")
	public String form(SzRoadLamp szRoadLamp, Model model) {
		model.addAttribute("szRoadLamp", szRoadLamp);
		return "modules/sz/szRoadLampForm";
	}

	/**
	 * 保存路灯信息
	 */
	@RequiresPermissions("sz:szRoadLamp:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzRoadLamp szRoadLamp) {
		szRoadLampService.save(szRoadLamp);
		return renderResult(Global.TRUE, text("保存路灯信息成功！"));
	}
	
	/**
	 * 删除路灯信息
	 */
	@RequiresPermissions("sz:szRoadLamp:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzRoadLamp szRoadLamp) {
		szRoadLampService.delete(szRoadLamp);
		return renderResult(Global.TRUE, text("删除路灯信息成功！"));
	}
	
}