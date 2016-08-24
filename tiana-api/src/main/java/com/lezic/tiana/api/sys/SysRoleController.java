/**
 * lincl
 * 2016年8月15日 下午4:39:34
 * 
 */
package com.lezic.tiana.api.sys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lezic.tiana.app.entity.sys.SysRole;
import com.lezic.tiana.app.service.sys.SysRoleService;
import com.lezic.tiana.web.BaseController;

/**
 * @author lincl
 * 
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public SysRole view(@PathVariable String roleId) {
        SysRole item = sysRoleService.getH(roleId);
        return item;

    }

}
