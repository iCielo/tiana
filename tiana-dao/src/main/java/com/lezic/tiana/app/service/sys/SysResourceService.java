/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016-12-07 09:31:55</p>
 */
package com.lezic.tiana.app.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.tiana.app.entity.sys.SysResource;
import com.lezic.tiana.orm.service.BaseService;

/**
 * 系统管理 >  资源菜单  服务类
 * @author cielo
 *
 */
@Service
@Transactional
public class SysResourceService extends BaseService<SysResource> {
}
