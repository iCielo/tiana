/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Thu Jan 28 18:26:36 CST 2016</p>
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

import com.lezic.tiana.app.entity.sys.SysRole;
import com.lezic.tiana.app.service.sys.SysRoleService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.constant.SimpleData;
import com.lezic.tiana.constant.StatusCode;
import com.lezic.tiana.orm.Page;
import com.lezic.tiana.orm.ParamMap;
import com.lezic.tiana.orm.util.HibernateUtil;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.BaseController;
import com.lezic.tiana.web.log.ModuleMenu;
import com.lezic.tiana.web.log.annotation.LogDetail;
import com.lezic.tiana.web.log.annotation.LogModule;

/**
 * @author cielo
 * 
 */
@Controller
@RequestMapping("/sys/role.do")
@LogModule(ModuleMenu.SYS_ROLE)
public class SysRoleController extends BaseController {

    private Logger logger = LogManager.getLogger();

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     */
    @LogDetail("访问用户角色列表")
    @RequestMapping(params = "method=list", method = RequestMethod.GET)
    public String listPage() {
        return "/sys/role/SysRole-list";
    }

    /**
     * 新增页面
     */
    @RequestMapping(params = "method=add", method = RequestMethod.GET)
    @LogDetail("访问用户角色新增列表")
    public String addPage() {
        return "/sys/role/SysRole-add";
    }

    /**
     * 修改页面
     */
    @RequestMapping(params = "method=upd", method = RequestMethod.GET)
    public String updPage(Long id, Model model) {
        if (id != null) {
            model.addAttribute("entity", sysRoleService.getH(id));
        }
        return "/sys/role/SysRole-upd";
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
    public Page<SysRole> loadData() throws IOException {
        new SimpleData<String>();
        Page<SysRole> page = new Page<SysRole>();
        page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
        page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
        String hql = "from SysRole where (:code is null or code like :code) and (:name is null or name like :name)  and (:status is null or status = :status)";
        ParamMap params = new ParamMap();
        params.putLike("code", this.getParam("code"));
        params.putLike("name", this.getParam("name"));
        params.put("status", this.getParam("status"));
        sysRoleService.pageH(page, hql, params);
        return page;
    }

    /**
     * 新增
     * 
     * @throws IOException
     */
    @RequestMapping(params = "method=addEntity")
    @ResponseBody
    public BaseData addEntity(@ModelAttribute SysRole entity) throws IOException {
        sysRoleService.saveH(entity);
        return new BaseData();
    }

    /**
     * 修改
     * 
     * @throws IOException
     */
    @RequestMapping(params = "method=updEntity")
    @ResponseBody
    public BaseData updEntity(@ModelAttribute SysRole item) throws IOException {
        if (item != null) {
            SysRole entity = sysRoleService.getH(item.getId());
            HibernateUtil.copyExcludeNull(entity, item);
            sysRoleService.updH(entity);
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
        sysRoleService.batchDelH(SysRole.class, ids);
        return new BaseData();
    }

    /**
     * 判断code是否重复
     * 
     * @throws IOException
     * @author cielo
     */
    @RequestMapping(params = "method=chkCode")
    @ResponseBody
    public Map<String, String> chkCode(String code) throws IOException {
        String hql = "from SysRole where  code = ?";
        boolean isRepeat = sysRoleService.isExist(hql, code);
        return super.isRepeat(isRepeat, "对不起，已存在该代码！", "该代码可用！");
    }

    /**
     * 判断名称是否重复
     * 
     * @throws IOException
     * @author cielo
     */
    @RequestMapping(params = "method=chkName")
    @ResponseBody
    public void chkName(Long id, String name) throws IOException {
        String hql = "from SysRole where  (id != ? or ? is null) and name = ?";
        boolean isRepeat = sysRoleService.isExist(hql, id, id, name);

        Map<String, String> ret = new HashMap<String, String>();
        if (isRepeat) {
            ret.put("error", "对不起，已存在该名称！");
        } else {
            ret.put("ok", "该名称可用！");
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
        Integer status = DataUtil.integerOfString(this.getParam("status"));
        if (DataUtil.isEmpty(ids)) {
            return new BaseData(StatusCode.APP_1001, "要操作记录ID为空");
        } else if (DataUtil.isNull(status)) {
            return new BaseData(StatusCode.APP_1001, "操作类型为空");
        } else {
            ParamMap params = new ParamMap();
            String hql = "update SysRole set status = :status where id in (:ids)";
            params.put("status", status);
            params.put("ids", ids);
            sysRoleService.executeH(hql, params);
            return new BaseData();
        }
    }

}
