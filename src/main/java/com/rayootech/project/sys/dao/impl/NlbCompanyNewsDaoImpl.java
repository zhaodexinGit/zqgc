package com.rayootech.project.sys.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.dao.NlbCompanyNewsDao;
import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class NlbCompanyNewsDaoImpl extends MyBatisDao<NlbCompanyNews, Integer> implements NlbCompanyNewsDao{
	
	private static final long serialVersionUID = 1L;

	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(NlbCompanyNews record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public NlbCompanyNews findById(Integer id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperMethod("findById"), id);
	}

	public int updateByPrimaryKeySelective(NlbCompanyNews record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeyWithBLOBs(NlbCompanyNews record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司动态列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	public String getDynamicList(PageJson<NlbCompanyNews> page,
			Map<String, Object> params) {
		Map<String,Object> mr=new HashMap<String, Object>();
		int tatalRows=getListCount(params);
		mr.put("total",tatalRows);
		if(tatalRows==0){
			mr.put("rows",new ArrayList<Map<String,Object>>());
		}else{
			List<NlbCompanyNews> list = getSqlSession().selectList(getMapperMethod("find"), params,page.getRowBounds());
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
	

	public List<NlbCompanyNews> dynamicList(Page<NlbCompanyNews> pageData,
			Map<String, Object> params) {
		int tatalRows=getListCount(params);
		if(tatalRows==1){
			return new ArrayList<NlbCompanyNews>();
		}else{
			List<NlbCompanyNews> list = getSqlSession().selectList(getMapperMethod("find"), params,pageData.getRowBounds());
			return list;
		}
	}
	
}
