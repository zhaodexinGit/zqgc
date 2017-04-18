package com.rayootech.project.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.BaseDictionaryDao;
import com.rayootech.project.sys.entity.BaseDictionary;
import com.rayootech.project.sys.service.BaseDictionaryService;
import com.rayootech.project.utils.Sequence;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

@Service
public class BaseDictionaryServiceImpl extends MyBatisService< BaseDictionary,String> implements BaseDictionaryService{

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseDictionaryServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired 
	private BaseDictionaryDao baseDictionaryDao;
	
	public String saveDictionary(BaseDictionary dictionary) {
		// TODO Auto-generated method stub
		try {
			dictionary.setBDID(Sequence.getSequence());
			if(super.insert(dictionary)!=0){
				return "success";
			} 
		} catch (Exception e) {
			log.error("insert baseDictionary is error : ", e);
		}
		return "error";
		
	}
	
	public String updateDictionary(BaseDictionary dictionary) {
		try {
			
			if (super.update(dictionary) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update baseDictionary is error : ", e);
		}
		return "error";
	}
	
	public String deleteDictionary(String id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete baseDictionary is error : ", e);
		}
		return "error";
	}
	
	public BaseDictionary getById(String id) {
		// TODO Auto-generated method stub
		return baseDictionaryDao.findById(id);
	}
	
	public Page<BaseDictionary> dictionaryList(Page<BaseDictionary> pageData,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findPage(pageData, params);
	}

	public List<BaseDictionary> getListByType(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseDictionaryDao.getListByType(params);
	}
}
