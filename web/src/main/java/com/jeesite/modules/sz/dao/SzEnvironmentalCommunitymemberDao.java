/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.sz.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sz.entity.SzEnvironmentalCommunitymember;

/**
 * 试点社区信息DAO接口
 * @author myj
 * @version 2020-07-28
 */
@MyBatisDao
public interface SzEnvironmentalCommunitymemberDao extends CrudDao<SzEnvironmentalCommunitymember> {
	
}