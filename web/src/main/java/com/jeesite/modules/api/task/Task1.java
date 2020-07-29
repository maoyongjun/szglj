package com.jeesite.modules.api.task;

import com.jeesite.modules.api.aop.APIRecordAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试静态方法调用
 */
public class Task1 {

    private static final Logger log = LoggerFactory.getLogger(APIRecordAspect.class);

    public static  void syncData(){
        log.info("Task1:同步数据开始");

        log.info("Task1:同步数据结束");

    }

}
