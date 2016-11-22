/**
 * lincl
 * 2016年11月7日 下午2:10:39
 * 
 */
package com.lezic.tiana.web.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Spring MVC上下文工具类
 * 
 * @author lincl
 * 
 */
public class ContextUtil {

    /**
     * 获取当前的请求
     * 
     * @return
     * @author lincl
     * @date 2016年7月25日 下午7:12:01
     */
    public static HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取当前的response
     * 
     * @return
     * @author lincl
     * @date 2016年11月22日 下午4:12:46
     */
    public static HttpServletResponse getCurrentResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    /**
     * 获取session
     * 
     * @return
     * @author lincl
     * @date 2016年7月25日 下午7:13:24
     */
    public static HttpSession getSession() {
        HttpServletRequest request = getCurrentRequest();
        return request == null ? null : request.getSession();
    }
}
