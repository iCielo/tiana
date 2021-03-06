/**
 * lincl
 * 2016年9月13日 下午4:38:47
 * 
 */
package com.lezic.tiana.constant;

/**
 * 响应结果
 * 
 * @author lincl
 * 
 */
public class BaseData {

    /** 编码 */
    private StatusCode code;

    /** 提示消息 */
    private String msg;

    /**
     * 成功标识
     * 
     * @return
     * @author lincl
     * @date 2016年12月6日 下午6:02:16
     */
    public boolean isSuccess() {
        return StatusCode.SUCCESS.equals(code);
    }

    /**
     * 构造方法
     */
    public BaseData() {
        super();
        this.code = StatusCode.SUCCESS;
    }

    /**
     * 构造方法
     * 
     * @param code
     */
    public BaseData(StatusCode code) {
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
    public BaseData(StatusCode code, String msg) {
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

    @Override
    public String toString() {
        return "BaseData [code=" + code + ", msg=" + msg + "]";
    }

}
