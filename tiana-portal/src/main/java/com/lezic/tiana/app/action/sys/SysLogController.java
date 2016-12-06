/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016-12-06 16:11:58</p>
 */
package com.lezic.tiana.app.action.sys;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lezic.tiana.app.entity.sys.SysLog;
import com.lezic.tiana.app.service.sys.SysLogService;
import com.lezic.tiana.constant.BaseData;
import com.lezic.tiana.orm.Page;
import com.lezic.tiana.orm.ParamMap;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.BaseController;

/**
 * 系统管理 >  系统日志  控制器类
 * @author cielo
 *
 */
@Controller
@RequestMapping("/sys/log.do")
public class SysLogController extends BaseController {

	@Autowired
	private SysLogService sysLogService;

	/**
	 * 列表页面
	 * 
	 * @param model
	 * @return
	 * @author cielo
	 */
	@RequestMapping(params = "method=list", method = RequestMethod.GET)
	public String listPage() {
		return "/sys/log/SysLog-list";
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
	public Page<SysLog> loadData(@ModelAttribute SysLog entityParams) throws IOException {
		Page<SysLog> page = new Page<SysLog>();
		page.setOffset(DataUtil.integerOfString(this.getParam("offset"), 0));
		page.setPageSize(DataUtil.integerOfString(this.getParam("limit"), 10));
		ParamMap params = new ParamMap();
		params.put("clue", entityParams.getClue());
		sysLogService.pageM(page, "SysLog.getPageList", params);
		return page;
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
		sysLogService.batchDelH(SysLog.class, ids);
		 return new BaseData();
	}

}
