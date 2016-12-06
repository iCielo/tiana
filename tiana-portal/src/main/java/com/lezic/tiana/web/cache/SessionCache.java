/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:02:50</p>
 */
package com.lezic.tiana.web.cache;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lezic.tiana.app.entity.sys.SysUser;

/**
 * 会话级缓存
 * 
 * @author cielo
 * 
 */
public class SessionCache {

    /**
     * 获取当前session
     * 
     * @return
     * @author cielo
     */
    public static HttpSession getSession() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    }
    
    /**
     * 清楚会话
     * 
     * @author lincl
     * @date 2016年12月6日 下午6:07:39
     */
    public static void clearSession(){
        getSession().invalidate();
    }

    public static void setAttribute(String arg0, Object arg1) {
        getSession().setAttribute(arg0, arg1);
    }

    public static Object gettAttribute(String arg0) {
        return getSession().getAttribute(arg0);
    }

    /*--------------------------------------------------------------------------------------------------------------------*/
    /**
     * 保存登录用户
     * 
     * @param sysUser
     * @author lincl
     * @date 2016年12月6日 下午6:05:14
     */
    public static void setUser(SysUser sysUser) {
        getSession().setAttribute("USER", sysUser);
    }

    /**
     * 获取当前登录用户
     * 
     * @return
     * @author cielo
     */
    public static SysUser getUser() {
        return (SysUser) getSession().getAttribute("USER");
    }

    /**
     * 获取当前登录用户ID
     * 
     * @return
     * @author cielo
     */
    public static Long getUserId() {
        SysUser user = (SysUser) getSession().getAttribute("USER");
        return user == null ? null : user.getId();
    }
}
