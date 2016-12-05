/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午2:59:46</p>
 */
package com.lezic.tiana.web.interceptor;

import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.lezic.tiana.web.constant.WebConstant;
import com.lezic.tiana.web.log.LogPrint;
import com.lezic.tiana.web.util.ClientIpUtil;

/**
 * 客户端请求地址、参数的打印拦截器
 * 
 * @author cielo
 * 
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {

    @SuppressWarnings("unchecked")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置线程ID
        request.setAttribute(WebConstant.CLUE_ID, UUID.randomUUID().toString());
        
        String clue = (String) request.getAttribute(WebConstant.CLUE_ID);
        LogPrint logPrint = new LogPrint(clue);
        logPrint.debug("请求开始。。。");
        logPrint.debug("会话标志：" + request.getSession().getId());
        // LogPrint.debug("Request userID：" + SessionParams.getUserId());
        logPrint.debug("请求路径 : " + request.getRequestURL());
        logPrint.debug("客户地址 : " + ClientIpUtil.getRemoteAddr(request));

        Map<?, ?> map = request.getParameterMap();
        Iterator<?> it = map.entrySet().iterator();
        int count = 0;
        if (it.hasNext()) {
            while (it.hasNext()) {
                Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
                String[] value = (String[]) entry.getValue();
                StringBuffer str = new StringBuffer();
                for (int i = 0; i < value.length; i++) {
                    str.append(value[i]);
                    if (i != value.length - 1) {
                        str.append(",");
                    }
                }
                if (entry.getKey().contains("password") || entry.getKey().contains("pwd")) {
                    logPrint.debug("参数[" + count + "]：" + entry.getKey() + "=*****");
                } else {
                    logPrint.debug("参数[" + count + "]：" + entry.getKey() + "=" + str.toString());
                }
                count++;
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        super.afterCompletion(request, response, handler, ex);
        String clue = (String) request.getAttribute(WebConstant.CLUE_ID);
        LogPrint logPrint = new LogPrint(clue);
        logPrint.debug("请求结束。");
    }

}
