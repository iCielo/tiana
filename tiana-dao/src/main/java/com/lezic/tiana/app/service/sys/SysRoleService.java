/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	Thu Jan 28 18:26:36 CST 2016</p>
 */
package com.lezic.tiana.app.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.tiana.app.entity.sys.SysRole;
import com.lezic.tiana.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysRoleService extends BaseService<SysRole> {
}
