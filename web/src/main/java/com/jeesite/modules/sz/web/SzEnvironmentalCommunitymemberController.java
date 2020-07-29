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
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunitymember;
import com.jeesite.modules.sz.service.SzEnvironmentalCommunitymemberService;

/**
 * 试点社区信息Controller
 * @author myj
 * @version 2020-07-28
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szEnvironmentalCommunitymember")
public class SzEnvironmentalCommunitymemberController extends BaseController {

	@Autowired
	private SzEnvironmentalCommunitymemberService szEnvironmentalCommunitymemberService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzEnvironmentalCommunitymember get(String id, boolean isNewRecord) {
		return szEnvironmentalCommunitymemberService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunitymember:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember, Model model) {
		model.addAttribute("szEnvironmentalCommunitymember", szEnvironmentalCommunitymember);
		return "modules/sz/szEnvironmentalCommunitymemberList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunitymember:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzEnvironmentalCommunitymember> listData(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember, HttpServletRequest request, HttpServletResponse response) {
		szEnvironmentalCommunitymember.setPage(new Page<>(request, response));
		Page<SzEnvironmentalCommunitymember> page = szEnvironmentalCommunitymemberService.findPage(szEnvironmentalCommunitymember);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunitymember:view")
	@RequestMapping(value = "form")
	public String form(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember, Model model) {
		model.addAttribute("szEnvironmentalCommunitymember", szEnvironmentalCommunitymember);
		return "modules/sz/szEnvironmentalCommunitymemberForm";
	}

	/**
	 * 保存试点社区信息
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunitymember:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		szEnvironmentalCommunitymemberService.save(szEnvironmentalCommunitymember);
		return renderResult(Global.TRUE, text("保存试点社区信息成功！"));
	}
	
	/**
	 * 删除试点社区信息
	 */
	@RequiresPermissions("sz:szEnvironmentalCommunitymember:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		szEnvironmentalCommunitymemberService.delete(szEnvironmentalCommunitymember);
		return renderResult(Global.TRUE, text("删除试点社区信息成功！"));
	}
	
}