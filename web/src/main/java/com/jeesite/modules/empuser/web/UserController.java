/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.empuser.web;

import com.jeesite.common.codec.DesUtils;
import com.jeesite.common.codec.EncodeUtils;
import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.mapper.JsonMapper;
import com.jeesite.common.service.ServiceException;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.sys.entity.User;
import com.jeesite.modules.sys.service.UserService;
import com.jeesite.modules.sys.utils.PwdUtils;
import com.jeesite.modules.sys.utils.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户Controller
 * @author ThinkGem
 * @version 2017-3-21
 */
//@Controller
//@RequestMapping(value = "${adminPath}/sys/user")
//@ConditionalOnProperty(name="web.core.enabled", havingValue="true", matchIfMissing=true)
//@ApiIgnore
public class UserController extends BaseController {

	@Autowired
	private UserService userService;


	/**
	 * 用户信息 - 保存用户密码
	 */
	@RequiresPermissions("user")
	@PostMapping(value = "infoSavePwd")
	@ResponseBody
	public String infoSavePwd(User user, String oldPassword, String newPassword,
			String confirmNewPassword) {
		User currentUser = UserUtils.getUser();
		// 登录密码解密（解决密码明文传输安全问题）
		String secretKey = Global.getProperty("shiro.loginSubmit.secretKey");
		System.out.println(secretKey);
		if (StringUtils.isNotBlank(secretKey)){
			oldPassword = DesUtils.decode(oldPassword, secretKey);
			newPassword = DesUtils.decode(newPassword, secretKey);
			confirmNewPassword = DesUtils.decode(confirmNewPassword, secretKey);
		}
		// 验证旧密码
		if(!PwdUtils.validatePassword(oldPassword, currentUser.getPassword())){
			return renderResult(Global.FALSE, text("sys.user.oldPasswordError"));
		}
		// 验证新密码和确认密码
		if(!StringUtils.equals(newPassword, confirmNewPassword)){
			return renderResult(Global.FALSE, text("sys.user.confirmPasswrodError"));
		}
		// 更新密码
		try{
			userService.updatePassword(currentUser.getUserCode(), confirmNewPassword);
			return renderResult(Global.TRUE, text("sys.user.passwordModifySuccess"));
		}catch(ServiceException se){
			return renderResult(Global.FALSE, se.getMessage());
		}
	}
	


	
}
