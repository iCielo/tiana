/**
 * lincl
 * 2016年9月14日 上午10:27:26
 * 
 */
package com.lezic.tiana.web.vo;

import java.util.Date;

/**
 * 日志对象
 * 
 * @author lincl
 * 
 */
public class LogVO {

    /** 时间点 */
    private Date time;

    /** 内容 */
    private String content;

    /** 结果 */
    private String result;

    /** 耗时 */
    private Long costTime;

    /** 用户ID */
    private Long userId;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
