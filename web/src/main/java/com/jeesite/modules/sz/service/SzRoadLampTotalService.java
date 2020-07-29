/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzRoadLampTotal;
import com.jeesite.modules.sz.dao.SzRoadLampTotalDao;

/**
 * 路灯统计Service
 * @author myj
 * @version 2020-07-03
 */
@Service
@Transactional(readOnly=true)
public class SzRoadLampTotalService extends CrudService<SzRoadLampTotalDao, SzRoadLampTotal> {
	
	/**
	 * 获取单条数据
	 * @param szRoadLampTotal
	 * @return
	 */
	@Override
	public SzRoadLampTotal get(SzRoadLampTotal szRoadLampTotal) {
		return super.get(szRoadLampTotal);
	}
	
	/**
	 * 查询分页数据
	 * @param szRoadLampTotal 查询条件
	 * @param szRoadLampTotal.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzRoadLampTotal> findPage(SzRoadLampTotal szRoadLampTotal) {
		return super.findPage(szRoadLampTotal);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szRoadLampTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzRoadLampTotal szRoadLampTotal) {
		super.save(szRoadLampTotal);
	}
	
	/**
	 * 更新状态
	 * @param szRoadLampTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzRoadLampTotal szRoadLampTotal) {
		super.updateStatus(szRoadLampTotal);
	}
	
	/**
	 * 删除数据
	 * @param szRoadLampTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzRoadLampTotal szRoadLampTotal) {
		super.delete(szRoadLampTotal);
	}
	
}