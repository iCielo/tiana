/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016 下午3:57:39</p>
 */
package com.lezic.tiana.app.service.sys;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lezic.tiana.app.entity.sys.SysUser;
import com.lezic.tiana.orm.service.BaseService;

/**
 * @author cielo
 *
 */
@Service
@Transactional
public class SysUserService extends BaseService<SysUser> {
}
