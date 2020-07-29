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
import com.jeesite.modules.sz.entity.SzRoadLampTotal;
import com.jeesite.modules.sz.service.SzRoadLampTotalService;

/**
 * 路灯统计Controller
 * @author myj
 * @version 2020-07-03
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szRoadLampTotal")
public class SzRoadLampTotalController extends BaseController {

	@Autowired
	private SzRoadLampTotalService szRoadLampTotalService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzRoadLampTotal get(String id, boolean isNewRecord) {
		return szRoadLampTotalService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szRoadLampTotal:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzRoadLampTotal szRoadLampTotal, Model model) {
		model.addAttribute("szRoadLampTotal", szRoadLampTotal);
		return "modules/sz/szRoadLampTotalList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szRoadLampTotal:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzRoadLampTotal> listData(SzRoadLampTotal szRoadLampTotal, HttpServletRequest request, HttpServletResponse response) {
		szRoadLampTotal.setPage(new Page<>(request, response));
		Page<SzRoadLampTotal> page = szRoadLampTotalService.findPage(szRoadLampTotal);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szRoadLampTotal:view")
	@RequestMapping(value = "form")
	public String form(SzRoadLampTotal szRoadLampTotal, Model model) {
		model.addAttribute("szRoadLampTotal", szRoadLampTotal);
		return "modules/sz/szRoadLampTotalForm";
	}

	/**
	 * 保存路灯统计
	 */
	@RequiresPermissions("sz:szRoadLampTotal:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzRoadLampTotal szRoadLampTotal) {
		szRoadLampTotalService.save(szRoadLampTotal);
		return renderResult(Global.TRUE, text("保存路灯统计成功！"));
	}
	
	/**
	 * 删除路灯统计
	 */
	@RequiresPermissions("sz:szRoadLampTotal:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzRoadLampTotal szRoadLampTotal) {
		szRoadLampTotalService.delete(szRoadLampTotal);
		return renderResult(Global.TRUE, text("删除路灯统计成功！"));
	}
	
}