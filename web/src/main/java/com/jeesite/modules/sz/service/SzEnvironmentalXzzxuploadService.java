/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxupload;
import com.jeesite.modules.sz.dao.SzEnvironmentalXzzxuploadDao;

/**
 * 每日厨余垃圾与资源垃圾处置数据Service
 * @author myj
 * @version 2020-07-28
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalXzzxuploadService extends CrudService<SzEnvironmentalXzzxuploadDao, SzEnvironmentalXzzxupload> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalXzzxupload
	 * @return
	 */
	@Override
	public SzEnvironmentalXzzxupload get(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		return super.get(szEnvironmentalXzzxupload);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalXzzxupload 查询条件
	 * @param szEnvironmentalXzzxupload.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalXzzxupload> findPage(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		return super.findPage(szEnvironmentalXzzxupload);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalXzzxupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		super.save(szEnvironmentalXzzxupload);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalXzzxupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		super.updateStatus(szEnvironmentalXzzxupload);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalXzzxupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalXzzxupload szEnvironmentalXzzxupload) {
		super.delete(szEnvironmentalXzzxupload);
	}
	
}