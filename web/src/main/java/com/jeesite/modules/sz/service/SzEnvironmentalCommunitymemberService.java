/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunitymember;
import com.jeesite.modules.sz.dao.SzEnvironmentalCommunitymemberDao;

/**
 * 试点社区信息Service
 * @author myj
 * @version 2020-07-28
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalCommunitymemberService extends CrudService<SzEnvironmentalCommunitymemberDao, SzEnvironmentalCommunitymember> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalCommunitymember
	 * @return
	 */
	@Override
	public SzEnvironmentalCommunitymember get(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		return super.get(szEnvironmentalCommunitymember);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalCommunitymember 查询条件
	 * @param szEnvironmentalCommunitymember.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalCommunitymember> findPage(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		return super.findPage(szEnvironmentalCommunitymember);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalCommunitymember
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		super.save(szEnvironmentalCommunitymember);
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalCommunitymember
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		super.updateStatus(szEnvironmentalCommunitymember);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalCommunitymember
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalCommunitymember szEnvironmentalCommunitymember) {
		super.delete(szEnvironmentalCommunitymember);
	}
	
}