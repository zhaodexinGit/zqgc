package com.rayootech.project.sys.dao;

import java.util.List;

import com.rayootech.project.sys.entity.BaseAccessor;

public interface BaseAccessorDao {

	/**
	 * 删除指定id的记录
	 * @param id
	 * @return
	 */
    int deleteById(String BAID);

    /**
	 * 插入一条记录
	 * @param record
	 * @return
	 */
    int insertRecord(BaseAccessor record);

    /**
	 * 插入一条记录
	 * @param record
	 * @return
	 */
    int insertSelective(BaseAccessor record);
    
    /**
	 * 根据id查询一条记录
	 * @param record
	 * @return
	 */
    BaseAccessor findById(String BAID);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改一条记录
	 * 
	 * @author caolei
	 * @param params
	 * @return
	 */
    int updateByPrimaryKeySelective(BaseAccessor record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改一条记录
	 * 
	 * @author caolei
	 * @param params
	 * @return
	 */
    int updateByPrimaryKey(BaseAccessor record);
    
    /**
	 * 根据dpid查询
	 * @param dpid
	 * @return
	 */
	List<BaseAccessor> query(String dpid);
}