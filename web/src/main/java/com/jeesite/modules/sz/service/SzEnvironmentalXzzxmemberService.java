/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalXzzxmember;
import com.jeesite.modules.sz.dao.SzEnvironmentalXzzxmemberDao;

/**
 * 银川市机关单位信息Service
 * @author myj
 * @version 2020-07-28
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalXzzxmemberService extends CrudService<SzEnvironmentalXzzxmemberDao, SzEnvironmentalXzzxmember> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalXzzxmember
	 * @return
	 */
	@Override
	public SzEnvironmentalXzzxmember get(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		return super.get(szEnvironmentalXzzxmember);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalXzzxmember 查询条件
	 * @param szEnvironmentalXzzxmember.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalXzzxmember> findPage(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		return super.findPage(szEnvironmentalXzzxmember);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalXzzxmember
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		super.save(szEnvironmentalXzzxmember);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalXzzxmember
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		super.updateStatus(szEnvironmentalXzzxmember);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalXzzxmember
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalXzzxmember szEnvironmentalXzzxmember) {
		super.delete(szEnvironmentalXzzxmember);
	}
	
}