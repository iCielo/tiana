/**
 * lincl
 * 2016年8月31日 下午3:21:09
 * 
 */
package com.lezic.tiana.api.vo;

/**
 * token
 * 
 * @author lincl
 * 
 */
public class Token {

    /** 用户名 */
    private Long userId;

    /** token的key */
    private String key;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
