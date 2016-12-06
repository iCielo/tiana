/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:53:45</p>
 */
package com.lezic.tiana.app.action.crud;

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

import com.lezic.tiana.app.entity.crud.CrudTable;
import com.lezic.tiana.app.entity.sys.SysRole;
import com.lezic.tiana.app.service.crud.CrudTableService;
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
@RequestMapping("/crud/table.do")
public class CrudTableController extends BaseController {

    private Logger logger = LogManager.getLogger();

    @Autowired
    private CrudTableService crudTableService;

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     */
    @RequestMapping(params = "method=list", method = RequestMethod.GET)
    public String listPage(Model model) {
        return "/crud/table/CrudTable-list";
    }

    /**
     * 新增页面
     */
    @RequestMapping(params = "method=add", method = RequestMethod.GET)
    public String addPage() {
        return "/crud/table/CrudTable-add";
    }

    /**
     * 修改页面
     */
    @RequestMapping(params = "method=upd", method = RequestMethod.GET)
    public String updPage(Long id, Model model) {
        if (id != null) {
            model.addAttribute("entity", crudTableService.getH(id));
        }
        return "/crud/table/CrudTable-upd";
    }

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     */
    @RequestMapping(params = "method=loadData", method = RequestMethod.GET)
    @ResponseBody
    public Page<CrudTable> loadData() {
        Page<CrudTable> page = new Page<CrudTable>();
        page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
        page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
        String hql = "from CrudTable order by moduleName";
        ParamMap params = new ParamMap();
        crudTableService.pageH(page, hql, params);
        return page;
    }

    /**
     * 新增
     * 
     */
    @RequestMapping(params = "method=addEntity")
    @ResponseBody
    public BaseData addEntity(@ModelAttribute CrudTable entity) {
        crudTableService.addEntity(entity);
        return new BaseData();
    }

    /**
     * 修改
     * 
     */
    @RequestMapping(params = "method=updEntity")
    @ResponseBody
    public BaseData updEntity(@ModelAttribute CrudTable item) {
        if (item != null) {
            CrudTable entity = crudTableService.getH(item.getId());
            HibernateUtil.copyExcludeNull(entity, item);
            crudTableService.updEntity(entity);
        }
        return new BaseData();
    }

    /**
     * 删除
     * 
     */
    @RequestMapping(params = "method=delEntity")
    @ResponseBody
    public BaseData delEntity() {
        Long[] ids = DataUtil.splitToLong(this.getParam("ids"), ",");
        crudTableService.batchDelH(CrudTable.class, ids);
        return new BaseData();
    }

    /**
     * 判断名称是否重复
     * 
     * @author cielo
     */
    @RequestMapping(params = "method=chkTableName")
    @ResponseBody
    public Map<String, String> chkTableName(Long id, String tableName) {
        boolean isExist = crudTableService.isTableExist(tableName);
        if (!isExist) {
            return super.isRepeat(true, "对不起，表不存在！", "");
        } else {
            String hql = "from CrudTable where  (id != ? or ? is null) and tableName = ?";
            boolean isRepeat = crudTableService.isExist(hql, id, id, tableName);
            return super.isRepeat(isRepeat, "对不起，该表已生成代码！", "验证通过！");
        }
    }

    /**
     * 更新表字段
     * 
     * @author cielo
     */
    @RequestMapping(params = "method=updateColumns")
    @ResponseBody
    public BaseData updateColumns(String tableName) {
        try {
            if (DataUtil.isNull(tableName)) {
                return new BaseData(StatusCode.APP_1001, "表名为空！");
            }
            crudTableService.updateColumns(tableName);
            return new BaseData(StatusCode.SUCCESS, "更新表字段成功！");
        } catch (Exception e) {
            return new BaseData(StatusCode.ERROR, "运行出现错误！");
        }
    }

    /**
     * 生成代码
     * 
     * @author cielo
     */
    @RequestMapping(params = "method=processCode")
    @ResponseBody
    public BaseData processCode(String tableName) {
        try {
            if (DataUtil.isNull(tableName)) {
                return new BaseData(StatusCode.APP_1001, "表名为空！");
            }
            crudTableService.processCode(tableName);
            return new BaseData(StatusCode.SUCCESS, "生成成功！");
        } catch (Exception e) {
            return new BaseData(StatusCode.ERROR, "运行出现错误！");
        }
    }

}