/**
 * lincl
 * 2016年8月15日 上午11:37:46
 * 
 */
package com.lezic.tiana.exception;

/**
 * 异常码、错误信息
 * 
 * @author lincl
 * 
 */
public enum ErrCode {
    
    _0001(1, ""),
    /** 业务参数缺失 */
    _1001(1001, "业务参数缺失"),
    /** 业务参数不合法 */
    _1002(1002, "业务参数不合法"), _1003(1003, "业务参数不合法"),
    /** 未知异常 */
    _9999(9999, "未知异常");

    /** 错误码 */
    private int code;

    /** 错误信息 */
    private String msg;

    private ErrCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
