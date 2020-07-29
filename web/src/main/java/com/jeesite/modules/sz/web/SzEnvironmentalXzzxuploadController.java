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
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxupload;
import com.jeesite.modules.sz.service.SzEnvironmentalXzzxuploadService;

/**
 * 每日厨余垃圾与资源垃圾处置数据Controller
 * @author myj
 * @version 2020-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalXzzxupload")
public class SzEnvironmentalXzzxuploadController extends BaseController {

	@Autowired
	private SzEnvironmentalXzzxuploadService szEnvironmentalXzzxuploadService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalXzzxupload get(String id, boolean isNewRecord) {
		return szEnvironmentalXzzxuploadService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxupload:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload, Model model) {
		model.addAttribute("szEnvironmentalXzzxupload", szEnvironmentalXzzxupload);
		return "modules/sz/szEnvironmentalXzzxuploadList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxupload:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalXzzxupload> listData(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalXzzxupload.setPage(new Page<>(request, response));
		Page<SzEnvironmentalXzzxupload> page = szEnvironmentalXzzxuploadService.findPage(szEnvironmentalXzzxupload);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxupload:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload, Model model) {
		model.addAttribute("szEnvironmentalXzzxupload", szEnvironmentalXzzxupload);
		return "modules/sz/szEnvironmentalXzzxuploadForm";
	}

	/**
	 * 保存每日厨余垃圾与资源垃圾处置数据
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxupload:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		szEnvironmentalXzzxuploadService.save(szEnvironmentalXzzxupload);
		return renderResult(Global.TRUE, text("保存每日厨余垃圾与资源垃圾处置数据成功！"));
	}
	
	/**
	 * 删除每日厨余垃圾与资源垃圾处置数据
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxupload:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		szEnvironmentalXzzxuploadService.delete(szEnvironmentalXzzxupload);
		return renderResult(Global.TRUE, text("删除每日厨余垃圾与资源垃圾处置数据成功！"));
	}
	
}