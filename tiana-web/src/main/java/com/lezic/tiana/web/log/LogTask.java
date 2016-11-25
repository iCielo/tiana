/**
 * lincl
 * 2016年9月14日 下午4:00:03
 * 
 */
package com.lezic.tiana.web.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 日志持久化任务
 * 
 * @author lincl
 * 
 */
@Component
public class LogTask extends Thread {

    @Autowired
    private LogQueue logCache;

    @Override
    public void run() {
        while (true) {
            LogVo logVo = logCache.poll();
            if (logVo != null) {
                LogPrint.debug(logVo.getClue(), "[日志入库] " + logVo.toString());
            }
        }
    }

}
