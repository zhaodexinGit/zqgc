package com.rayootech.project.sys.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.dao.CompanyIntroductionDao;
import com.rayootech.project.sys.entity.CompanyIntroduction;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class CompanyIntroductionDaoImpl extends MyBatisDao<CompanyIntroduction, String> implements CompanyIntroductionDao{
	
	private static final long serialVersionUID = 1L;


	/**
	 * 
	 * <B>功能简述</B><br>
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	public String getListJson(PageJson<CompanyIntroduction> page,
			Map<String, Object> params) {
		Map<String,Object> mr=new HashMap<String, Object>();
		int tatalRows=getListCount(params);
		mr.put("total",tatalRows);
		if(tatalRows==0){
			mr.put("rows",new ArrayList<Map<String,Object>>());
		}else{
			List<CompanyIntroduction> list = getSqlSession().selectList(getMapperMethod("find"), params,page.getRowBounds());
			mr.put("rows",list);
		}
		return JSON.toJSONStringWithDateFormat(mr, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	}

	private int getListCount(Map<String, Object> params) {
		if (null == params) {
			return getSqlSession().selectOne(getMapperMethod("count"));
		}
		return getSqlSession().selectOne(getMapperMethod("count"), params);
	}
	

	public List<CompanyIntroduction> dynamicList(Page<CompanyIntroduction> pageData,
			Map<String, Object> params) {
		int tatalRows=getListCount(params);
		if(tatalRows==1){
			return new ArrayList<CompanyIntroduction>();
		}else{
			List<CompanyIntroduction> list = getSqlSession().selectList(getMapperMethod("find"), params,pageData.getRowBounds());
			return list;
		}
	}

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().delete(getMapperMethod("deleteById"), id);
	}

	public int insert(CompanyIntroduction record) {
		// TODO Auto-generated method stub
		return getSqlSession().insert(getMapperMethod("insert"), record);
	}

	


	public CompanyIntroduction findById(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperMethod("findById"), id);
	}

	
	
}
