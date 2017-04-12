package com.rayootech.project.sys.dao;

import java.util.List;

import com.rayootech.project.sys.entity.SysMenu;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 dao接口
 * 
 * @date 2015年3月27日 上午10:35:16
 * @author yongweif
 * @since [project/dao v1.0]
 */
public interface ISysUserMenuDao {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获得所有用户菜单
	 * 
	 * @date 2015年3月28日 下午2:15:39
	 * @author yongweif
	 * @param userId
	 * @return
	 */
	List<SysMenu> getMenuList(Integer userId);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 批量删除用户菜单
	 * 
	 * @date 2015年3月28日 下午2:15:52
	 * @author yongweif
	 * @param userIds
	 * @return
	 */
	int delBatchPowerMenu(String[] userIds);
}