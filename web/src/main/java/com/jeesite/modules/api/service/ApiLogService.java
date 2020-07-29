/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.api.entity.ApiLog;
import com.jeesite.modules.api.dao.ApiLogDao;

/**
 * api访问记录Service
 * @author myj
 * @version 2020-05-29
 */
@Service
@Transactional(readOnly=true)
public class ApiLogService extends CrudService<ApiLogDao, ApiLog> {
	
	/**
	 * 获取单条数据
	 * @param apiLog
	 * @return
	 */
	@Override
	public ApiLog get(ApiLog apiLog) {
		return super.get(apiLog);
	}
	
	/**
	 * 查询分页数据
	 * @param apiLog 查询条件
	 * @param apiLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<ApiLog> findPage(ApiLog apiLog) {
		return super.findPage(apiLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param apiLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ApiLog apiLog) {
		super.save(apiLog);
	}
	
	/**
	 * 更新状态
	 * @param apiLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ApiLog apiLog) {
		super.updateStatus(apiLog);
	}
	
	/**
	 * 删除数据
	 * @param apiLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ApiLog apiLog) {
		super.delete(apiLog);
	}
	
}