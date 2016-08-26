/**
 * lincl
 * 2016年8月26日 下午3:41:54
 * 
 */
package com.lezic.tiana.constant;

import java.util.List;

/**
 * ajax请求返回结果
 * 
 * @author lincl
 * 
 */
public class AjaxResult {

    private StatusCode code;

    private String msg;

    private Object result;

    private List<?> rows;

    private Long total;

    /**
     * 构造方法
     */
    public AjaxResult() {
        super();
        this.code = StatusCode.APP_0;
    }

    /**
     * 构造方法
     * 
     * @param code
     */
    public AjaxResult(StatusCode code) {
        super();
        this.code = code;
        this.msg = code.getMsg();
    }

    /**
     * 构造方法
     * 
     * @param code
     * @param msg
     */
    public AjaxResult(StatusCode code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public StatusCode getCode() {
        return code;
    }

    public void setCode(StatusCode code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;

    }

}
