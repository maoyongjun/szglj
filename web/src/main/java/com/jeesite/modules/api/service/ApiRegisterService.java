/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.service;

import com.jeesite.common.collect.MapUtils;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.service.CrudService;
import com.jeesite.common.service.ServiceException;
import com.jeesite.modules.api.dao.ApiRegisterDao;
import com.jeesite.modules.api.entity.ApiRegister;
import com.jeesite.modules.bpm.utils.BpmUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * api注册记录Service
 * @author myj
 * @version 2020-05-29
 */
@Service
@Transactional(readOnly=true)
public class ApiRegisterService extends CrudService<ApiRegisterDao, ApiRegister> {
	
	/**
	 * 获取单条数据
	 * @param apiRegister
	 * @return
	 */
	@Override
	public ApiRegister get(ApiRegister apiRegister) {
		return super.get(apiRegister);
	}
	
	/**
	 * 查询分页数据
	 * @param apiRegister 查询条件
	 * @param apiRegister.page 分页对象
	 * @return
	 */
	@Override
	public Page<ApiRegister> findPage(ApiRegister apiRegister) {
		return super.findPage(apiRegister);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param apiRegister
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ApiRegister apiRegister) {
		// 如果未设置状态，则指定状态为审核状态，以提交审核流程
		if (StringUtils.isBlank(apiRegister.getStatus())){
			apiRegister.setStatus(apiRegister.STATUS_AUDIT);
		}

		// 如果状态为正常，则代表不正常操作，可能前端进行了数据参数修改
		if (apiRegister.STATUS_NORMAL.equals(apiRegister.getStatus())){
			throw new ServiceException(text("非法操作，前端数据被劫持！"));
		}

		// 如果状态为草稿或审核状态，才可以保存业务数据
		if (apiRegister.STATUS_DRAFT.equals(apiRegister.getStatus())
				|| apiRegister.STATUS_AUDIT.equals(apiRegister.getStatus())){
			super.save(apiRegister);
		}

		// 如果为审核状态，则进行审批流操作
		if (apiRegister.STATUS_AUDIT.equals(apiRegister.getStatus())){

			// 指定请假天数流程变量，作为流程条件，决定流转方向
			Map<String, Object> variables = MapUtils.newHashMap();
//			variables.put("leaveDays", apiRegister.getLeaveDays());

			// 如果流程实例为空，任务编号也为空，则：启动流程
			if (StringUtils.isBlank(apiRegister.getBpm().getProcInsId())
					&& StringUtils.isBlank(apiRegister.getBpm().getTaskId())){
				BpmUtils.start(apiRegister, "API_SH", variables, null);
			}
			// 如果有任务信息，则：提交任务
			else{
				BpmUtils.complete(apiRegister, variables, null);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param apiRegister
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ApiRegister apiRegister) {
		super.updateStatus(apiRegister);
	}
	
	/**
	 * 删除数据
	 * @param apiRegister
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ApiRegister apiRegister) {
		super.delete(apiRegister);
	}
	
}