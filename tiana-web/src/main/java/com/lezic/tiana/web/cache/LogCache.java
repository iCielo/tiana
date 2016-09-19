/**
 * lincl
 * 2016年9月14日 下午3:52:44
 * 
 */
package com.lezic.tiana.web.cache;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

import com.lezic.tiana.web.vo.LogVo;

/**
 * 日志缓存
 * 
 * @author lincl
 * 
 */
@Component
public class LogCache extends ConcurrentLinkedQueue<LogVo> {

    private static final long serialVersionUID = 1L;
}
