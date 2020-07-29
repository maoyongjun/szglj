/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sz.entity.SzAnnualCollection;

/**
 * 逐年征收情况DAO接口
 * @author myj
 * @version 2020-07-11
 */
@MyBatisDao
public interface SzAnnualCollectionDao extends CrudDao<SzAnnualCollection> {
	
}