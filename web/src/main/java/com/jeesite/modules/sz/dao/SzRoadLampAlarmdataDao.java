/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sz.entity.SzRoadLampAlarmdata;

/**
 * 报警数据DAO接口
 * @author myj
 * @version 2020-06-30
 */
@MyBatisDao
public interface SzRoadLampAlarmdataDao extends CrudDao<SzRoadLampAlarmdata> {
	
}