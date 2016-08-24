/**
 * lincl
 * 2016年8月10日 下午4:01:45
 * 
 */
package com.lezic.tiana.exception;

/**
 * 异常基类
 * 
 * @author lincl
 * 
 */
public class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误代码
     */
    private ErrCode errCode;

    public BaseException() {
        super();
    }

    public BaseException(ErrCode errCode) {
        super(errCode.getMsg());
        this.errCode = errCode;
    }
    
    

    /**
     * @param message
     * @param cause
     */
    public BaseException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public BaseException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public ErrCode getErrCode() {
        return errCode;
    }

    public void setErrCode(ErrCode errCode) {
        this.errCode = errCode;
    }
    
    

}
