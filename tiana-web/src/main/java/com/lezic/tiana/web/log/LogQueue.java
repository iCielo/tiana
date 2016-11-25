/**
 * lincl
 * 2016年9月14日 下午3:52:44
 * 
 */
package com.lezic.tiana.web.log;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.lezic.tiana.app.entity.sys.SysLog;

/**
 * 日志缓存队列
 * 
 * @author lincl
 * 
 */
@Component
public class LogQueue extends ConcurrentLinkedQueue<SysLog> {

    private static final long serialVersionUID = 1L;
}
