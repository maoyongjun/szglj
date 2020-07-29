package com.jeesite.modules.api.task;

import com.jeesite.modules.api.aop.APIRecordAspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Task2 {

    private  final Logger log = LoggerFactory.getLogger(APIRecordAspect.class);

    public   void syncData(){
        log.info("Task2:同步数据开始");

        log.info("Task2:同步数据结束");

    }


}
