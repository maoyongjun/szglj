package com.jeesite.modules.wxapp.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.wxapp.dao.WxUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chang
 * @version 2020-06-10
 */
@Service
@Transactional(readOnly = true)
public class WxUserService extends CrudService<WxUserDao, User> {

    @Autowired
    private WxUserDao wxUserDao;

    public User getUserByOpenId(String openId){
    	return wxUserDao.getUserByOpenId(openId);
	}



}