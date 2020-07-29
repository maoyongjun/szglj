/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sz.entity.SzEnvironmentalSewageDisposal;

/**
 * 污水厂信息DAO接口
 * @author myj
 * @version 2020-06-10
 */
@MyBatisDao
public interface SzEnvironmentalSewageDisposalDao extends CrudDao<SzEnvironmentalSewageDisposal> {
	
}