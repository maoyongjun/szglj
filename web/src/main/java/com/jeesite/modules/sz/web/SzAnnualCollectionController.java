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
import com.jeesite.modules.sz.entity.SzAnnualCollection;
import com.jeesite.modules.sz.service.SzAnnualCollectionService;

/**
 * 逐年征收情况Controller
 * @author myj
 * @version 2020-07-11
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szAnnualCollection")
public class SzAnnualCollectionController extends BaseController {

	@Autowired
	private SzAnnualCollectionService szAnnualCollectionService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzAnnualCollection get(String id, boolean isNewRecord) {
		return szAnnualCollectionService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szAnnualCollection:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzAnnualCollection szAnnualCollection, Model model) {
		model.addAttribute("szAnnualCollection", szAnnualCollection);
		return "modules/sz/szAnnualCollectionList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szAnnualCollection:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzAnnualCollection> listData(SzAnnualCollection szAnnualCollection, HttpServletRequest request, HttpServletResponse response) {
		szAnnualCollection.setPage(new Page<>(request, response));
		Page<SzAnnualCollection> page = szAnnualCollectionService.findPage(szAnnualCollection);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szAnnualCollection:view")
	@RequestMapping(value = "form")
	public String form(SzAnnualCollection szAnnualCollection, Model model) {
		model.addAttribute("szAnnualCollection", szAnnualCollection);
		return "modules/sz/szAnnualCollectionForm";
	}

	/**
	 * 保存逐年征收情况
	 */
	@RequiresPermissions("sz:szAnnualCollection:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzAnnualCollection szAnnualCollection) {
		szAnnualCollectionService.save(szAnnualCollection);
		return renderResult(Global.TRUE, text("保存逐年征收情况成功！"));
	}
	
	/**
	 * 删除逐年征收情况
	 */
	@RequiresPermissions("sz:szAnnualCollection:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzAnnualCollection szAnnualCollection) {
		szAnnualCollectionService.delete(szAnnualCollection);
		return renderResult(Global.TRUE, text("删除逐年征收情况成功！"));
	}
	
}