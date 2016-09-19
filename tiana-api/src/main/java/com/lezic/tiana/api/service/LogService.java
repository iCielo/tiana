/**
 * lincl
 * 2016年9月19日 下午6:07:43
 * 
 */
package com.lezic.tiana.api.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezic.tiana.web.cache.LogCache;
import com.lezic.tiana.web.vo.LogVo;

/**
 * 日志服务
 * 
 * @author lincl
 * 
 */
@Service
public class LogService {

    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private LogCache logCache;

    /**
     * 将日志内容持久化
     * 
     * @author lincl
     * @date 2016年9月19日 下午6:12:07
     */
    public void addLog() {
        LogVo logVo = logCache.poll();
        logger.info(logVo);
    }

}
