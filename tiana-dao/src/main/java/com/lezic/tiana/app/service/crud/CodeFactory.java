/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 上午11:49:27</p>
 */
package com.lezic.tiana.app.service.crud;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lezic.tiana.app.entity.crud.CrudColumn;
import com.lezic.tiana.app.entity.crud.CrudTable;
import com.lezic.tiana.util.ClassUtil;
import com.lezic.tiana.util.DateUtil;
import com.lezic.tiana.util.FileUtil;
import com.lezic.tiana.util.VelocityUtil;


/**
 * 代码工厂
 * 
 * @author cielo
 *
 */
public class CodeFactory {

	public static Logger logger = LogManager.getLogger();

	public static String outputPath = "D:\\crud";

	public static void processTemplate(CrudTable table, List<CrudColumn> columns) throws IOException {
		String templatePath = ClassUtil.getRootPath() + File.separator + "crud" + File.separator + "template"
				+ File.separator;

		String templateContent = null;// 模板内容
		String content = null;// 生成内容
		String destPath = null;// 生成路径

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("table", table);
		params.put("columns", columns);
		params.put("now", DateUtil.formatDate(new Date(),DateUtil.P_YYYYMMDDHHMMSS));
		params.put("mark", "$");

		// entity
		logger.debug("自动生成 实体类......");
		templateContent = FileUtil.getContent(templatePath + "Entity.txt");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + table.getEntityPackage().replace(".", File.separator) + File.separator
				+ table.getEntity() + ".java";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

		// Controller
		logger.debug("自动生成 控制器类......");
		templateContent = FileUtil.getContent(templatePath + "Controller.txt");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + table.getControllerPackage().replace(".", File.separator)
				+ File.separator + table.getController() + ".java";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

		// Service
		logger.debug("自动生成 服务层类......");
		templateContent = FileUtil.getContent(templatePath + "Service.txt");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + table.getServicePackage().replace(".", File.separator) + File.separator
				+ table.getService() + ".java";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

		// addPage.jsp
		logger.debug("自动生成 列表JSP......");
		templateContent = FileUtil.getContent(templatePath + "listPage.jsp");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + "jsp" + File.separator + table.getListJsp() + ".jsp";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

		// addPage.jsp
		logger.debug("自动生成 新增JSP......");
		templateContent = FileUtil.getContent(templatePath + "addPage.jsp");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + "jsp" + File.separator + table.getAddJsp() + ".jsp";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

		// updPage.jsp
		logger.debug("自动生成 修改JSP......");
		templateContent = FileUtil.getContent(templatePath + "updPage.jsp");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + "jsp" + File.separator + table.getUpdJsp() + ".jsp";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);
		
		// mybatis.xml
		logger.debug("自动生成 mybatis配置......");
		templateContent = FileUtil.getContent(templatePath + "mybatis.xml");
		content = VelocityUtil.process(templateContent, params);
		destPath = outputPath + File.separator + "mybatis" + File.separator + table.getMybatisXml() + ".xml";
		FileUtil.write(destPath, content);
		logger.debug("生成成功！路径：" + destPath);

	}

	public static void main(String[] args) {

	}

}
