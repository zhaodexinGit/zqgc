package com.rayootech.project.sys.service;

import java.util.Map;

import com.rayootech.project.sys.entity.SysUserRole;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * SysUserRole service接口
 * 
 * @date 2015年3月27日 上午10:39:49
 * @author yongweif
 * @since [project/service v1.0]
 */
public interface ISysUserRoleService {
	/**
	 * 列表
	 * 
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<SysUserRole> sysUserRoleList(Page<SysUserRole> pageData, Map<String, Object> params);

	/**
	 * 根据id得到详细
	 * 
	 * @param id
	 * @return
	 */
	SysUserRole getById(Integer id);

	/**
	 * 保存
	 * 
	 * @param sysUserRole
	 * @return
	 */
	String saveSysUserRole(SysUserRole sysUserRole);

	/**
	 * 修改
	 * 
	 * @param sysUserRole
	 * @return
	 */
	String updateSysUserRole(SysUserRole sysUserRole);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	String deleteSysUserRole(Integer id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取用户角色ids
	 * 
	 * @date 2015年5月6日 下午4:51:25
	 * @author yongweif
	 * @param params
	 * @return
	 */
	String getUserRoleIds(Map<String, Object> params);
	
}