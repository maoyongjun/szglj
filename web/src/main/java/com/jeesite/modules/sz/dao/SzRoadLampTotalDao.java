/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sz.entity.SzRoadLampTotal;

/**
 * 路灯统计DAO接口
 * @author myj
 * @version 2020-07-03
 */
@MyBatisDao
public interface SzRoadLampTotalDao extends CrudDao<SzRoadLampTotal> {
	
}