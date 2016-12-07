/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016-12-07 09:31:55</p>
 */
package com.lezic.tiana.app.action.sys;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lezic.tiana.app.entity.sys.SysResource;
import com.lezic.tiana.app.service.sys.SysResourceService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.orm.Page;
import com.lezic.tiana.orm.ParamMap;
import com.lezic.tiana.orm.util.HibernateUtil;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.BaseController;

/**
 * 系统管理 >  资源菜单  控制器类
 * @author cielo
 *
 */
@Controller
@RequestMapping("/sys/resource.do")
public class SysResourceController extends BaseController {

	@Autowired
	private SysResourceService sysResourceService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/resource/SysResource-list";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping(params = "method=add", method = RequestMethod.GET)
	public String addPage() {
		return "/sys/resource/SysResource-add";
	}

	/**
	 * 修改页面
	 */
	@RequestMapping(params = "method=upd", method = RequestMethod.GET)
	public String updPage(Model model) {
		String id = this.getParam("id");
		if (DataUtil.isNotNull(id)) {
			model.addAttribute("entity", sysResourceService.getH(id));
		}
		return "/sys/resource/SysResource-upd";
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
	public Page<SysResource> loadData(@ModelAttribute SysResource entityParams) throws IOException {
		Page<SysResource> page = new Page<SysResource>();
		page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
		ParamMap params = new ParamMap();
		sysResourceService.pageM(page, "SysResource.getPageList", params);
		return page;
	}

	/**
	 * 新增
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=addEntity")
	@ResponseBody
	public BaseData addEntity(@ModelAttribute SysResource entity) throws IOException {
		sysResourceService.saveH(entity);
		return new BaseData();
	}

	/**
	 * 修改
	 * 
	 * @throws IOException
	 */
	@RequestMapping(params = "method=updEntity")
	public BaseData updEntity(@ModelAttribute SysResource item) throws IOException {
		if (item != null) {
			SysResource entity = sysResourceService.getH(item.getId());
			HibernateUtil.copyExcludeNull(entity, item);
			sysResourceService.updH(entity);
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
		sysResourceService.batchDelH(SysResource.class, ids);
		 return new BaseData();
	}

	/**
	 * 判断名称是否重复
	 * 
	 * @throws IOException
	 * @author cielo
	 */
	@RequestMapping(params = "method=isRepeat")
	@ResponseBody
	public Map<String, String> isRepeat() throws IOException {
		String id = this.getParam("id");
		String account = this.getParam("account");
		String hql = "from SysResource where  (id != ? or ? is null) and account = ?";
		boolean isRepeat = sysResourceService.isExist(hql, id, id, account);
		return super.isRepeat(isRepeat, "对不起，已存在该字典！", "该字典可用！");
	}

}
