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
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunityupload;
import com.jeesite.modules.sz.service.SzEnvironmentalCommunityuploadService;

/**
 * 试点社区每日厨余垃圾与资源垃圾处置Controller
 * @author myj
 * @version 2020-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalCommunityupload")
public class SzEnvironmentalCommunityuploadController extends BaseController {

	@Autowired
	private SzEnvironmentalCommunityuploadService szEnvironmentalCommunityuploadService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalCommunityupload get(String id, boolean isNewRecord) {
		return szEnvironmentalCommunityuploadService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunityupload:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload, Model model) {
		model.addAttribute("szEnvironmentalCommunityupload", szEnvironmentalCommunityupload);
		return "modules/sz/szEnvironmentalCommunityuploadList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunityupload:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalCommunityupload> listData(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalCommunityupload.setPage(new Page<>(request, response));
		Page<SzEnvironmentalCommunityupload> page = szEnvironmentalCommunityuploadService.findPage(szEnvironmentalCommunityupload);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunityupload:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload, Model model) {
		model.addAttribute("szEnvironmentalCommunityupload", szEnvironmentalCommunityupload);
		return "modules/sz/szEnvironmentalCommunityuploadForm";
	}

	/**
	 * 保存试点社区每日厨余垃圾与资源垃圾处置
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunityupload:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		szEnvironmentalCommunityuploadService.save(szEnvironmentalCommunityupload);
		return renderResult(Global.TRUE, text("保存试点社区每日厨余垃圾与资源垃圾处置成功！"));
	}
	
	/**
	 * 删除试点社区每日厨余垃圾与资源垃圾处置
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunityupload:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		szEnvironmentalCommunityuploadService.delete(szEnvironmentalCommunityupload);
		return renderResult(Global.TRUE, text("删除试点社区每日厨余垃圾与资源垃圾处置成功！"));
	}
	
}