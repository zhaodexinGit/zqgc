package com.rayootech.project.sys.service;

import java.util.List;
import java.util.Map;

import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.utils.orm.Page;

public interface BaseAccessorService {

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 查出指定Id的记录
	 * 
	 * @author caolei
	 * @param pageData
	 * @param params
	 * @return
	 */
	BaseAccessor getById(String id);
	
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
	Page<BaseAccessor> accessorList(Page<BaseAccessor> pageData, Map<String, Object> params);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String saveAccessor(BaseAccessor accessor);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String updateAccessor(BaseAccessor accessor);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @author caolei
	 * @param id
	 * @return
	 */
	String deleteAccessor(String id, String path);

    /**
     * 根据条件查询
     * @param params
     * @return
     */
    List<BaseAccessor> find(Map<String, Object> params);
    
    /**
	 * 根据dpid查询
	 * @param dpid
	 * @return
	 */
    List<BaseAccessor> query(String dpid);
}
