/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.city.dao.snapshot;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.city.entity.snapshot.CitySnapshot;

/**
 * 随手拍事件DAO接口
 * @author chang
 * @version 2020-06-11
 */
@MyBatisDao
public interface CitySnapshotDao extends CrudDao<CitySnapshot> {
    CitySnapshot getCitySnapshotByUuid(String uuid);
	
}