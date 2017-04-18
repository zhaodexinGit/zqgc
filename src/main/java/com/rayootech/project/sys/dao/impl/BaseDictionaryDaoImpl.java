package com.rayootech.project.sys.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.rayootech.project.sys.dao.BaseDictionaryDao;
import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.sys.entity.BaseDictionary;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class BaseDictionaryDaoImpl extends MyBatisDao<BaseDictionary, String> implements BaseDictionaryDao {

	public int deleteById(String BDID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertRecord(BaseDictionary record) {
		
		return getSqlSession().insert("BaseDictionary.insert", record);
	}

	public int insertSelective(BaseDictionary record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public BaseDictionary findById(String BDID) {
		// TODO Auto-generated method stub 
		BaseDictionary bd = getSqlSession().selectOne(getMapperMethod("findById"), BDID);
		return getSqlSession().selectOne(getMapperMethod("findById"), BDID);
	}

	public int updateByPrimaryKeySelective(BaseDictionary record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateById(BaseDictionary record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<BaseDictionary> getListByType(Map<String, Object> params) {
		return null;
		// TODO Auto-generated method stub
//		return getSqlSession().select(getMapperMethod("getListByType"), params);
	}

}
