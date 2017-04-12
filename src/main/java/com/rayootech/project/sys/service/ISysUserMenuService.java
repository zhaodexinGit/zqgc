package com.rayootech.project.sys.service;

import java.util.List;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 service接口
 * 
 * @date 2015年3月27日 上午10:39:49
 * @author yongweif
 * @since [project/service v1.0]
 */
public interface ISysUserMenuService {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除用户菜单
	 * 
	 * @date 2015年3月28日 下午2:13:10
	 * @author yongweif
	 * @param id
	 * @return
	 */
	String deleteSysUserMenu(Integer id);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获得用户菜单
	 * 
	 * @date 2015年3月28日 下午2:13:21
	 * @author yongweif
	 * @param userId
	 * @return
	 */
	List<Object> getUserMenu(Integer userId);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 给用户授权菜单
	 * 
	 * @date 2015年3月28日 下午2:13:35
	 * @author yongweif
	 * @param userIds
	 * @param menuIds
	 * @return
	 */
	String powerUserMemu(String userIds, String menuIds);
}