/**
 * lincl
 * 2016年9月14日 上午10:27:26
 * 
 */
package com.lezic.tiana.web.log;

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

    /** 模块 */
    private String module;

    /** 菜单 */
    private String menu;

    /** 内容 */
    private String detail;

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

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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

    /**
     * 构造方法
     * @param clue
     * @param time
     * @param module
     * @param menu
     * @param detail
     * @param result
     * @param costTime
     * @param userId
     */
    public LogVo(String clue, Long time, String module, String menu, String detail, Object result, Long costTime,
            Long userId) {
        super();
        this.clue = clue;
        this.time = time;
        this.module = module;
        this.menu = menu;
        this.detail = detail;
        this.result = result;
        this.costTime = costTime;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LogVo [clue=" + clue + ", time=" + time + ", module=" + module + ", menu=" + menu + ", detail="
                + detail + ", result=" + result + ", costTime=" + costTime + ", userId=" + userId + "]";
    }

}
