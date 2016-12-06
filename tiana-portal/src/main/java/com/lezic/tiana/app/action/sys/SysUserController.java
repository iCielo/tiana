/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:56:51</p>
 */
package com.lezic.tiana.app.action.sys;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lezic.tiana.app.entity.sys.SysUser;
import com.lezic.tiana.app.service.sys.SysUserService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.orm.Page;
import com.lezic.tiana.orm.ParamMap;
import com.lezic.tiana.orm.util.HibernateUtil;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.BaseController;

/**
 * @author cielo
 * 
 */
@Controller
@RequestMapping("/sys/user.do")
public class SysUserController extends BaseController {

    private Logger logger = LogManager.getLogger();

    @Autowired
    private SysUserService sysUserService;

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     */
    @RequestMapping(params = "method=list", method = RequestMethod.GET)
    public String listPage(Model model) {
        return "/sys/user/SysUser-list";
    }

    /**
     * 新增页面
     */
    @RequestMapping(params = "method=add", method = RequestMethod.GET)
    public String addPage(Model model) {
        return "/sys/user/SysUser-add";
    }

    /**
     * 修改页面
     */
    @RequestMapping(params = "method=upd", method = RequestMethod.GET)
    public String updPage(Long id, Model model) {
        if (id != null) {
            model.addAttribute("entity", sysUserService.getH(id));
        }
        return "/sys/user/SysUser-upd";
    }

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     * @throws IOException
     */
    @RequestMapping(params = "method=loadData", method = RequestMethod.GET)
    @ResponseBody
    public Page<SysUser> loadData() throws IOException {
        Page<SysUser> page = new Page<SysUser>();
        page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
        page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
        String hql = "from SysUser where (:account is null or account like :account) and (:name is null or name like :name)  and (:status is null or status = :status)";
        ParamMap params = new ParamMap();
        params.putLike("account", this.getParam("account"));
        params.putLike("name", this.getParam("name"));
        params.put("status", this.getParam("status"));
        sysUserService.pageH(page, hql, params);
        return page;
    }

    /**
     * 新增
     * 
     * @throws IOException
     */
    @RequestMapping(params = "method=addEntity")
    @ResponseBody
    public BaseData addEntity(@ModelAttribute SysUser entity) throws IOException {
        sysUserService.saveH(entity);
        return new BaseData();
    }

    /**
     * 修改
     * 
     * @throws IOException
     */
    @RequestMapping(params = "method=updEntity")
    @ResponseBody
    public BaseData updEntity(@ModelAttribute SysUser item) throws IOException {
        if (item != null) {
            SysUser entity = sysUserService.getH(item.getId());
            HibernateUtil.copyExcludeNull(entity, item);
            sysUserService.updH(entity);
        }
        return new BaseData();
    }

    /**
     * 删除
     * 
     * @throws IOException
     */
    @RequestMapping(params = "method=delEntity")
    @ResponseBody
    public BaseData delEntity() throws IOException {
        Long[] ids = DataUtil.splitToLong(this.getParam("ids"), ",");
        sysUserService.batchDelH(SysUser.class, ids);
        return new BaseData();
    }

    /**
     * 判断名称是否重复
     * 
     * @throws IOException
     * @author cielo
     */
    @RequestMapping(params = "method=chkAccount")
    @ResponseBody
    public void chkAccount(Long id, String account) throws IOException {
        String hql = "from SysUser where  (id != ? or ? is null) and account = ?";
        boolean isRepeat = sysUserService.isExist(hql, id, id, account);
        Map<String, String> ret = new HashMap<String, String>();
        if (isRepeat) {
            ret.put("error", "对不起，已存在该账号！");
        } else {
            ret.put("ok", "该账号可用！");
        }
        this.write(ret);
    }

    /**
     * 启用、禁用
     * 
     * @throws IOException
     * @author cielo
     */
    @RequestMapping(params = "method=opStatus")
    @ResponseBody
    public BaseData opStatus() throws IOException {
        Long[] ids = DataUtil.splitToLong(this.getParam("ids"), ",");
        String status = this.getParam("status");
        if (DataUtil.isEmpty(ids)) {
            return new BaseData(StatusCode.APP_1001, "要操作记录ID为空");
        } else if (DataUtil.isNull(status)) {
            return new BaseData(StatusCode.APP_1001, "操作类型为空");
        } else {
            ParamMap params = new ParamMap();
            String hql = "update SysUser set status = :status where id in (:ids)";
            params.put("status", status);
            params.put("ids", ids);
            sysUserService.executeH(hql, params);
            return new BaseData();
        }
    }

}
