package com.rayootech.project.sys.service.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.BaseAccessorDao;
import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.sys.service.BaseAccessorService;
import com.rayootech.project.utils.Sequence;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;
@Service
public class BaseAccessorServiceImpl extends MyBatisService<BaseAccessor, String> implements BaseAccessorService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(BaseAccessorServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	
	@Autowired
	private BaseAccessorDao baseAccessorDao;
	
	public String saveAccessor(BaseAccessor accessor) {
		// TODO Auto-generated method stub
		try {
			if(accessor.getBAID()==null || "".equals(accessor.getBAID()))
				accessor.setBAID(Sequence.getSequence());
//			accessor.setDPID(Sequence.getSequence());
			if(super.insert(accessor)!=0){
				return "success";
			} 
		} catch (Exception e) {
			log.error("insert nlbCompanyNews is error : ", e);
		}
		return "error";
		
	}
    
	
	
	public String updateAccessor(BaseAccessor accessor) {
		try {
			
			if (super.update(accessor) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update nlbCompanyNews is error : ", e);
		}
		return "error";
	}

	/**
	 * 删除上传附件
	 */
	public String deleteAccessor(String id, String path) {
		try {
			//如果删除数据库记录成功再删除物理文件
			BaseAccessor accessor = baseAccessorDao.findById(id);
			if (super.delete(id) != 0) {
				//文件
				File file = new File(accessor.getFILEPATH(), accessor.getFILENAME());
				file.delete();
				return "success";
			}
		} catch (Exception e) {
			log.error("delete nlbCompanyNews is error : ", e);
		}
		return "error";
	}

	public BaseAccessor getById(String id) {
		// TODO Auto-generated method stub
		return baseAccessorDao.findById(id);
	}


	public Page<BaseAccessor> accessorList(Page<BaseAccessor> pageData,
			Map<String, Object> params) {
		// TODO Auto-generated method stub
		return super.findPage(pageData, params);
	}

	/**
	 * 列表查询
	 * 
	 * @param params
	 * @return
	 */
	public List<BaseAccessor> find(Map<String, Object> params) {
		return super.find(params);
	}
	
	/**
	 * 根据dpid查询
	 * @param dpid
	 * @return
	 */
	public List<BaseAccessor> query(String dpid) {
		return baseAccessorDao.query(dpid);
	}
}
