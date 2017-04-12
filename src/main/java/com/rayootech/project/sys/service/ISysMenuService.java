package com.rayootech.project.sys.service;

import java.util.List;

import com.rayootech.project.sys.entity.SysMenu;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 service接口
 * 
 * @date 2015年3月27日 上午10:39:49
 * @author yongweif
 * @since [project/service v1.0]
 */
public interface ISysMenuService {

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 所有菜单List
	 * 
	 * @date 2015年3月28日 下午2:09:53
	 * @author yongweif
	 * @return
	 */
	List<Object> getAllMenu();

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取所有一级菜单
	 * 
	 * @date 2015年3月27日 下午4:20:20
	 * @author yongweif
	 * @return
	 */
	List<SysMenu> getOneMenu();

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取 用户菜单
	 * 
	 * @date 2015年3月28日 下午2:09:59
	 * @author yongweif
	 * @param userId
	 * @return
	 */
	List<Object> getUserMenu(int userId);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 改变菜单顺序
	 * 
	 * @date 2015年3月27日 下午4:21:50
	 * @author yongweif
	 * @param menuId
	 * @param moveId
	 * @param orderNum1
	 * @param orderNum2
	 * @return
	 */
	String updateMenuOrderNum(int menuId, int moveId, Integer orderNum1, Integer orderNum2);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id得到菜单详细
	 * 
	 * @date 2015年3月28日 下午2:10:26
	 * @author yongweif
	 * @param id
	 * @return
	 */
	SysMenu getById(Integer id);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存菜单
	 * 
	 * @date 2015年3月28日 下午2:10:44
	 * @author yongweif
	 * @param sysMenu
	 * @return
	 */
	String saveSysMenu(SysMenu sysMenu);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改菜单
	 * 
	 * @date 2015年3月28日 下午2:10:54
	 * @author yongweif
	 * @param sysMenu
	 * @return
	 */
	String updateSysMenu(SysMenu sysMenu);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除菜单
	 * 
	 * @date 2015年3月28日 下午2:11:05
	 * @author yongweif
	 * @param id
	 * @return
	 */
	String deleteSysMenu(Integer id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 授权时获取菜单列表
	 * 
	 * @date 2015年5月6日 下午1:51:01
	 * @author yongweif
	 * @param parentId
	 * @return
	 */
	List<SysMenu> listMenu(int parentId);
}