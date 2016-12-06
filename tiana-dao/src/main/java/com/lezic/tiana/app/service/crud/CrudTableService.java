/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:55:08</p>
 */
package com.lezic.tiana.app.service.crud;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.lezic.tiana.app.entity.crud.CrudColumn;
import com.lezic.tiana.app.entity.crud.CrudTable;
import com.lezic.tiana.orm.service.BaseService;
import com.lezic.tiana.util.DataUtil;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class CrudTableService extends BaseService<CrudTable> {

	@Autowired
	private CrudColumnService crudColumnService;

	/**
	 * 新增对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void addEntity(CrudTable entity) {
		super.saveH(entity);
	}

	/**
	 * 修改对象
	 * 
	 * @param entity
	 * @author cielo
	 */
	public void updEntity(CrudTable entity) {
		super.updH(entity);
	}
	
	/**
	 * 更新表字段
	 * @param tableName
	 * @author cielo
	 */
	public void updateColumns(String tableName){
		Assert.isTrue(DataUtil.isNotNull(tableName));
		crudColumnService.batchNewColumn(tableName);
	}

	/**
	 * 运行代码工厂，生成代码
	 * 
	 * @param tableName
	 * @author cielo
	 * @throws IOException 
	 */
	@SuppressWarnings("unchecked")
	public void processCode(String tableName) throws IOException {
		CrudTable table = (CrudTable) super.findOneH("from CrudTable where tableName = ?", false, tableName);
		List<CrudColumn> columns = (List<CrudColumn>) super.findH("from CrudColumn where tableName = ?", tableName);
		CodeFactory.processTemplate(table, columns);
	}

}
