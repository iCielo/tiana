/**
 * lincl
 * 2016年9月13日 上午9:20:33
 * 
 */
package com.lezic.tiana.web.aspect;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 日志切面
 * 
 * @author lincl
 * 
 */
@Aspect
public class LogAspect {
    private Logger logger = LogManager.getLogger();

    @Pointcut("@annotation(com.lezic.tiana.web.annotation.Log)")
    public void logAspect() {
    }

    /**
     * 
     * @author lincl
     * @throws Throwable 
     * @date 2016年9月13日 下午5:25:07
     */
    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint pjd) throws Throwable {
        Object result = null;
        String methodName = pjd.getSignature().getName();
        // 执行目标方法
        // 前置通知
        logger.info("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
        result = pjd.proceed();
        // 返回通知
        logger.info("The method " + methodName + " ends with " + Arrays.asList(pjd.getArgs()));
        // 后置通知
        logger.info("The method " + methodName + " ends");
        return result;
    }

}
