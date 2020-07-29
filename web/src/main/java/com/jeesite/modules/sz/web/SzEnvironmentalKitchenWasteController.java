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
import com.jeesite.modules.sz.entity.SzEnvironmentalKitchenWaste;
import com.jeesite.modules.sz.service.SzEnvironmentalKitchenWasteService;

/**
 * 餐厨垃圾处理情况Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalKitchenWaste")
public class SzEnvironmentalKitchenWasteController extends BaseController {

	@Autowired
	private SzEnvironmentalKitchenWasteService szEnvironmentalKitchenWasteService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalKitchenWaste get(String id, boolean isNewRecord) {
		return szEnvironmentalKitchenWasteService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalKitchenWaste:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste, Model model) {
		model.addAttribute("szEnvironmentalKitchenWaste", szEnvironmentalKitchenWaste);
		return "modules/sz/szEnvironmentalKitchenWasteList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalKitchenWaste:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalKitchenWaste> listData(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalKitchenWaste.setPage(new Page<>(request, response));
		Page<SzEnvironmentalKitchenWaste> page = szEnvironmentalKitchenWasteService.findPage(szEnvironmentalKitchenWaste);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalKitchenWaste:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste, Model model) {
		model.addAttribute("szEnvironmentalKitchenWaste", szEnvironmentalKitchenWaste);
		return "modules/sz/szEnvironmentalKitchenWasteForm";
	}

	/**
	 * 保存餐厨垃圾处理情况
	 */
	@RequiresPermissions("sz:szEnvironmentalKitchenWaste:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		szEnvironmentalKitchenWasteService.save(szEnvironmentalKitchenWaste);
		return renderResult(Global.TRUE, text("保存餐厨垃圾处理情况成功！"));
	}
	
	/**
	 * 删除餐厨垃圾处理情况
	 */
	@RequiresPermissions("sz:szEnvironmentalKitchenWaste:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		szEnvironmentalKitchenWasteService.delete(szEnvironmentalKitchenWaste);
		return renderResult(Global.TRUE, text("删除餐厨垃圾处理情况成功！"));
	}
	
}