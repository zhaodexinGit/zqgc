package com.rayootech.project.sys.entity;

import java.sql.Timestamp;

/**
 * 
 * <B>功能简述</B><br>
 * SysUserRole 实体
 * 
 * @date 2015年3月27日 上午10:34:24
 * @author yongweif
 * @since [project/基础类v1.0]
 */
public class SysUserRole {
	private Integer id;
	/**
	 * 用户ID
	 */
	private int userId;
	/**
	 * 角色ID
	 */
	private int roleId;
	/**
	 * 创建人
	 */
	private int creator;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Getters & Setters
	/**
	 * Get 用户ID
	 */
	public int getUserId() {
		return this.userId;
	}

	/**
	 * Set 用户ID
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get 角色ID
	 */
	public int getRoleId() {
		return this.roleId;
	}

	/**
	 * Set 角色ID
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * Get 创建人
	 */
	public int getCreator() {
		return this.creator;
	}

	/**
	 * Set 创建人
	 */
	public void setCreator(int creator) {
		this.creator = creator;
	}

	/**
	 * Get 创建时间
	 */
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * Set 创建时间
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * 无参构造
	 */
	public SysUserRole() {
	}

}