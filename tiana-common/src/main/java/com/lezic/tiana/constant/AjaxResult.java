/**
 * lincl
 * 2016年8月26日 下午3:41:54
 * 
 */
package com.lezic.tiana.constant;

/**
 * ajax请求返回结果
 * 
 * @author lincl
 * 
 */
public class AjaxResult {

    private StatusCode statusCode;

    private String msg;

    /**
     * 构造方法
     */
    public AjaxResult() {
        super();
        this.statusCode = StatusCode.APP_0;
    }

    /**
     * 构造方法
     * 
     * @param statusCode
     */
    public AjaxResult(StatusCode statusCode) {
        super();
        this.statusCode = statusCode;
    }

    /**
     * 构造方法
     * 
     * @param statusCode
     * @param msg
     */
    public AjaxResult(StatusCode statusCode, String msg) {
        super();
        this.statusCode = statusCode;
        this.msg = msg;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
