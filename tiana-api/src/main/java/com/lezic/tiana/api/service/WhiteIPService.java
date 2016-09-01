/**
 * lincl
 * 2016年8月31日 下午5:27:18
 * 
 */
package com.lezic.tiana.api.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezic.tiana.api.cache.WhiteIPCache;

/**
 * 白名单服务类
 * 
 * @author lincl
 * 
 */
@Service
public class WhiteIPService implements InitializingBean {

    @Autowired
    private WhiteIPCache whiteIPCache;

    /**
     * 验证IP是否合法
     * 
     * @param ip
     * @return
     * @author lincl
     * @date 2016年8月31日 下午5:32:15
     */
    public boolean isLegal(String ip) {
        return whiteIPCache.get(ip) != null;
    }

    /**
     * 初始化IP白名单
     * 
     * @throws Exception
     * @author lincl
     * @date 2016年8月31日 下午6:13:24
     */
    public void afterPropertiesSet() throws Exception {
        whiteIPCache.put("127.0.0.1", true);
        whiteIPCache.put("10.8.115.83", true);
    }

}
