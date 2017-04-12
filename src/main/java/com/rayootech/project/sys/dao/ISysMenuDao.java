package com.rayootech.project.sys.dao;

import java.util.List;

import com.rayootech.project.sys.entity.SysMenu;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 dao接口
 * 
 * @date 2015年3月27日 上午10:35:16
 * @author yongweif
 * @since [project/dao v1.0]
 */
public interface ISysMenuDao {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * sdfdui
	 * 
	 * @date 2015年3月27日 下午5:14:39
	 * @author yongweif
	 * @return
	 */
	List<SysMenu> getAllMenu();

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取所有一级菜单
	 * 
	 * @date 2015年3月28日 下午2:14:50
	 * @author yongweif
	 * @return
	 */
	List<SysMenu> getOneMenu();

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取用户菜单
	 * 
	 * @date 2015年3月28日 下午2:15:06
	 * @author yongweif
	 * @param userId
	 * @return
	 */
	List<SysMenu> getUserMenu(Integer userId);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取最大排序值
	 * 
	 * @date 2015年3月28日 下午2:15:19
	 * @author yongweif
	 * @return
	 */
	int getMaxOrderNum();
}