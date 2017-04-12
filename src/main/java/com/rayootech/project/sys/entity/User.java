package com.rayootech.project.sys.entity;

import java.sql.Timestamp;

public class User {
	private Integer id;
	/**
	 * 
	 */
	private String userName;
	/**
	 * 
	 */
	private String passWord;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private String email;
	/**
	 * 
	 */
	private String mobile;
	/**
	 * 
	 */
	private String loginIp;
	/**
	 * 0禁用,1启用
	 */
	private int enableStatus;
	/**
	 * 
	 */
	private String createUser;
	/**
	 * 
	 */
	private Timestamp createDate;
	/**
	 * 
	 */
	private Timestamp loginTime;
	/**
	 * 
	 */
	private int failedTimes;
	/**
	 * 
	 */
	private String salt;

	/**
	 * 角色
	 */
	private String roles;

	// Getters & Setters

	/**
	 * Get
	 */
	public String getUserName() {
		return this.userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get
	 */
	public String getPassWord() {
		return this.passWord;
	}

	/**
	 * Set
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * Get
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * Set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * Get
	 */
	public String getLoginIp() {
		return this.loginIp;
	}

	/**
	 * Set
	 */
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	/**
	 * Get 0禁用,1启用
	 */
	public int getEnableStatus() {
		return this.enableStatus;
	}

	/**
	 * Set 0禁用,1启用
	 */
	public void setEnableStatus(int enableStatus) {
		this.enableStatus = enableStatus;
	}

	/**
	 * Get
	 */
	public String getCreateUser() {
		return this.createUser;
	}

	/**
	 * Set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * Get
	 */
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * Set
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * Get
	 */
	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	/**
	 * Set
	 */
	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	/**
	 * Get
	 */
	public int getFailedTimes() {
		return this.failedTimes;
	}

	/**
	 * Set
	 */
	public void setFailedTimes(int failedTimes) {
		this.failedTimes = failedTimes;
	}

	/**
	 * Get
	 */
	public String getSalt() {
		return this.salt;
	}

	/**
	 * Set
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	/**
	 * 无参构造
	 */
	public User() {
	}
}