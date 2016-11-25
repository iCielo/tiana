/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Mon Nov 28 13:58:05 CST 2016</p>
 */
package com.lezic.tiana.app.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.tiana.app.entity.sys.SysLog;
import com.lezic.tiana.orm.service.BaseService;


/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysLogService extends BaseService<SysLog> {
}
