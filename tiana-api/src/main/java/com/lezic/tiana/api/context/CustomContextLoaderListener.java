/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午2:48:27</p>
 */
package com.lezic.tiana.api.context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.ServletContextEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.context.ContextLoaderListener;

import com.lezic.tiana.web.log.LogTask;
import com.lezic.tiana.web.util.SpringContextUtil;

/**
 * 系统启动初始化类
 * 
 * @author cielo
 * 
 */
public class CustomContextLoaderListener extends ContextLoaderListener {

    private Logger logger = LogManager.getLogger();

    @Override
    public void contextInitialized(ServletContextEvent event) {
        super.contextInitialized(event);
        SpringContextUtil.init(event);

        logger.info("开始系统全局参数初始化");
        int i = 1;

        logger.info((i++) + ".初始化系统日志AOP");
        ExecutorService service=Executors.newFixedThreadPool(5);
        for (int j = 0; j < 5; j++) {
            
        }
        
        LogTask logTask = (LogTask) SpringContextUtil.getBean(LogTask.class);
        logTask.start();
    }

}
