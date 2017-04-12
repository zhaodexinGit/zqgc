package com.rayootech.project.sys.entity;

import java.util.Date;

/**
 * 公司动态（诺兰帮动态）
 * @author Administrator
 *
 */
public class NlbCompanyNews {
	/**
	 * 动态ID
	 */
    private Integer id;

    /**
	 * 动态标题
	 */
    private String title;

    /**
	 * 动态简介
	 */
    private String introduction;

    /**
	 * 动态简介图
	 */
    private String introduction_img;

    /**
	 * 创建者id
	 */
    private Integer create_user_id;

    /**
	 * 创建时间
	 */
    private Date create_time;

    /**
	 * 修改者id
	 */
    private Integer update_user_id;

    /**
	 * 修改时间
	 */
    private Date update_time;

    private String remark1;

    private String remark2;

    private String remark3;

    /**
	 * 内容
	 */
    private String content;
    
    /**
	 * 创建者
	 */
    private User createUser;
    
    /**
	 * 修改者
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getIntroduction_img() {
        return introduction_img;
    }

    public void setIntroduction_img(String introduction_img) {
        this.introduction_img = introduction_img == null ? null : introduction_img.trim();
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