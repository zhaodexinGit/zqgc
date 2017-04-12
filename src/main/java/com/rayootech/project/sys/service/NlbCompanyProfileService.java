package com.rayootech.project.sys.service;

import java.util.List;
import java.util.Map;

import com.rayootech.project.sys.entity.NlbCompanyProfile;
import com.rayootech.project.utils.orm.Page;

public interface NlbCompanyProfileService {
	
	NlbCompanyProfile getById(Integer id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司介绍列表
	 * 
	 * @author hkz
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<NlbCompanyProfile> nlbmmList(Page<NlbCompanyProfile> pageData, Map<String, Object> params);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @author hkz
	 * @param user
	 * @return
	 */
	String saveNlbmm(NlbCompanyProfile nlbmm);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @author hkz
	 * @param user
	 * @return
	 */
	String updateNlbmm(NlbCompanyProfile nlbmm);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @author hkz
	 * @param id
	 * @return
	 */
	String deleteNlbmm(Integer id);


}