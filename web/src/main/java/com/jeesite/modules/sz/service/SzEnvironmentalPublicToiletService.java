/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sz.entity.SzEnvironmentalPublicToilet;
import com.jeesite.modules.sz.dao.SzEnvironmentalPublicToiletDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 公厕信息Service
 * @author myj
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly=true)
public class SzEnvironmentalPublicToiletService extends CrudService<SzEnvironmentalPublicToiletDao, SzEnvironmentalPublicToilet> {
	
	/**
	 * 获取单条数据
	 * @param szEnvironmentalPublicToilet
	 * @return
	 */
	@Override
	public SzEnvironmentalPublicToilet get(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		return super.get(szEnvironmentalPublicToilet);
	}
	
	/**
	 * 查询分页数据
	 * @param szEnvironmentalPublicToilet 查询条件
	 * @param szEnvironmentalPublicToilet.page 分页对象
	 * @return
	 */
	@Override
	public Page<SzEnvironmentalPublicToilet> findPage(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		return super.findPage(szEnvironmentalPublicToilet);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param szEnvironmentalPublicToilet
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		super.save(szEnvironmentalPublicToilet);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(szEnvironmentalPublicToilet.getId(), "szEnvironmentalPublicToilet_image");
	}
	
	/**
	 * 更新状态
	 * @param szEnvironmentalPublicToilet
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		super.updateStatus(szEnvironmentalPublicToilet);
	}
	
	/**
	 * 删除数据
	 * @param szEnvironmentalPublicToilet
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(SzEnvironmentalPublicToilet szEnvironmentalPublicToilet) {
		super.delete(szEnvironmentalPublicToilet);
	}
	
}