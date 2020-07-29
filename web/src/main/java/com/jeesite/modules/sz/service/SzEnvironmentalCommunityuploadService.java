/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunityupload;
import com.jeesite.modules.sz.dao.SzEnvironmentalCommunityuploadDao;

/**
 * 试点社区每日厨余垃圾与资源垃圾处置Service
 * @author myj
 * @version 2020-07-28
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalCommunityuploadService extends CrudService<SzEnvironmentalCommunityuploadDao, SzEnvironmentalCommunityupload> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalCommunityupload
	 * @return
	 */
	@Override
	public SzEnvironmentalCommunityupload get(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		return super.get(szEnvironmentalCommunityupload);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalCommunityupload 查询条件
	 * @param szEnvironmentalCommunityupload.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalCommunityupload> findPage(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		return super.findPage(szEnvironmentalCommunityupload);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalCommunityupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		super.save(szEnvironmentalCommunityupload);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalCommunityupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		super.updateStatus(szEnvironmentalCommunityupload);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalCommunityupload
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalCommunityupload szEnvironmentalCommunityupload) {
		super.delete(szEnvironmentalCommunityupload);
	}
	
}