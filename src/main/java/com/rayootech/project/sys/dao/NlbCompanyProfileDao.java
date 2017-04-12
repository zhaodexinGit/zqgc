package com.rayootech.project.sys.dao;

import java.util.List;
import java.util.Map;

import com.rayootech.project.sys.entity.NlbCompanyProfile;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;

public interface NlbCompanyProfileDao {
	/**
	 * 删除指定id的记录
	 * @param id
	 * @return
	 */
    int deleteById(Integer id);
    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insert(NlbCompanyProfile record);

    /**
     * 插入一条记录
     * @param record
     * @return
     */
    int insertSelective(NlbCompanyProfile record);
    /**
     * 通过id获取一条记录
     * @param id
     * @return
     */
    NlbCompanyProfile findById(Integer id);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改除了大文本外的一条记录
	 * 
	 * @author huangkaizheng
	 * @param params
	 * @return
	 */
    int updateByPrimaryKeySelective(NlbCompanyProfile record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改一条记录的大文本
	 * 
	 * @author huangkaizheng
	 * @param params
	 * @return
	 */
    int updateByPrimaryKeyWithBLOBs(NlbCompanyProfile record);

    /**
     * 修改记录
     * 
     * @param record
     * @return
     */
    int update(NlbCompanyProfile record);
    
    /**
	 * 
	 * <B>功能简述</B><br>
	 * 获取公司介绍列表
	 * 返回json格式
	 * 未使用
	 * @author hkz
	 * @param page
	 * @param params
	 * @return
	 */
	String getNlbmmList(PageJson<NlbCompanyProfile> page, Map<String, Object> params);
	
    /**
	 * 
	 * <B>功能简述</B><br>
	 * 获取公司介绍列表
	 * 返回列表数组
	 * 未使用
	 * @author hkz
	 * @param pageData
	 * @param params
	 * @return
	 */
	List<NlbCompanyProfile> nlbmmList(Page<NlbCompanyProfile> pageData, Map<String, Object> params);
	
}