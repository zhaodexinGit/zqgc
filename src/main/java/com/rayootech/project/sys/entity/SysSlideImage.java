package com.rayootech.project.sys.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 
 * <B>功能简述</B><br>
 * SysSlideImage 实体
 * 
 * @date 2015年5月12日 上午10:34:24
 * @author hanchunlin
 * @since [project/基础类v1.0]
 */
public class SysSlideImage {
	private Integer id;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 图片原地址
	 */
	private String imageUrl;
	/**
	 * 图片缩略图地址
	 */
	private String cropImageUrl;
	/**
	 * 图片详情地址
	 */
	private String detailImageUrl;
	/**
	 * 缩放比例
	 */
	private BigDecimal scale;
	/**
	 * 链接地址
	 */
	private String link;
	/**
	 * 排序
	 */
	private int orderNum;
	/**
	 * 创建日期
	 */
	private Timestamp createTime;
	/**
	 * 备注
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
	 * Get 标题
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Set 标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get 图片原地址
	 */
	public String getImageUrl() {
		return this.imageUrl;
	}

	/**
	 * Set 图片原地址
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * Get 图片缩略图地址
	 */
	public String getCropImageUrl() {
		return this.cropImageUrl;
	}

	/**
	 * Set 图片缩略图地址
	 */
	public void setCropImageUrl(String cropImageUrl) {
		this.cropImageUrl = cropImageUrl;
	}

	public String getDetailImageUrl() {
		return detailImageUrl;
	}

	public void setDetailImageUrl(String detailImageUrl) {
		this.detailImageUrl = detailImageUrl;
	}

	/**
	 * Get 缩放比例
	 */
	public BigDecimal getScale() {
		return this.scale;
	}

	/**
	 * Set 缩放比例
	 */
	public void setScale(BigDecimal scale) {
		this.scale = scale;
	}

	/**
	 * Get 链接地址
	 */
	public String getLink() {
		return this.link;
	}

	/**
	 * Set 链接地址
	 */
	public void setLink(String link) {
		this.link = link;
	}

	/**
	 * Get 排序
	 */
	public int getOrderNum() {
		return this.orderNum;
	}

	/**
	 * Set 排序
	 */
	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * Get 创建日期
	 */
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	/**
	 * Set 创建日期
	 */
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * Get 备注
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * Set 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 无参构造
	 */
	public SysSlideImage() {
	}

}