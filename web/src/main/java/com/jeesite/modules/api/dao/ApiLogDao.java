/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.api.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.api.entity.ApiLog;

/**
 * api访问记录DAO接口
 * @author myj
 * @version 2020-05-29
 */
@MyBatisDao
public interface ApiLogDao extends CrudDao<ApiLog> {
	
}