/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午10:11:55</p>
 */
package com.lezic.tiana.app.action.crud;

import java.io.IOException;
import java.util.List;
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

import com.lezic.tiana.app.entity.crud.CrudColumn;
import com.lezic.tiana.app.service.crud.CrudColumnService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.orm.Page;
import com.lezic.tiana.orm.ParamMap;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.BaseController;

/**
 * @author cielo
 * 
 */
@Controller
@RequestMapping("/crud/column.do")
public class CrudColumnController extends BaseController {

    private Logger logger = LogManager.getLogger();

    @Autowired
    private CrudColumnService crudColumnService;

    /**
     * 列表页面
     * 
     * @param model
     * @return
     * @author cielo
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(params = "method=list", method = RequestMethod.GET)
    public String listPage(Model model) {
        List<Object> tableNameList = (List<Object>) crudColumnService.findH("select tableName from CrudTable");
        model.addAttribute("tableNameList", tableNameList);
        return "/crud/column/CrudColumn-list";
    }

    /**
     * 列表页面-修改列表
     * 
     * @param model
     * @return
     * @author cielo
     */
    @RequestMapping(params = "method=editList", method = RequestMethod.GET)
    public String editList() {
        return "/crud/column/CrudCrudColumn-editList";
    }

    /**
     * 新增页面
     */
    @RequestMapping(params = "method=add", method = RequestMethod.GET)
    public String addPage() {
        return "/crud/column/CrudColumn-add";
    }

    /**
     * 修改页面
     */
    @RequestMapping(params = "method=upd", method = RequestMethod.GET)
    public String updPage(Long id, Model model) {
        if (id != null) {
            model.addAttribute("entity", crudColumnService.getH(id));
        }
        List<Object> sortList = crudColumnService.findM("SysDictionary.getSortList", new ParamMap());
        model.addAttribute("sortList", sortList);
        return "/crud/column/CrudColumn-upd";
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
    public Page<CrudColumn> loadData() {
        Page<CrudColumn> page = new Page<CrudColumn>();
        page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
        page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
        String hql = "from CrudColumn where (tableName = :tableName or :tableName is null) and (columnName like :columnName or :columnName is null) order by tableName,opTime desc";
        ParamMap params = new ParamMap();
        params.put("tableName", this.getParam("tableName"));
        params.put("columnName", this.getParam("columnName"));
        crudColumnService.pageH(page, hql, params);
        return page;
    }

    /**
     * 新增
     * 
     */
    @RequestMapping(params = "method=addEntity")
    @ResponseBody
    public BaseData addEntity(@ModelAttribute CrudColumn entity) {
        crudColumnService.saveH(entity);
        return new BaseData();
    }

    /**
     * 修改
     * 
     */
    @RequestMapping(params = "method=updEntity")
    @ResponseBody
    public BaseData updEntity(@ModelAttribute CrudColumn entity) {
        if (entity != null) {
            crudColumnService.updH(entity);
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
        crudColumnService.batchDelH(CrudColumn.class, ids);
        return new BaseData();
    }

    /**
     * 判断名称是否重复
     * 
     * @throws IOException
     * @author cielo
     */
    @RequestMapping(params = "method=chkColumnName")
    @ResponseBody
    public Map<String, String> isRepeat() throws IOException {
        String id = this.getParam("id");
        String account = this.getParam("account");
        String hql = "from CrudColumn where  (id != ? or ? is null) and columnName = ?";
        boolean isRepeat = crudColumnService.isExist(hql, id, id, account);
        return super.isRepeat(isRepeat, "对不起，已存在该字段！", "该字段可用！");
    }

}
