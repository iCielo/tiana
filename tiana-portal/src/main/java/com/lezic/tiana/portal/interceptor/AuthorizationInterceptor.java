package com.lezic.tiana.portal.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lezic.tiana.app.entity.sys.SysUser;
import com.lezic.tiana.web.cache.SessionCache;
import com.lezic.tiana.web.service.WhiteIPService;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * 
 * @author lincl
 * 
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private WhiteIPService whiteIPService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 设置线程ID
        // request.setAttribute(WebConstant.CLUE_ID, UUID.randomUUID().toString());

        // 校验IP白名单
        // if (whiteIPService.isLegal(ClientIpUtil.getRemoteAddr(request)) == false) {
        // response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        // ResponseUtil.write(response, new ResponseData<String>(StatusCode.HTTP_403, "非法请求IP"));
        // return false;
        // }

        // 默认不校验的请求URL
        if (!(handler instanceof HandlerMethod)) {// 如果不是映射到方法直接通过
            return true;
        }
        String ctx = request.getContextPath();
       
        if (request.getRequestURI().startsWith(ctx + "/login")) {// 放过登录
            return true;
        }
        if (request.getRequestURI().startsWith(ctx + "/doLogin")) {// 放过登录
            return true;
        }
        if (request.getRequestURI().startsWith(ctx + "/logout")) {// 放过登出
            return true;
        }

        //判断是否已登录
        SysUser sysUser = SessionCache.getUser();
        if (sysUser == null) {
            response.sendRedirect(request.getContextPath() + "/jsp/timeout.jsp");
            return false;
        }
        return super.preHandle(request, response, handler);

    }
}
