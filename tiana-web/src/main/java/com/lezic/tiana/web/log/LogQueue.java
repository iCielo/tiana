/**
 * lincl
 * 2016年9月14日 下午3:52:44
 * 
 */
package com.lezic.tiana.web.log;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

/**
 * 日志缓存队列
 * 
 * @author lincl
 * 
 */
@Component
public class LogQueue extends ConcurrentLinkedQueue<LogVo> {

    private static final long serialVersionUID = 1L;
}
