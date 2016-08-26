/**
 * lincl
 * 2016年8月15日 上午11:37:46
 * 
 */
package com.lezic.tiana.constant;

import java.io.Serializable;

/**
 * 状态码数据
 * 
 * @author lincl
 * 
 */
public enum StatusCode implements Serializable {

    /* HTTP返回状态码 */
    /** HTTP 正常 */
    HTTP_200("正常"),
    /** HTTP 错误请求 */
    HTTP_400("错误请求"),
    /** HTTP 未授权 */
    HTTP_401("未授权"),
    /** HTTP 禁止访问 */
    HTTP_403("禁止访问"),
    /** HTTP 页面不存在 */
    HTTP_404("页面不存在"),
    /** HTTP 内部服务器错误 */
    HTTP_500("内部服务器错误"),
    /** HTTP 服务不可用 */
    HTTP_503("服务不可用"),

    /* 业务返回状态码 */
    APP_0("成功"),
    /** 业务参数缺失 */
    APP_1001("参数缺失"),
    /** 业务参数不合法 */
    APP_1002("参数不合法"),
    /** 不允许操作其它用户的数据 */
    APP_1003("不允许操作其它用户的数据"),
    /** 访问的数据对象不存在 */
    APP_1004("访问的数据对象不存在"),

    /* 其它状态码 */
    /** 未知异常 */
    APP_9999("未知异常");

    /** 错误信息 */
    private String msg;

    /**
     * 构造方法
     * 
     * @param code
     * @param msg
     */
    private StatusCode(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.name();

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
