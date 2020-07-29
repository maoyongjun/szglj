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
import com.jeesite.modules.sz.entity.SzRoadLampAlarmdata;
import com.jeesite.modules.sz.service.SzRoadLampAlarmdataService;

/**
 * 报警数据Controller
 * @author myj
 * @version 2020-06-30
 */
@Controller
@RequestMapping(value = "${adminPath}/sz/szRoadLampAlarmdata")
public class SzRoadLampAlarmdataController extends BaseController {

	@Autowired
	private SzRoadLampAlarmdataService szRoadLampAlarmdataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public SzRoadLampAlarmdata get(String id, boolean isNewRecord) {
		return szRoadLampAlarmdataService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("sz:szRoadLampAlarmdata:view")
	@RequestMapping(value = {"list", ""})
	public String list(SzRoadLampAlarmdata szRoadLampAlarmdata, Model model) {
		model.addAttribute("szRoadLampAlarmdata", szRoadLampAlarmdata);
		return "modules/sz/szRoadLampAlarmdataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("sz:szRoadLampAlarmdata:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<SzRoadLampAlarmdata> listData(SzRoadLampAlarmdata szRoadLampAlarmdata, HttpServletRequest request, HttpServletResponse response) {
		szRoadLampAlarmdata.setPage(new Page<>(request, response));
		Page<SzRoadLampAlarmdata> page = szRoadLampAlarmdataService.findPage(szRoadLampAlarmdata);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("sz:szRoadLampAlarmdata:view")
	@RequestMapping(value = "form")
	public String form(SzRoadLampAlarmdata szRoadLampAlarmdata, Model model) {
		model.addAttribute("szRoadLampAlarmdata", szRoadLampAlarmdata);
		return "modules/sz/szRoadLampAlarmdataForm";
	}

	/**
	 * 保存报警数据
	 */
	@RequiresPermissions("sz:szRoadLampAlarmdata:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated SzRoadLampAlarmdata szRoadLampAlarmdata) {
		szRoadLampAlarmdataService.save(szRoadLampAlarmdata);
		return renderResult(Global.TRUE, text("保存报警数据成功！"));
	}
	
	/**
	 * 删除报警数据
	 */
	@RequiresPermissions("sz:szRoadLampAlarmdata:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		szRoadLampAlarmdataService.delete(szRoadLampAlarmdata);
		return renderResult(Global.TRUE, text("删除报警数据成功！"));
	}
	
}