package com.rayootech.project.sys.service.impl;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.NlbCompanyNewsDao;
import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.sys.service.NlbCompanyNewsService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;
@Service
public class NlbCompanyNewsServiceImpl extends MyBatisService<NlbCompanyNews, Integer> implements NlbCompanyNewsService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(NlbCompanyNewsServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private NlbCompanyNewsDao nlbCompanyNewsDao;
	
	public String saveDynamic(NlbCompanyNews dynamic) {
		// TODO Auto-generated method stub
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			
			if(user == null){
				throw new Exception("用户未登录");
			}else{
				dynamic.setCreate_user_id(user.getId());
				dynamic.setCreate_time(Utils.getCurrentDatetime());
			}
			
			if(super.insert(dynamic)!=0){
				return "success";
			}
		} catch (Exception e) {
			log.error("insert nlbCompanyNews is error : ", e);
		}
		return "error";
		
	}
    
	
	
	public String updateDynamic(NlbCompanyNews dynamic) {
		try {
			
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			
			if(user==null){
				throw new Exception("用户未登录");
			}else {
				dynamic.setUpdate_user_id(user.getId());
				dynamic.setUpdate_time(Utils.getCurrentDatetime());
			}
			if (super.update(dynamic) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update nlbCompanyNews is error : ", e);
		}
		return "error";
	}

	public String deleteDynamic(Integer id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete nlbCompanyNews is error : ", e);
		}
		return "error";
	}

	public Page<NlbCompanyNews> dynamicList(Page<NlbCompanyNews> pageData,
			Map<String, Object> params) {
		return super.findPage(pageData, params);
	}

	public NlbCompanyNews getById(Integer id) {
		// TODO Auto-generated method stub
		return nlbCompanyNewsDao.findById(id);
	}
}
