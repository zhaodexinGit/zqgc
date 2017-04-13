package com.rayootech.project.sys.service.impl;

import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.BookkeepingAgencyDao;
import com.rayootech.project.sys.entity.BookkeepingAgency;
import com.rayootech.project.sys.service.BookkeepingAgencyService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;
@Service
public class BookkeepingAgencyServiceImpl extends MyBatisService<BookkeepingAgency, String> implements BookkeepingAgencyService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BookkeepingAgencyServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private BookkeepingAgencyDao BookkeepingAgencyDao;
	
	public String save(BookkeepingAgency entity) {
		// TODO Auto-generated method stub
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			
			if(user == null){
				throw new Exception("用户未登录");
			}else{
				entity.setOperate_userid(user.getId().toString());
				entity.setOperate_time(Utils.getCurrentDatetime().toString().substring(0, 19));
			}
			
			if(BookkeepingAgencyDao.insert(entity)!=0){
				return "success";
			}
		} catch (Exception e) {
			log.error("insert BookkeepingAgency is error : ", e);
		}
		return "error";
		
	}
    
	
	
	public String updateAllValue(BookkeepingAgency entity) {
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
			log.error("update BookkeepingAgency is error : ", e);
		}
		return "error";
	}

	public String delete(String id) {
		try {
			if (BookkeepingAgencyDao.deleteById(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete BookkeepingAgency is error : ", e);
		}
		return "error";
	}

	public Page<BookkeepingAgency> queryList(Page<BookkeepingAgency> pageData,
			Map<String, Object> params) {
		return super.findPage(pageData, params);
	}

	public BookkeepingAgency findById(String id) {
		// TODO Auto-generated method stub
		return BookkeepingAgencyDao.findById(id);
	}


}
