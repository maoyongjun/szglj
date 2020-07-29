/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalWasteTransfer;
import com.jeesite.modules.sz.dao.SzEnvironmentalWasteTransferDao;

/**
 * 垃圾中转站信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalWasteTransferService extends CrudService<SzEnvironmentalWasteTransferDao, SzEnvironmentalWasteTransfer> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalWasteTransfer
	 * @return
	 */
	@Override
	public SzEnvironmentalWasteTransfer get(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		return super.get(szEnvironmentalWasteTransfer);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalWasteTransfer 查询条件
	 * @param szEnvironmentalWasteTransfer.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalWasteTransfer> findPage(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		return super.findPage(szEnvironmentalWasteTransfer);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalWasteTransfer
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		super.save(szEnvironmentalWasteTransfer);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalWasteTransfer
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		super.updateStatus(szEnvironmentalWasteTransfer);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalWasteTransfer
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalWasteTransfer szEnvironmentalWasteTransfer) {
		super.delete(szEnvironmentalWasteTransfer);
	}
	
}