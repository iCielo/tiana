/**
 * lincl
 * 2016年8月31日 下午4:43:41
 * 
 */
package com.lezic.tiana.api.util;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Response工具类
 * 
 * @author lincl
 * 
 */
public class ResponseUtil {

    private static Logger logger = LogManager.getLogger(ResponseUtil.class);

    /**
     * 将指定对象转为application/json字符串写入response
     * 
     * @param object
     * @throws IOException
     */
    public static void write(HttpServletResponse response, Object object) {
        response.setContentType("application/json;charset=UTF-8");
        // response.setContentType("text/xml;charset=UTF-8");
        try {
            if (object instanceof Collection) {
                JSONArray jsonArray = JSONArray.fromObject(object);
                response.getWriter().write(jsonArray.toString());
            } else {
                JSONObject jsonObject = JSONObject.fromObject(object);
                response.getWriter().write(jsonObject.toString());
            }
        } catch (Exception e) {
            logger.error("系统错误！", e);
        }
    }
}
