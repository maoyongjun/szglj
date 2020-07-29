package com.jeesite.modules.wxapp.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.sys.entity.User;

/**
 * @author chang
 * @version 2020-06-10
 */
@MyBatisDao
public interface WxUserDao extends CrudDao<User> {
    User getUserByOpenId(String openId);
}
