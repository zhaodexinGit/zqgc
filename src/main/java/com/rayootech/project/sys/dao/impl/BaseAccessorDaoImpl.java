package com.rayootech.project.sys.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.dao.BaseAccessorDao;
import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class BaseAccessorDaoImpl extends MyBatisDao<BaseAccessor, String> implements BaseAccessorDao{
	
	private static final long serialVersionUID = 1L;

	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertRecord(BaseAccessor record) {
		
		return getSqlSession().insert("BaseAccessor.insert", record);
	}
	
	public int insertSelective(BaseAccessor record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public BaseAccessor findById(String id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperMethod("findById"), id);
	}

	public int updateByPrimaryKeySelective(BaseAccessor record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKey(BaseAccessor record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getAccessorList(PageJson<BaseAccessor> page,
			Map<String, Object> params) {
		Map<String,Object> mr=new HashMap<String, Object>();
		int tatalRows=getListCount(params);
		mr.put("total",tatalRows);
		if(tatalRows==0){
			mr.put("rows",new ArrayList<Map<String,Object>>());
		}else{
			List<BaseAccessor> list = getSqlSession().selectList(getMapperMethod("find"), params,page.getRowBounds());
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
	

	public List<BaseAccessor> accessorList(Page<BaseAccessor> pageData,
			Map<String, Object> params) {
		int tatalRows=getListCount(params);
		if(tatalRows==1){
			return new ArrayList<BaseAccessor>();
		}else{
			List<BaseAccessor> list = getSqlSession().selectList(getMapperMethod("find"), params,pageData.getRowBounds());
			return list;
		}
	}
	
	/**
	 * 根据dpid查询
	 * @param dpid
	 * @return
	 */
	public List<BaseAccessor> query(String dpid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("DPID", dpid);
		List<BaseAccessor> list = getSqlSession().selectList(getMapperMethod("find"), params);
		return list;
	}
}
