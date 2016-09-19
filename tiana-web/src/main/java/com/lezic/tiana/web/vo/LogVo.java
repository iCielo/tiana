/**
 * lincl
 * 2016年9月14日 上午10:27:26
 * 
 */
package com.lezic.tiana.web.vo;

/**
 * 日志对象
 * 
 * @author lincl
 * 
 */
public class LogVo {

    /** 线索 用于标识某次请求 */
    private String clue;

    /** 时间点 */
    private Long time;

    /** 内容 */
    private String content;

    /** 结果 */
    private Object result;

    /** 耗时 */
    private Long costTime;

    /** 用户ID */
    private Long userId;

    /**
     * 
     */
    public LogVo() {
        super();
    }

    /**
     * @param clue
     * @param time
     * @param content
     * @param result
     * @param costTime
     * @param userId
     */
    public LogVo(String clue, Long time, String content, Object result, Long costTime, Long userId) {
        super();
        this.clue = clue;
        this.time = time;
        this.content = content;
        this.result = result;
        this.costTime = costTime;
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
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

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    @Override
    public String toString() {
        return "LogVo [clue=" + clue + ", time=" + time + ", content=" + content + ", result=" + result + ", costTime="
                + costTime + ", userId=" + userId + "]";
    }

}
