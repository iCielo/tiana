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
public class SimpleData<T> extends BaseData {

    /**
     * 单结果
     */
    private T result;

    /**
     * 构造方法
     */
    public SimpleData() {
        super();
    }

    /**
     * 构造方法
     */
    public SimpleData(T result) {
        super();
        this.result = result;
    }

    /**
     * 构造方法
     * 
     * @param code
     */
    public SimpleData(StatusCode code) {
        super(code, code.getMsg());
    }

    /**
     * 构造方法
     * 
     * @param code
     * @param msg
     */
    public SimpleData(StatusCode code, String msg) {
        super(code, code.getMsg());
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}
