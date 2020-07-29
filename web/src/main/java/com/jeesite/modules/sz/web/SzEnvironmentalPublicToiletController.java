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
import com.jeesite.modules.sz.entity.SzEnvironmentalPublicToilet;
import com.jeesite.modules.sz.service.SzEnvironmentalPublicToiletService;

/**
 * 公厕信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalPublicToilet")
public class SzEnvironmentalPublicToiletController extends BaseController {

	@Autowired
	private SzEnvironmentalPublicToiletService szEnvironmentalPublicToiletService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalPublicToilet get(String id, boolean isNewRecord) {
		return szEnvironmentalPublicToiletService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalPublicToilet:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet, Model model) {
		model.addAttribute("szEnvironmentalPublicToilet", szEnvironmentalPublicToilet);
		return "modules/sz/szEnvironmentalPublicToiletList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalPublicToilet:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalPublicToilet> listData(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalPublicToilet.setPage(new Page<>(request, response));
		Page<SzEnvironmentalPublicToilet> page = szEnvironmentalPublicToiletService.findPage(szEnvironmentalPublicToilet);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalPublicToilet:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet, Model model) {
		model.addAttribute("szEnvironmentalPublicToilet", szEnvironmentalPublicToilet);
		return "modules/sz/szEnvironmentalPublicToiletForm";
	}

	/**
	 * 保存公厕信息
	 */
	@RequiresPermissions("sz:szEnvironmentalPublicToilet:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		szEnvironmentalPublicToiletService.save(szEnvironmentalPublicToilet);
		return renderResult(Global.TRUE, text("保存公厕信息成功！"));
	}
	
	/**
	 * 删除公厕信息
	 */
	@RequiresPermissions("sz:szEnvironmentalPublicToilet:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		szEnvironmentalPublicToiletService.delete(szEnvironmentalPublicToilet);
		return renderResult(Global.TRUE, text("删除公厕信息成功！"));
	}
	
}