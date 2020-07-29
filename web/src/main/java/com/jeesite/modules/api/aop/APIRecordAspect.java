package com.jeesite.modules.api.aop;


import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.druid.support.http.WebStatFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeesite.common.aspect.APIRecord;
import com.jeesite.common.web.http.wrapper.XssHttpServletRequestWrapper;
import com.jeesite.modules.api.entity.ApiLog;
import com.jeesite.modules.api.entity.ApiLogTotal;
import com.jeesite.modules.api.service.ApiLogService;
import com.jeesite.modules.api.service.ApiLogTotalService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/***
 *
 * @author myj 拦截所有控制器的返回，记录响应报文
 */
@Aspect
@Configuration
public class APIRecordAspect {
    private static final Logger log = LoggerFactory.getLogger(APIRecordAspect.class);

    @Autowired
    private ApiLogService apiLogService;

    @Autowired
    private ApiLogTotalService apiLogTotalService;

    public APIRecordAspect() {
    }

    @Pointcut("@annotation(com.jeesite.common.aspect.APIRecord)")
    public void pointCutMethod() {
    }

    // 声明环绕通知
    @Around("pointCutMethod()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method targetMethod = signature.getMethod();
        APIRecord apiRecord= targetMethod.getAnnotation(APIRecord.class);
        String controller = pjp.getTarget().getClass().getSimpleName();
        String method = pjp.getSignature().getName();
        ObjectMapper mapper = new ObjectMapper();
        Object[] args =  pjp.getArgs();
        List<Object> requestList = new ArrayList<Object>();
        for(Object arg : args) {
            if (!(arg instanceof XssHttpServletRequestWrapper) && !(arg instanceof WebStatFilter.StatHttpServletResponseWrapper)) {
                requestList.add(arg);
            }
        }
        String request = mapper.writeValueAsString(requestList);
        log.info("<{}.{}>,请求参数:{}1", controller, method, request);
        ApiLog apilog = new ApiLog();
        apilog.setApiCode(controller+"."+method);
        apilog.setDatatype("JSON");
        apilog.setInDate(new Date());
        apilog.setIsDataPullStatus(1L);
        Object ret = pjp.proceed();
        apilog.setOutDate(new Date());
        apilog.setRequestData(request);
        String response = mapper.writeValueAsString(ret);
        log.info("响应数据:{}", response);
        apilog.setResponseData(response);
        apilog.setTakeTime(apilog.getOutDate().getTime()-apilog.getInDate().getTime());
        apilog.setResponseCode(200L);
        apilog.setApiName(apiRecord.name());
        apiLogService.save(apilog);
        ApiLogTotal apiLogTotal = new ApiLogTotal();
        apiLogTotal.setInDate(getNowDate());
        apiLogTotal.setApiCode(controller+"."+method);
        apiLogTotal = isExistOne(apiLogTotal);
        apiLogTotal.setApiName(apiRecord.name());
        long count=0L;
        if( apiLogTotal.getSuccessCount()!=null){
            count = apiLogTotal.getSuccessCount();
        }
        apiLogTotal.setSuccessCount(count+1);
        apiLogTotalService.save(apiLogTotal);


        return ret;
    }

    /**
     * 是否存在这个时间段的记录
     * @return
     */
    private ApiLogTotal isExistOne(ApiLogTotal source){

        List<ApiLogTotal> apiLogTotalList = apiLogTotalService.findList(source);
        ApiLogTotal result = new ApiLogTotal();
        if(apiLogTotalList.size()>0){
            result = apiLogTotalList.get(0);
        }else{
            result = source;
        }
        return result;
    }

    /**
     * 获取当前的时间，精确到小时
     * @return
     */
    private Date getNowDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
        Date date = new Date();
        try {
            date = sdf.parse( sdf.format(new Date()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}