package com.lezic.tiana.api.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lezic.tiana.api.annotation.Authorization;
import com.lezic.tiana.api.service.TokenService;
import com.lezic.tiana.api.vo.Token;
import com.lezic.tiana.app.constant.Constants;
import com.lezic.tiana.constant.SimpleData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.web.service.WhiteIPService;
import com.lezic.tiana.web.util.ResponseUtil;

/**
 * 自定义拦截器，判断此次请求是否有权限
 * 
 * @author lincl
 * 
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private WhiteIPService whiteIPService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 设置线程ID
//        request.setAttribute(WebConstant.CLUE_ID, UUID.randomUUID().toString());

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
        if (request.getRequestURI().startsWith(ctx + "/api-docs")) {// 放过swagger
            return true;
        }
        if (request.getRequestURI().startsWith(ctx + "/tokens")) {// 放过tokens登录、登出
            return true;
        }

        // 认证Token
        String key = request.getHeader(Constants.TOKEN_KEY);
        if (key == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ResponseUtil.write(response, new SimpleData<String>(StatusCode.HTTP_401, "请先登录"));
            return false;
        }

        // 判断方法是否需要鉴权
        Token token = tokenService.getToken(key);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.getAnnotation(Authorization.class) != null && token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ResponseUtil.write(response, new SimpleData<String>(StatusCode.HTTP_401, "token不是有效或已失效"));
            return false;
        } else {
            // 更新token有效期
            tokenService.addToken(token);
            // 可在此注入额外参数
            request.setAttribute(Constants.USER_ID, token.getUserId());
            return true;
        }
    }
}
