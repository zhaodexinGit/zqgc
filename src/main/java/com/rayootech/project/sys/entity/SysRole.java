package com.rayootech.project.sys.entity;
import java.sql.Timestamp;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole 实体
 * 
 * @date  2015年3月27日 上午10:34:24
 * @author    author
 * @since     [project/基础类v1.0]
 */
public class SysRole{
	private Integer id;
	/**
	 * 角色编码
	 */
	private String roleCode;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 1启用、0禁用
	 */
	private String status;
	/**
	 * 角色描述
	 */
	private String remark;
	/**
	 * 创建人
	 */
	private int creator;
	/**
	 * 创建时间
	 */
	private Timestamp createTime;

	/**
	 * 创建人名字
	 */
	private String creatorName; // 创建人姓名
	
	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
// Getters & Setters
	/**
	 * Get 角色编码
	 */
	public String getRoleCode(){
		return this.roleCode;
	}
	/**
	 * Set 角色编码
	 */
	public void setRoleCode(String roleCode){
		this.roleCode = roleCode;
	}
	/**
	 * Get 角色名称
	 */
	public String getRoleName(){
		return this.roleName;
	}
	/**
	 * Set 角色名称
	 */
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	/**
	 * Get 1启用、0禁用
	 */
	public String getStatus(){
		return this.status;
	}
	/**
	 * Set 1启用、0禁用
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * Get 角色描述
	 */
	public String getRemark(){
		return this.remark;
	}
	/**
	 * Set 角色描述
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	/**
	 * Get 创建人
	 */
	public int getCreator(){
		return this.creator;
	}
	/**
	 * Set 创建人
	 */
	public void setCreator(int creator){
		this.creator = creator;
	}
	/**
	 * Get 创建时间
	 */
	public Timestamp getCreateTime(){
		return this.createTime;
	}
	/**
	 * Set 创建时间
	 */
	public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	}
	
	/**
	 * 无参构造
	 */
	public SysRole(){}
	
} 