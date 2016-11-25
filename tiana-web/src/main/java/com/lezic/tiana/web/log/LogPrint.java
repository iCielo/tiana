/**
 * lincl
 * 2016年11月25日 下午5:29:58
 * 
 */
package com.lezic.tiana.web.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author lincl
 * 
 */
public class LogPrint {

    private static Logger logger = LogManager.getLogger("RunLog");
    
    private String clue;
    
    /**
     * 线索ID
     * @param clue
     */
    public LogPrint(String clue) {
        super();
        this.clue = clue;
    }



    /**
     * 打印日志
     * 
     * @param msg
     * @author lincl
     * @date 2016年11月25日 下午5:31:54
     */
    public void debug(String msg) {
        logger.debug(clue + " # " + msg);
    }
    
    /**
     * 打印日志
     * 
     * @param msg
     * @author lincl
     * @date 2016年11月25日 下午5:31:54
     */
    public static void debug(String clue,String msg) {
        logger.debug(clue + " # " + msg);
    }

}
