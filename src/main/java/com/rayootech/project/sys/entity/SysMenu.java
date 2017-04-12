package com.rayootech.project.sys.entity;

import java.util.List;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 实体
 * 
 * @date 2015年3月27日 上午10:34:24
 * @author yongweif
 * @since [project/基础类v1.0]
 */
public class SysMenu {
	private Integer id;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜单地址
	 */
	private String menuUrl;
	/**
	 * 0禁用1启用
	 */
	private String isDisable;
	/**
	 * 菜单等级
	 */
	private String menuLevel;
	/**
	 * 父级菜单id
	 */
	private Integer parentMenuId;
	/**
	 * 菜单排序
	 */
	private Integer orderNum;
	/**
	 * 图标样式
	 */
	private String iconClass;

	private String checked;

	private List<SysMenu> children;

	private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	// Getters & Setters
	/**
	 * Get 菜单名称
	 */
	public String getMenuName() {
		return this.menuName;
	}

	/**
	 * Set 菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	/**
	 * Get 菜单地址
	 */
	public String getMenuUrl() {
		return this.menuUrl;
	}

	/**
	 * Set 菜单地址
	 */
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	/**
	 * Get 0禁用1启用
	 */
	public String getIsDisable() {
		return this.isDisable;
	}

	/**
	 * Set 0禁用1启用
	 */
	public void setIsDisable(String isDisable) {
		this.isDisable = isDisable;
	}

	/**
	 * Get 菜单等级
	 */
	public String getMenuLevel() {
		return this.menuLevel;
	}

	/**
	 * Set 菜单等级
	 */
	public void setMenuLevel(String menuLevel) {
		this.menuLevel = menuLevel;
	}

	/**
	 * Get 父级菜单id
	 */
	public Integer getParentMenuId() {
		return this.parentMenuId;
	}

	/**
	 * Set 父级菜单id
	 */
	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	/**
	 * Get 菜单排序
	 */
	public Integer getOrderNum() {
		return this.orderNum;
	}

	/**
	 * Set 菜单排序
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * Get 图标样式
	 */
	public String getIconClass() {
		return this.iconClass;
	}

	/**
	 * Set 图标样式
	 */
	public void setIconClass(String iconClass) {
		this.iconClass = iconClass;
	}

	public String getChecked() {
		return checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public List<SysMenu> getChildren() {
		return children;
	}

	public void setChildren(List<SysMenu> children) {
		this.children = children;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	/**
	 * 无参构造
	 */
	public SysMenu() {
	}

}