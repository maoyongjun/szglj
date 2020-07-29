package com.jeesite.test;

import com.jeesite.common.codec.DesUtils;
import com.jeesite.common.tests.BaseSpringContextTests;
import com.jeesite.modules.Application;
import com.jeesite.modules.sys.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest(classes= Application.class)
public class PasswordTest extends BaseSpringContextTests {

    @Autowired
    private UserService userService;
    @Test
    public void test(){
        String pwd = DesUtils.decode("235880C505ACCDA5C581A4F4CDB81DA0", "thinkgem,jeesite,com");
        String key =   DesUtils.encode("admin", "thinkgem,jeesite,com");
        System.out.println(pwd);
        System.out.println(key);
        userService.updatePassword("user17_m8o5", "111112");
        //7a87d4ea8ead6e1aa3ea4eff1bb51c3a8351ad41916aff456ae8b282
    }

}
