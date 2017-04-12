package com.rayootech.project.sys.dao.impl;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rayootech.project.sys.dao.ISysRoleDao;
import com.rayootech.project.sys.entity.SysRole;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole dao接口实现
 * 
 * @date  2015年5月5日 上午10:38:12
 * @author    author
 * @since     [project/dao v1.0]
 */
@Component
public class SysRoleDaoImpl extends MyBatisDao<SysRole, Integer> implements ISysRoleDao {
    /**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;

	public int checkoutRoleCode(Map<String, Object> params) {
		return getSqlSession().selectOne(getMapperMethod("checkoutRoleCode"), params);
	}

}