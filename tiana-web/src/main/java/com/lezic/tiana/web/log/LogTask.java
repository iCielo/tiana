/**
 * lincl
 * 2016年9月14日 下午4:00:03
 * 
 */
package com.lezic.tiana.web.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lezic.tiana.app.entity.sys.SysLog;
import com.lezic.tiana.app.service.sys.SysLogService;

/**
 * 日志持久化任务
 * 
 * @author lincl
 * 
 */
@Component
public class LogTask extends Thread {

    private Logger logger = LogManager.getLogger("RunLog");

    @Autowired
    private LogQueue logCache;

    @Autowired
    private SysLogService sysLogService;

    @Override
    public void run() {
        while (true) {
            SysLog logVo = logCache.poll();
            if (logVo != null) {
                LogPrint.debug(logVo.getClue(), "[日志入库] " + logVo.toString());
                try {
                    sysLogService.saveH(logVo);
                } catch (Exception e) {
                    logger.error(e);
                }
            }
        }
    }

}
