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
import com.jeesite.modules.sz.entity.SzEnvironmentalSewageDisposal;
import com.jeesite.modules.sz.service.SzEnvironmentalSewageDisposalService;

/**
 * 污水厂信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalSewageDisposal")
public class SzEnvironmentalSewageDisposalController extends BaseController {

	@Autowired
	private SzEnvironmentalSewageDisposalService szEnvironmentalSewageDisposalService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalSewageDisposal get(String id, boolean isNewRecord) {
		return szEnvironmentalSewageDisposalService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalSewageDisposal:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal, Model model) {
		model.addAttribute("szEnvironmentalSewageDisposal", szEnvironmentalSewageDisposal);
		return "modules/sz/szEnvironmentalSewageDisposalList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalSewageDisposal:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalSewageDisposal> listData(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalSewageDisposal.setPage(new Page<>(request, response));
		Page<SzEnvironmentalSewageDisposal> page = szEnvironmentalSewageDisposalService.findPage(szEnvironmentalSewageDisposal);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalSewageDisposal:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal, Model model) {
		model.addAttribute("szEnvironmentalSewageDisposal", szEnvironmentalSewageDisposal);
		return "modules/sz/szEnvironmentalSewageDisposalForm";
	}

	/**
	 * 保存污水厂信息
	 */
	@RequiresPermissions("sz:szEnvironmentalSewageDisposal:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		szEnvironmentalSewageDisposalService.save(szEnvironmentalSewageDisposal);
		return renderResult(Global.TRUE, text("保存污水厂信息成功！"));
	}
	
	/**
	 * 删除污水厂信息
	 */
	@RequiresPermissions("sz:szEnvironmentalSewageDisposal:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		szEnvironmentalSewageDisposalService.delete(szEnvironmentalSewageDisposal);
		return renderResult(Global.TRUE, text("删除污水厂信息成功！"));
	}
	
}