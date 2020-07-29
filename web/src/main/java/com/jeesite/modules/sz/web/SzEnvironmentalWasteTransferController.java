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
import com.jeesite.modules.sz.entity.SzEnvironmentalWasteTransfer;
import com.jeesite.modules.sz.service.SzEnvironmentalWasteTransferService;

/**
 * 垃圾中转站信息Controller
 * @author myj
 * @version 2020-06-10
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalWasteTransfer")
public class SzEnvironmentalWasteTransferController extends BaseController {

	@Autowired
	private SzEnvironmentalWasteTransferService szEnvironmentalWasteTransferService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalWasteTransfer get(String id, boolean isNewRecord) {
		return szEnvironmentalWasteTransferService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalWasteTransfer:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer, Model model) {
		model.addAttribute("szEnvironmentalWasteTransfer", szEnvironmentalWasteTransfer);
		return "modules/sz/szEnvironmentalWasteTransferList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalWasteTransfer:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalWasteTransfer> listData(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalWasteTransfer.setPage(new Page<>(request, response));
		Page<SzEnvironmentalWasteTransfer> page = szEnvironmentalWasteTransferService.findPage(szEnvironmentalWasteTransfer);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalWasteTransfer:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer, Model model) {
		model.addAttribute("szEnvironmentalWasteTransfer", szEnvironmentalWasteTransfer);
		return "modules/sz/szEnvironmentalWasteTransferForm";
	}

	/**
	 * 保存垃圾中转站信息
	 */
	@RequiresPermissions("sz:szEnvironmentalWasteTransfer:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		szEnvironmentalWasteTransferService.save(szEnvironmentalWasteTransfer);
		return renderResult(Global.TRUE, text("保存垃圾中转站信息成功！"));
	}
	
	/**
	 * 删除垃圾中转站信息
	 */
	@RequiresPermissions("sz:szEnvironmentalWasteTransfer:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		szEnvironmentalWasteTransferService.delete(szEnvironmentalWasteTransfer);
		return renderResult(Global.TRUE, text("删除垃圾中转站信息成功！"));
	}
	
}