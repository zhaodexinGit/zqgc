package com.rayootech.project.sys.dao.impl;

import org.springframework.stereotype.Component;

import com.rayootech.project.sys.dao.ISysUserRoleDao;
import com.rayootech.project.sys.entity.SysUserRole;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

/**
 * 
 * <B>功能简述</B><br>
 * SysUserRole dao接口实现
 * 
 * @date 2015年3月27日 上午10:38:12
 * @author yongweif
 * @since [project/dao v1.0]
 */
@Component
public class SysUserRoleDaoImpl extends MyBatisDao<SysUserRole, Integer> implements ISysUserRoleDao {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;

}