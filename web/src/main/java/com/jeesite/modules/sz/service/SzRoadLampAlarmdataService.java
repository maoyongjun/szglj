/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzRoadLampAlarmdata;
import com.jeesite.modules.sz.dao.SzRoadLampAlarmdataDao;

/**
 * 报警数据Service
 * @author myj
 * @version 2020-06-30
 */
@Service
@Transactional(readOnly=true)
public class SzRoadLampAlarmdataService extends CrudService<SzRoadLampAlarmdataDao, SzRoadLampAlarmdata> {
	
	/**
	 * 获取单条数据
	 * @param szRoadLampAlarmdata
	 * @return
	 */
	@Override
	public SzRoadLampAlarmdata get(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		return super.get(szRoadLampAlarmdata);
	}
	
	/**
	 * 查询分页数据
	 * @param szRoadLampAlarmdata 查询条件
	 * @param szRoadLampAlarmdata.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzRoadLampAlarmdata> findPage(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		return super.findPage(szRoadLampAlarmdata);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szRoadLampAlarmdata
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		super.save(szRoadLampAlarmdata);
	}
	
	/**
	 * 更新状态
	 * @param szRoadLampAlarmdata
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		super.updateStatus(szRoadLampAlarmdata);
	}
	
	/**
	 * 删除数据
	 * @param szRoadLampAlarmdata
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzRoadLampAlarmdata szRoadLampAlarmdata) {
		super.delete(szRoadLampAlarmdata);
	}
	
}