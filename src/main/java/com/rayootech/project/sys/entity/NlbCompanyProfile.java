package com.rayootech.project.sys.entity;

import java.util.Date;
/**
 * 公司简介（诺兰帮密码）实体类
 * @author Administrator
 *
 */
public class NlbCompanyProfile {
	/**
	 * 主键
	 */
    private Integer id;
    /**
	 * 标题
	 */
    private String title;
    /**
	 * 类型
	 */
    private String type;
    /**
	 * 创建用户id
	 * 
	 */
    private Integer create_user_id;
    /**
	 * 创建时间
	 */
    private Date create_time;
    /**
	 * 修改用户id
	 * 
	 */
    private Integer update_user_id;
    /**
	 * 修改时间
	 */
    private Date update_time;
    /**
	 * 备用字段1
	 */
    private String remark1;
    /**
	 * 备用字段2
	 */
    private String remark2;
    /**
	 * 备用字段3
	 */
    private String remark3;
    /**
	 * 内容
	 */
    private String content;
    /**
	 * 创建用户对象 一对一
	 */
    private User createUser;
    /**
	 * 修改用户对象 一对一
	 */
    private User updateUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(Integer create_user_id) {
        this.create_user_id = create_user_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(Integer update_user_id) {
        this.update_user_id = update_user_id;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1 == null ? null : remark1.trim();
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2 == null ? null : remark2.trim();
    }

    public String getRemark3() {
        return remark3;
    }

    public void setRemark3(String remark3) {
        this.remark3 = remark3 == null ? null : remark3.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	public User getCreateUser() {
		return createUser;
	}

	public void setCreateUser(User createUser) {
		this.createUser = createUser;
	}

	public User getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(User updateUser) {
		this.updateUser = updateUser;
	}

}