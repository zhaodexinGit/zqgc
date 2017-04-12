package com.rayootech.project.utils;

import java.util.List;

/**
 * <B>功能简述</B><br>
 * JSON 分页实体
 * 
 * @date 2015年3月25日 上午11:53:46
 * @author XuSheng
 * @since [project/基础工具v1.0]
 */
public class JsonPageUtils {

	private List<?> list;
	private int pageNo;
	private int pageSize;
	private int sortTarget;

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getSortTarget() {
		return sortTarget;
	}

	public void setSortTarget(int sortTarget) {
		this.sortTarget = sortTarget;
	}

}
