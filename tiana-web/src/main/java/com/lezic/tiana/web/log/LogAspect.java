/**
 * lincl
 * 2016年9月13日 上午9:20:33
 * 
 */
package com.lezic.tiana.web.log;

import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.util.ReflectionUtil;
import com.lezic.tiana.web.log.annotation.LogDetail;
import com.lezic.tiana.web.log.annotation.LogModule;
import com.lezic.tiana.web.util.SpringContextUtil;

/**
 * 日志切面
 * 
 * @author lincl
 * 
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LogManager.getLogger();

    private LogQueue logCache;

    @Around("@annotation(com.lezic.tiana.web.log.annotation.LogDetail)")
    public Object doAround(ProceedingJoinPoint pjd) throws Throwable {
        // 获取Log注解
        ModuleMenu moduleMenu = ModuleMenu.OTHER;
        Class<?> cl = pjd.getTarget().getClass();
        LogModule logModule = cl.getAnnotation(LogModule.class);
        if (logModule != null) {
            moduleMenu = logModule.value();
        }

        String methodName = pjd.getSignature().getName();
        Object[] args = pjd.getArgs();
        Class<?>[] parameterTypes = new Class<?>[args.length];
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < args.length; i++) {
            parameterTypes[i] = args[i].getClass();
            sb.append(ReflectionUtil.toString(args[i]) + ",");
        }
        Method method = cl.getDeclaredMethod(methodName, parameterTypes);
        LogDetail log = method.getAnnotation(LogDetail.class);

        // 打印日志
         logger.debug("------ Begin：" + log.value());
         logger.debug("Class：" + cl.getName());
         logger.debug("Method：" + methodName);
         logger.debug("Args：" + DataUtil.trim(sb.toString(), ","));
        long beginTime = System.currentTimeMillis();
        Object result = pjd.proceed();
        long costTime = System.currentTimeMillis() - beginTime;
         logger.debug("CostTime：" + costTime + "ms");
         logger.debug("Result：" + result);
         logger.debug("------ End：" + log.value());

        // 添加到日志队列中，由异步进程进行写日志操作
        String clue = Thread.currentThread().getId() + "";
        LogVo logVo = new LogVo();
        logVo.setClue(clue);
        logVo.setModule(moduleMenu.getModule());
        logVo.setMenu(moduleMenu.getMenu());
        logVo.setDetail(log.value());
        logVo.setResult(result);
        logVo.setTime(beginTime);
        logVo.setCostTime(costTime);
        logVo.setUserId(null);

        if (logCache == null) {
            logCache = SpringContextUtil.getBean(LogQueue.class);
        }
        logCache.add(logVo);
        return result;
    }
}
