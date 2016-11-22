/**
 * lincl
 * 2016年8月31日 下午2:41:53
 * 
 */
package com.lezic.tiana.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.api.service.TokenService;
import com.lezic.tiana.api.vo.Token;
import com.lezic.tiana.app.constant.Constants;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.constant.SimpleData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.web.BaseController;
import com.lezic.tiana.web.log.ModuleMenu;
import com.lezic.tiana.web.log.annotation.LogDetail;
import com.lezic.tiana.web.log.annotation.LogModule;
import com.lezic.tiana.web.util.ContextUtil;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
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
@LogModule(ModuleMenu.API_TOKEN)
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
    @LogDetail(value = "登录，获取token")
    public  SimpleData<String> login(@ApiParam(value = "用户名") @RequestParam String username,
            @ApiParam(value = "密码") @RequestParam String password) {
        
//        X509Certificate[] cers = (X509Certificate[]) request.getAttribute("javax.servlet.request.X509Certificate");
        
        Assert.notNull(username, "username can not be empty");
        Assert.notNull(password, "password can not be empty");
        Token token = new Token();
        token.setUserId(1L);
        token.setKey(UUID.randomUUID() + "");
        tokenService.addToken(token);
        SimpleData<String> responseData = new SimpleData<String>();
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
    @LogDetail(value = "退出，token失效")
    @ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "token", required = true, dataType = "string", paramType = "header"), })
    public BaseData logout() {
        String key = ContextUtil.getCurrentRequest().getHeader(Constants.TOKEN_KEY);
        tokenService.delToken(key);
        return new BaseData(StatusCode.SUCCESS, "退出登录成功");
    }
}
