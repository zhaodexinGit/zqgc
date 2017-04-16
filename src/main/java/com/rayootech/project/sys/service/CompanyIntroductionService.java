package com.rayootech.project.sys.service;

import java.util.Map;

import com.rayootech.project.sys.entity.CompanyIntroduction;
import com.rayootech.project.utils.orm.Page;

public interface CompanyIntroductionService {

	CompanyIntroduction findById(String id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司动态列表
	 * 
	 * @author hkz
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<CompanyIntroduction> queryList(Page<CompanyIntroduction> pageData, Map<String, Object> params);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @author hkz
	 * @param user
	 * @return
	 */
	String save(CompanyIntroduction entity);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @author hkz
	 * @param user
	 * @return
	 */
	String updateAllValue(CompanyIntroduction entity);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @author hkz
	 * @param id
	 * @return
	 */
	String deleteById(String id);

}
