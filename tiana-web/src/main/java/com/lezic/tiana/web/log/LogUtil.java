/**
 * lincl
 * 2016年11月25日 下午4:00:22
 * 
 */
package com.lezic.tiana.web.log;

import com.lezic.tiana.web.util.SpringContextUtil;

/**
 * @author lincl
 *
 */
public class LogUtil {
    
    private static LogQueue logCache;

    public static void add(LogVo item){
        if (logCache == null) {
            logCache = SpringContextUtil.getBean(LogQueue.class);
        }
        logCache.add(item);
    }
    
}
