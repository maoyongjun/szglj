/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzRoadLamp;
import com.jeesite.modules.sz.dao.SzRoadLampDao;

/**
 * 路灯信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzRoadLampService extends CrudService<SzRoadLampDao, SzRoadLamp> {
	
	/**
	 * 获取单条数据
	 * @param szRoadLamp
	 * @return
	 */
	@Override
	public SzRoadLamp get(SzRoadLamp szRoadLamp) {
		return super.get(szRoadLamp);
	}
	
	/**
	 * 查询分页数据
	 * @param szRoadLamp 查询条件
	 * @param szRoadLamp.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzRoadLamp> findPage(SzRoadLamp szRoadLamp) {
		return super.findPage(szRoadLamp);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szRoadLamp
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzRoadLamp szRoadLamp) {
		super.save(szRoadLamp);
	}
	
	/**
	 * 更新状态
	 * @param szRoadLamp
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzRoadLamp szRoadLamp) {
		super.updateStatus(szRoadLamp);
	}
	
	/**
	 * 删除数据
	 * @param szRoadLamp
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzRoadLamp szRoadLamp) {
		super.delete(szRoadLamp);
	}
	
}