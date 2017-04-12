package com.rayootech.project.sys.dao;

import java.util.Map;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole dao接口
 * 
 * @date  2015年5月5日 上午10:35:16
 * @author    hanchunlin
 * @since     [project/dao v1.0]
 */
public interface ISysRoleDao {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 验证角色编码是否存在
	 * 
	 * @date 2015年5月6日 上午10:30:06
	 * @author hcl
	 * @param params
	 * @param roleCode ： 角色编码
	 * @return
	 */
	int checkoutRoleCode(Map<String, Object> params);
}