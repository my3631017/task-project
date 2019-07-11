package com.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

public class RunTimeAspect {
    Logger logger = Logger.getLogger(RunTimeAspect.class);

    public Object dbTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
//        System.out.println("用时（ms）：" + (endTime - startTime));
        logger.info("访问DB时间:" + (endTime - startTime)+"毫秒");
        return object;
    }

    public Object controllerTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
//        System.out.println("用时（ms）：" + (endTime - startTime));
        logger.info("controller处理时间:" + (endTime - startTime)+"毫秒");
        return object;
    }
}
