package com.rayootech.project.sys.service;

import java.util.Map;

import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.utils.orm.Page;

public interface NlbCompanyNewsService {

	NlbCompanyNews getById(Integer id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司动态列表
	 * 
	 * @author caolei
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<NlbCompanyNews> dynamicList(Page<NlbCompanyNews> pageData, Map<String, Object> params);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String saveDynamic(NlbCompanyNews dynamic);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String updateDynamic(NlbCompanyNews dynamic);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @author caolei
	 * @param id
	 * @return
	 */
	String deleteDynamic(Integer id);

}
