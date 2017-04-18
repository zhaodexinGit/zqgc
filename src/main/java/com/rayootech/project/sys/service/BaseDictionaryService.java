package com.rayootech.project.sys.service;

import java.util.List;
import java.util.Map;

import com.rayootech.project.sys.entity.BaseDictionary;
import com.rayootech.project.utils.orm.Page;

public interface BaseDictionaryService {

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
	BaseDictionary getById(String id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 数据字典列表
	 * 
	 * @author caolei
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<BaseDictionary> dictionaryList(Page<BaseDictionary> pageData, Map<String, Object> params);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String saveDictionary(BaseDictionary dictionary);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @author caolei
	 * @param user
	 * @return
	 */
	String updateDictionary(BaseDictionary dictionary);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @author caolei
	 * @param id
	 * @return
	 */
	String deleteDictionary(String id);

	List<BaseDictionary> getListByType(Map<String, Object> params);
}
