package com.rayootech.project.sys.entity;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 实体
 * 
 * @date 2015年3月27日 上午10:34:24
 * @author yongweif
 * @since [project/基础类v1.0]
 */
public class SysUserMenu {
	private Integer id;
	/**
	 * 用户id
	 */
	private int userId;
	/**
	 * 菜单id
	 */
	private int menuId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Getters & Setters
	/**
	 * Get 用户id
	 */
	public int getUserId() {
		return this.userId;
	}

	/**
	 * Set 用户id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get 菜单id
	 */
	public int getMenuId() {
		return this.menuId;
	}

	/**
	 * Set 菜单id
	 */
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	/**
	 * 无参构造
	 */
	public SysUserMenu() {
	}

}