package com.rayootech.project.sys.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.dao.IUserDao;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class UserDaoImpl extends MyBatisDao<User, Integer> implements IUserDao {

	private static final long serialVersionUID = 1L;

	public User loginIn(String userName) {
		return getSqlSession().selectOne(getMapperMethod("loginIn"), userName);
	}

	public int uniqueName(Map<String, Object> params) {
		return getSqlSession().selectOne(getMapperMethod("uniqueName"), params);
	}
	
	public String getUserList(PageJson<User> page, Map<String, Object> params) {
		Map<String,Object> mr=new HashMap<String, Object>();
		int tatalRows=getUserListCount(params);
		mr.put("total",tatalRows);
		if(tatalRows==0){
			mr.put("rows",new ArrayList<Map<String,Object>>());
		}else{
			List<User> list = getSqlSession().selectList(getMapperMethod("find"), params,page.getRowBounds());
			mr.put("rows",list);
		}
		return JSON.toJSONStringWithDateFormat(mr, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	}
	
	private int getUserListCount(Map<String, Object> params) {
		if (null == params) {
			return getSqlSession().selectOne(getMapperMethod("count"));
		}
		return getSqlSession().selectOne(getMapperMethod("count"), params);
	}
}