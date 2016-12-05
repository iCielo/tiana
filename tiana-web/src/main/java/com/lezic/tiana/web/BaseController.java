/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2015 下午1:52:24</p>
 */
package com.lezic.tiana.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lezic.tiana.orm.Page;
import com.lezic.tiana.util.DataUtil;
import com.lezic.tiana.web.util.ContextUtil;

/**
 * 控制器基类
 * 
 * @author cielo
 *
 */
public abstract class BaseController {

	private Logger logger = LogManager.getLogger(BaseController.class);

	/**
	 * 获取表单参数
	 * 
	 * @param name
	 * @return
	 * @author cielo
	 */
	public String getParam(String name) {
		String str = DataUtil.trim(ContextUtil.getCurrentRequest().getParameter(name));
		if (DataUtil.isNull(str)) {
			return null;
		}
		return str;
	}

	/**
	 * 获取表单参数
	 * 
	 * @param name
	 * @param defaultStr
	 * @return
	 * @author cielo
	 */
	public String getParam(String name, String defaultStr) {
		String str = getParam(name);
		return str == null ? defaultStr : str;
	}

	/**
	 * 将指定对象转为ajax字符串写入response
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void write(Object object) {
	    HttpServletResponse response = ContextUtil.getCurrentResponse();
		response.setContentType("application/json;charset=UTF-8");
		// response.setContentType("text/xml;charset=UTF-8");
		try {
			if (object instanceof Collection) {
				JSONArray jsonArray = JSONArray.fromObject(object);
				response.getWriter().write(jsonArray.toString());
			} else {
				JSONObject jsonObject = JSONObject.fromObject(object);
				response.getWriter().write(jsonObject.toString());
			}
		} catch (Exception e) {
			logger.error("系统错误！", e);
		}
	}

	/**
	 * 输出bootstrap table的数据
	 * 
	 * @param page
	 * @throws IOException
	 * @author cielo
	 */
	public void outBootstrapTable(Page<?> page) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (DataUtil.isEmpty(page.getRows())) {
			map.put("rows", new ArrayList<Object>());
		} else {
			map.put("rows", page.getRows());
		}

		map.put("total", page.getTotal());
		this.write(map);
	}

}
