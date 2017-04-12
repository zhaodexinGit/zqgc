package com.rayootech.project.sys.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.dao.IUserDao;
import com.rayootech.project.sys.dao.NlbCompanyProfileDao;
import com.rayootech.project.sys.entity.NlbCompanyProfile;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.sys.service.NlbCompanyProfileService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

@Component
public class NlbCompanyProfileDaoImpl extends MyBatisDao<NlbCompanyProfile, Integer> implements NlbCompanyProfileDao {

	private static final long serialVersionUID = 1L;

	public String getNlbmmList(PageJson<NlbCompanyProfile> page, Map<String, Object> params) {
		Map<String,Object> mr=new HashMap<String, Object>();
		int tatalRows=getListCount(params);
		mr.put("total",tatalRows);
		if(tatalRows==0){
			mr.put("rows",new ArrayList<Map<String,Object>>());
		}else{
			List<NlbCompanyProfile> list = getSqlSession().selectList(getMapperMethod("find"), params,page.getRowBounds());
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

	public List<NlbCompanyProfile> nlbmmList(Page<NlbCompanyProfile> pageData,
			Map<String, Object> params) {
		
		int tatalRows=getListCount(params);
		if(tatalRows==1){
			return new ArrayList<NlbCompanyProfile>();
		}else{
			List<NlbCompanyProfile> list = getSqlSession().selectList(getMapperMethod("find"), params,pageData.getRowBounds());
			return list;
		}
	}

	public String saveNlbmm(NlbCompanyProfile nlbmm) {
		// TODO Auto-generated method stub
		return null;
	}

	public String updateNlbmm(NlbCompanyProfile nlbmm) {
		// TODO Auto-generated method stub
		return null;
	}

	public String deleteNlbmm(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insertSelective(NlbCompanyProfile record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public NlbCompanyProfile findById(Integer id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperMethod("findById"), id);
	}

	public int updateByPrimaryKeySelective(NlbCompanyProfile record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateByPrimaryKeyWithBLOBs(NlbCompanyProfile record) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Page<NlbCompanyProfile> nlbmmList(PageJson<NlbCompanyProfile> page,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}
}