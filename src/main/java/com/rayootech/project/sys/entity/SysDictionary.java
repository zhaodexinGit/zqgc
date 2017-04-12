package com.rayootech.project.sys.entity;

/**
 * 
 * <B>功能简述</B><br>
 * 数据字典实体
 * 
 * @date  2015年3月27日 上午10:36:56
 * @author    yongweif
 * @since     [project/v1.0]
 */
public class SysDictionary{
	private Integer id;
	/**
	 * 
	 */
	private String type;
	/**
	 * 
	 */
	private String code;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String remark;

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
// Getters & Setters
	/**
	 * Get 
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * Set 
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 * Get 
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * Set 
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * Get 
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * Set 
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * Get 
	 */
	public String getRemark(){
		return this.remark;
	}
	/**
	 * Set 
	 */
	public void setRemark(String remark){
		this.remark = remark;
	}
	
	/**
	 * 无参构造
	 */
	public SysDictionary(){}
	
} 