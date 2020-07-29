/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalHeatingCenter;
import com.jeesite.modules.sz.dao.SzEnvironmentalHeatingCenterDao;

/**
 * 供热信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalHeatingCenterService extends CrudService<SzEnvironmentalHeatingCenterDao, SzEnvironmentalHeatingCenter> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalHeatingCenter
	 * @return
	 */
	@Override
	public SzEnvironmentalHeatingCenter get(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		return super.get(szEnvironmentalHeatingCenter);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalHeatingCenter 查询条件
	 * @param szEnvironmentalHeatingCenter.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalHeatingCenter> findPage(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		return super.findPage(szEnvironmentalHeatingCenter);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalHeatingCenter
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		super.save(szEnvironmentalHeatingCenter);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalHeatingCenter
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		super.updateStatus(szEnvironmentalHeatingCenter);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalHeatingCenter
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalHeatingCenter szEnvironmentalHeatingCenter) {
		super.delete(szEnvironmentalHeatingCenter);
	}
	
}