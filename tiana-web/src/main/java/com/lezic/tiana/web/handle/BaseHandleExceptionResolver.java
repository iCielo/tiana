/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:14:06</p>
 */
package com.lezic.tiana.web.handle;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.lezic.tiana.constant.SimpleData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.util.JsonUtil;

/**
 * Spring MVC 异常统一处理类
 * 
 * @author cielo
 * 
 */
@Component
public class BaseHandleExceptionResolver implements HandlerExceptionResolver {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        if (ex != null) {
            String ajax = request.getParameter("ajax");
            String msg = ex.getMessage();
            logger.error("系统错误！", ex);
            SimpleData<String> responseData = new SimpleData<>(StatusCode.APP_9999,msg);
            if ("true".equals(ajax)) {
                response.setContentType("application/json");
                try {
                    response.getWriter().write(JsonUtil.toString(responseData));
                } catch (IOException e) {
                }
            } else {
                request.setAttribute("responseData", responseData);
                return new ModelAndView("main/exception");
            }
        }
        return null;
    }
}
