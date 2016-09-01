/**
 * lincl
 * 2016年8月31日 下午3:37:34
 * 
 */
package com.lezic.tiana.constant;


/**
 * 响应结果数据
 * 
 * @author lincl
 * 
 */
public class ResponseData<T> {

    private StatusCode code;

    private String msg;

    private T result;

    /**
     * 构造方法
     */
    public ResponseData() {
        super();
        this.code = StatusCode.APP_0;
    }

    /**
     * 构造方法
     */
    public ResponseData(T result) {
        super();
        this.code = StatusCode.APP_0;
        this.result = result;
    }

    /**
     * 构造方法
     * 
     * @param code
     */
    public ResponseData(StatusCode code) {
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
    public ResponseData(StatusCode code, String msg) {
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
