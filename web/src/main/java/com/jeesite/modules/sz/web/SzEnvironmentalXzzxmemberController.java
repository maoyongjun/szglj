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
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxmember;
import com.jeesite.modules.sz.service.SzEnvironmentalXzzxmemberService;

/**
 * 银川市机关单位信息Controller
 * @author myj
 * @version 2020-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalXzzxmember")
public class SzEnvironmentalXzzxmemberController extends BaseController {

	@Autowired
	private SzEnvironmentalXzzxmemberService szEnvironmentalXzzxmemberService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalXzzxmember get(String id, boolean isNewRecord) {
		return szEnvironmentalXzzxmemberService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxmember:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember, Model model) {
		model.addAttribute("szEnvironmentalXzzxmember", szEnvironmentalXzzxmember);
		return "modules/sz/szEnvironmentalXzzxmemberList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxmember:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalXzzxmember> listData(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalXzzxmember.setPage(new Page<>(request, response));
		Page<SzEnvironmentalXzzxmember> page = szEnvironmentalXzzxmemberService.findPage(szEnvironmentalXzzxmember);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxmember:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember, Model model) {
		model.addAttribute("szEnvironmentalXzzxmember", szEnvironmentalXzzxmember);
		return "modules/sz/szEnvironmentalXzzxmemberForm";
	}

	/**
	 * 保存银川市机关单位信息
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxmember:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		szEnvironmentalXzzxmemberService.save(szEnvironmentalXzzxmember);
		return renderResult(Global.TRUE, text("保存银川市机关单位信息成功！"));
	}
	
	/**
	 * 删除银川市机关单位信息
	 */
	@RequiresPermissions("sz:szEnvironmentalXzzxmember:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		szEnvironmentalXzzxmemberService.delete(szEnvironmentalXzzxmember);
		return renderResult(Global.TRUE, text("删除银川市机关单位信息成功！"));
	}
	
}