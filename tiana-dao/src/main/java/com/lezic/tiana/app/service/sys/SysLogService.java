/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016-12-06 16:00:06</p>
 */
package com.lezic.tiana.app.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.tiana.app.entity.sys.SysLog;
import com.lezic.tiana.orm.service.BaseService;

/**
 * 系统管理 >  系统日志  服务类
 * @author cielo
 *
 */
@Service
@Transactional
public class SysLogService extends BaseService<SysLog> {
}
