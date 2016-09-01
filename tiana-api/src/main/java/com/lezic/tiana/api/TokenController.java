/**
 * lincl
 * 2016年8月31日 下午2:41:53
 * 
 */
package com.lezic.tiana.api;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.api.constant.Constants;
import com.lezic.tiana.api.service.TokenService;
import com.lezic.tiana.api.vo.Token;
import com.lezic.tiana.constant.ResponseData;
import com.lezic.tiana.constant.StatusCode;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

/**
 * 登录、登出获取token
 * 
 * @author lincl
 * 
 */
@RequestMapping(value = "/tokens")
@RestController
public class TokenController extends BaseController {

    @Autowired
    private TokenService tokenService;

    /**
     * 登录获取token
     * 
     * @param username
     * @param password
     * @return
     * @author lincl
     * @date 2016年8月31日 下午5:06:14
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录", notes = "登录，获取token")
    public ResponseData<String> login(@ApiParam(value = "用户名") @RequestParam String username,
            @ApiParam(value = "密码") @RequestParam String password) {
        
//        X509Certificate[] cers = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");
        Token token = new Token();
        token.setUserId(1L);
        token.setKey(UUID.randomUUID() + "");
        tokenService.addToken(token);
        ResponseData<String> responseData = new ResponseData<String>();
        responseData.setResult(token.getKey());
        responseData.setMsg("登录成功");
        return responseData;
    }

    /**
     * 退出删除token
     * 
     * @return
     * @author lincl
     * @date 2016年8月31日 下午5:06:25
     */
    @RequestMapping(value = "/logout", method = RequestMethod.DELETE)
    @ApiOperation(value = "退出登录", notes = "退出，token失效")
    public ResponseData<String> logout() {
        String key = request.getHeader(Constants.TOKEN_KEY);
        tokenService.delToken(key);
        return new ResponseData<String>(StatusCode.APP_0, "退出登录成功");
    }
}
