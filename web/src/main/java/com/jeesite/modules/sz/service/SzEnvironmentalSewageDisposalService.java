/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalSewageDisposal;
import com.jeesite.modules.sz.dao.SzEnvironmentalSewageDisposalDao;

/**
 * 污水厂信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalSewageDisposalService extends CrudService<SzEnvironmentalSewageDisposalDao, SzEnvironmentalSewageDisposal> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalSewageDisposal
	 * @return
	 */
	@Override
	public SzEnvironmentalSewageDisposal get(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		return super.get(szEnvironmentalSewageDisposal);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalSewageDisposal 查询条件
	 * @param szEnvironmentalSewageDisposal.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalSewageDisposal> findPage(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		return super.findPage(szEnvironmentalSewageDisposal);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalSewageDisposal
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		super.save(szEnvironmentalSewageDisposal);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalSewageDisposal
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		super.updateStatus(szEnvironmentalSewageDisposal);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalSewageDisposal
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalSewageDisposal szEnvironmentalSewageDisposal) {
		super.delete(szEnvironmentalSewageDisposal);
	}
	
}