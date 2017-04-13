package com.rayootech.project.sys.service.impl;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.CompanyRegistryDao;
import com.rayootech.project.sys.entity.CompanyRegistry;
import com.rayootech.project.sys.service.CompanyRegistryService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;
@Service
public class CompanyRegistryServiceImpl extends MyBatisService<CompanyRegistry, String> implements CompanyRegistryService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(CompanyRegistryServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private CompanyRegistryDao CompanyRegistryDao;
	
	public String save(CompanyRegistry entity) {
		// TODO Auto-generated method stub
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			
			if(user == null){
				throw new Exception("用户未登录");
			}else{
				entity.setOperate_userid(user.getId().toString());
				entity.setOperate_time(Utils.getCurrentDatetime().toString().substring(0, 19));
			}
			
			if(CompanyRegistryDao.insert(entity)!=0){
				return "success";
			}
		} catch (Exception e) {
			log.error("insert CompanyRegistry is error : ", e);
		}
		return "error";
		
	}
    
	
	
	public String updateAllValue(CompanyRegistry entity) {
		try {
			
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			
			if(user==null){
				throw new Exception("用户未登录");
			}else {
				entity.setOperate_userid(user.getId().toString());
				entity.setOperate_time(Utils.getCurrentDatetime().toString().substring(0, 19));
			}
			if (super.update(entity) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update CompanyRegistry is error : ", e);
		}
		return "error";
	}

	public String delete(String id) {
		try {
			if (CompanyRegistryDao.deleteById(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete CompanyRegistry is error : ", e);
		}
		return "error";
	}

	public Page<CompanyRegistry> queryList(Page<CompanyRegistry> pageData,
			Map<String, Object> params) {
		return super.findPage(pageData, params);
	}

	public CompanyRegistry findById(String id) {
		// TODO Auto-generated method stub
		return CompanyRegistryDao.findById(id);
	}


}
