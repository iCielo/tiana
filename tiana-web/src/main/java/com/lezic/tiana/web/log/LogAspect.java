/**
 * lincl
 * 2016年9月13日 上午9:20:33
 * 
 */
package com.lezic.tiana.web.log;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.util.ReflectionUtil;
import com.lezic.tiana.web.constant.WebConstant;
import com.lezic.tiana.web.log.annotation.LogDetail;
import com.lezic.tiana.web.log.annotation.LogModule;
import com.lezic.tiana.web.util.ContextUtil;
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
        LogDetail logDetail = method.getAnnotation(LogDetail.class);

        // 线索ID
        String clue = ContextUtil.getCurrentRequest().getAttribute(WebConstant.CLUE_ID) + "";
        LogPrint logPrint = new LogPrint(clue);

        // 日志内容
        String logContent = logDetail.value();
        for (int i = 0; i < args.length; i++) {
            logContent = logContent.replaceAll("\\{" + i + "\\}", ReflectionUtil.toString(args[i]));
        }

        // 打印日志
        logPrint.debug("运行类名：" + cl.getName());
        logPrint.debug("运行方法：" + methodName);
        logPrint.debug("运行参数：" + DataUtil.trim(sb.toString(), ","));
        long beginTime = System.currentTimeMillis();
        Object result = pjd.proceed();
        long costTime = System.currentTimeMillis() - beginTime;
        logPrint.debug("运行耗时：" + costTime + "ms");
        logPrint.debug("运行结果：" + result);

        // 添加到日志队列中，由异步进程进行写日志操作

        LogVo logVo = new LogVo();
        logVo.setClue(clue);
        logVo.setModule(moduleMenu.getModule());
        logVo.setMenu(moduleMenu.getMenu());
        logVo.setDetail(logContent);
        try {
            Object code = ReflectionUtil.getFieldValue(result, "code");
            Object msg = ReflectionUtil.getFieldValue(result, "msg");
            logVo.setResult("[" + code + "] " + (msg == null ? "" : msg));
        } catch (Exception e) {
            logVo.setResult(result);
        }

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
