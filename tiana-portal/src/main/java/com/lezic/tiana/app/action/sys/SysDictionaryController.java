/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Wed Feb 24 11:00:01 CST 2016</p>
 */
package com.lezic.tiana.app.action.sys;

import java.io.IOException;
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

import com.lezic.tiana.app.entity.sys.SysDictionary;
import com.lezic.tiana.app.service.sys.SysDictionaryService;
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
@RequestMapping("/sys/dictionary.do")
public class SysDictionaryController extends BaseController {

	private Logger logger = LogManager.getLogger();

	@Autowired
	private SysDictionaryService sysDictionaryService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/dictionary/SysDictionary-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/sys/dictionary/SysDictionary-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Long id,Model model) {
		if (id!=null) {
			model.addAttribute("entity", sysDictionaryService.getH(id));
		}
		return "/sys/dictionary/SysDictionary-upd";
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
	public Page<SysDictionary> loadData(@ModelAttribute SysDictionary entityParams) throws IOException {
		Page<SysDictionary> page = new Page<SysDictionary>();
		page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
		ParamMap params = new ParamMap();
		params.putLike("sort", entityParams.getSort());
		params.putLike("dictKey", entityParams.getDictKey());
		params.put("status", entityParams.getStatus());
		sysDictionaryService.pageM(page, "SysDictionary.getPageList", params);
		return page;
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addEntity")
	@ResponseBody
	public BaseData addEntity(@ModelAttribute SysDictionary entity) throws IOException {
		sysDictionaryService.saveH(entity);
		return new BaseData();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updEntity")
	@ResponseBody
	public BaseData updEntity(@ModelAttribute SysDictionary item) throws IOException {
		if (item != null) {
			SysDictionary entity = sysDictionaryService.getH(item.getId());
			HibernateUtil.copyExcludeNull(entity, item);
			sysDictionaryService.updH(entity);
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
		sysDictionaryService.batchDelH(SysDictionary.class, ids);
		 return new BaseData();
	}

	/**
	 * 判断名称是否重复
	 * 
	 * @throws IOException
	 * @author cielo
	 */
	@RequestMapping(params = "method=chkDictKey")
	@ResponseBody
	public Map<String, String> chkDictKey() throws IOException {
		String id = this.getParam("id");
		String sort = this.getParam("sort");
		String dictKey = this.getParam("dictKey");
		String hql = "from SysDictionary where  (id != ? or ? is null) and sort = ? and (dictKey = ? or ? is null)";
		boolean isRepeat = sysDictionaryService.isExist(hql, id, id, sort, dictKey, dictKey);
		return super.isRepeat(isRepeat, "对不起，已存在该字典！", "该字典可用！");
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
			String hql = "update SysDictionary set status = :status where id in (:ids)";
			params.put("status", status);
			params.put("ids", ids);
			sysDictionaryService.executeH(hql, params);
			sysDictionaryService.initCache();
			return new BaseData();
		}
	}

}
