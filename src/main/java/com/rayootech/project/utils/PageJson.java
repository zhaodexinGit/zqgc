package com.rayootech.project.utils;


import org.apache.ibatis.session.RowBounds;

public class PageJson<T> {

	private int rows = 10; // 默认每页显示10条数据
	private int page = 1; // 当前页码
	
	//private String order; //顺序 asc  aesc 
	//private String sort;  //排序字段

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if (page <= 0) {
			this.page = 1;
		} else {
			this.page = page;
		}
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public RowBounds getRowBounds() {
		return new RowBounds(getRows() * (getPage() - 1), getRows());
	}
}