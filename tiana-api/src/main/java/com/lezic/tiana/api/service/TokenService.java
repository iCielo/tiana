/**
 * lincl
 * 2016年8月31日 下午3:45:25
 * 
 */
package com.lezic.tiana.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezic.tiana.api.cache.TokenCache;
import com.lezic.tiana.api.vo.Token;
import com.lezic.tiana.app.constant.Constants;
import com.lezic.tiana.web.annotation.Log;

/**
 * Token服务类
 * 
 * @author lincl
 * 
 */
@Service
public class TokenService {

    @Autowired
    private TokenCache tokenCache;

    /**
     * 获取缓存中的token
     * 
     * @param key
     * @return
     * @author lincl
     * @date 2016年8月31日 下午3:59:27
     */
    public Token getToken(String key) {
        return (Token) tokenCache.get(key);
    }

    /**
     * 加入缓存
     * 
     * @param token
     * @author lincl
     * @date 2016年8月31日 下午3:50:25
     */
    @Log("加入缓存")
    public void addToken(Token token) {
        tokenCache.put(token.getKey(), token, Constants.TOKEN_EXPIRES_HOUR);
    }

    /**
     * 删除缓存
     * 
     * @param token
     * @author lincl
     * @date 2016年8月31日 下午3:51:21
     */
    public void delToken(Token token) {
        tokenCache.remove(token.getKey());
    }

    /**
     * 删除缓存
     * 
     * @param token
     * @author lincl
     * @date 2016年8月31日 下午3:51:21
     */
    public void delToken(String key) {
        tokenCache.remove(key);
    }

}
