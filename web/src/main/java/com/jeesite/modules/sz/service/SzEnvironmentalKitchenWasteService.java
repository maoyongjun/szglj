/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalKitchenWaste;
import com.jeesite.modules.sz.dao.SzEnvironmentalKitchenWasteDao;

/**
 * 餐厨垃圾处理情况Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalKitchenWasteService extends CrudService<SzEnvironmentalKitchenWasteDao, SzEnvironmentalKitchenWaste> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalKitchenWaste
	 * @return
	 */
	@Override
	public SzEnvironmentalKitchenWaste get(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		return super.get(szEnvironmentalKitchenWaste);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalKitchenWaste 查询条件
	 * @param szEnvironmentalKitchenWaste.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalKitchenWaste> findPage(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		return super.findPage(szEnvironmentalKitchenWaste);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalKitchenWaste
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		super.save(szEnvironmentalKitchenWaste);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalKitchenWaste
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		super.updateStatus(szEnvironmentalKitchenWaste);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalKitchenWaste
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalKitchenWaste szEnvironmentalKitchenWaste) {
		super.delete(szEnvironmentalKitchenWaste);
	}
	
}