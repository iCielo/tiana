/**
 * lincl
 * 2016年12月6日 下午4:48:45
 * 
 */
package com.lezic.tiana.app.action;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lezic.tiana.app.entity.sys.SysUser;
import com.lezic.tiana.app.service.sys.SysUserService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.util.MD5Util;
import com.lezic.tiana.web.BaseController;
import com.lezic.tiana.web.cache.SessionCache;

/**
 * 系统登录、退出
 * 
 * @author lincl
 * 
 */
@Controller
@RequestMapping("/")
public class LoginController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

    /**
     * 登录
     * 
     * @param account
     * @param password
     * @param model
     * @return
     * @author lincl
     * @throws IOException
     * @date 2016年12月6日 下午4:56:29
     */
    @RequestMapping(value = "doLogin", method = RequestMethod.POST)
    @ResponseBody
    public BaseData doLogin(String account, String password) throws IOException {
        if (DataUtil.isNull(account)) {
            return new BaseData(StatusCode.APP_1001, "请输入账号！");
        }
        if (DataUtil.isNull(password)) {
            return new BaseData(StatusCode.APP_1001, "请输入密码！");
        }
//        password = MD5Util.getMD5(password);
        SysUser sysUser = (SysUser) sysUserService.findOneH("from SysUser where account = ? and password = ?", true,
                account, password);
        if (sysUser == null) {
            return new BaseData(StatusCode.APP_1004, "用户名或密码不正确！");
        }
        SessionCache.setUser(sysUser);
        return new BaseData();
    }

    /**
     * 退出
     * 
     * @param request
     * @param response
     * @return
     * @throws IOException
     * @author lincl
     * @date 2016年12月6日 下午5:00:18
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout() throws IOException {
        SessionCache.clearSession();
        return "/login";
    }
}
