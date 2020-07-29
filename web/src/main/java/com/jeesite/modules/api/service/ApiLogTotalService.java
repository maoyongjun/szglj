/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.api.entity.ApiLogTotal;
import com.jeesite.modules.api.dao.ApiLogTotalDao;

/**
 * api访问次数统计表Service
 * @author myj
 * @version 2020-05-29
 */
@Service
@Transactional(readOnly=true)
public class ApiLogTotalService extends CrudService<ApiLogTotalDao, ApiLogTotal> {
	
	/**
	 * 获取单条数据
	 * @param apiLogTotal
	 * @return
	 */
	@Override
	public ApiLogTotal get(ApiLogTotal apiLogTotal) {
		return super.get(apiLogTotal);
	}
	
	/**
	 * 查询分页数据
	 * @param apiLogTotal 查询条件
	 * @param apiLogTotal.page 分页对象
	 * @return
	 */
	@Override
	public Page<ApiLogTotal> findPage(ApiLogTotal apiLogTotal) {
		return super.findPage(apiLogTotal);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param apiLogTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ApiLogTotal apiLogTotal) {
		super.save(apiLogTotal);
	}
	
	/**
	 * 更新状态
	 * @param apiLogTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ApiLogTotal apiLogTotal) {
		super.updateStatus(apiLogTotal);
	}
	
	/**
	 * 删除数据
	 * @param apiLogTotal
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ApiLogTotal apiLogTotal) {
		super.delete(apiLogTotal);
	}
	
}