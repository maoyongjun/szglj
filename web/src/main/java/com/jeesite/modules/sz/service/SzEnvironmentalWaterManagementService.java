/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalWaterManagement;
import com.jeesite.modules.sz.dao.SzEnvironmentalWaterManagementDao;

/**
 * 自来水厂信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalWaterManagementService extends CrudService<SzEnvironmentalWaterManagementDao, SzEnvironmentalWaterManagement> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalWaterManagement
	 * @return
	 */
	@Override
	public SzEnvironmentalWaterManagement get(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		return super.get(szEnvironmentalWaterManagement);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalWaterManagement 查询条件
	 * @param szEnvironmentalWaterManagement.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalWaterManagement> findPage(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		return super.findPage(szEnvironmentalWaterManagement);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalWaterManagement
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		super.save(szEnvironmentalWaterManagement);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalWaterManagement
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		super.updateStatus(szEnvironmentalWaterManagement);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalWaterManagement
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalWaterManagement szEnvironmentalWaterManagement) {
		super.delete(szEnvironmentalWaterManagement);
	}
	
}