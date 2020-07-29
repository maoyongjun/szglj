/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzAnnualCollection;
import com.jeesite.modules.sz.dao.SzAnnualCollectionDao;

/**
 * 逐年征收情况Service
 * @author myj
 * @version 2020-07-11
 */
@Service
@Transactional(readOnly=true)
public class SzAnnualCollectionService extends CrudService<SzAnnualCollectionDao, SzAnnualCollection> {
	
	/**
	 * 获取单条数据
	 * @param szAnnualCollection
	 * @return
	 */
	@Override
	public SzAnnualCollection get(SzAnnualCollection szAnnualCollection) {
		return super.get(szAnnualCollection);
	}
	
	/**
	 * 查询分页数据
	 * @param szAnnualCollection 查询条件
	 * @param szAnnualCollection.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzAnnualCollection> findPage(SzAnnualCollection szAnnualCollection) {
		return super.findPage(szAnnualCollection);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szAnnualCollection
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzAnnualCollection szAnnualCollection) {
		super.save(szAnnualCollection);
	}
	
	/**
	 * 更新状态
	 * @param szAnnualCollection
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzAnnualCollection szAnnualCollection) {
		super.updateStatus(szAnnualCollection);
	}
	
	/**
	 * 删除数据
	 * @param szAnnualCollection
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzAnnualCollection szAnnualCollection) {
		super.delete(szAnnualCollection);
	}
	
}