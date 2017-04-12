package com.rayootech.project.sys.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.rayootech.project.sys.dao.ISysRoleDao;
import com.rayootech.project.sys.entity.SysRole;
import com.rayootech.project.sys.service.ISysRoleService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole service接口实现
 * 
 * @date  2015年5月6日 上午10:41:50
 * @author    hanchunlin
 * @since     [project/service v1.0]
 */
@Service
public class SysRoleServiceImpl extends MyBatisService<SysRole, Integer>implements
		ISysRoleService {
    /**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * logBack日志
	 */
	private static final Logger log = LoggerFactory.getLogger(SysRoleServiceImpl.class);
	
	@Autowired
	private ISysRoleDao sysRoleDao;
	
	public Page<SysRole> sysRoleList(Page<SysRole> pageData,Map<String, Object> params) {
		return super.findPage(pageData, params);
	}
	
	public SysRole getById(Integer id){
	    return super.get(id);
	}
	
	public String saveSysRole(HttpServletRequest request,SysRole sysRole){
		try {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			sysRole.setCreator(user.getId());
			sysRole.setCreateTime(Utils.getCurrentDatetime());
			if (super.insert(sysRole) != 0) {
				return "success";
			}
			return "success";
		} catch (Exception e) {
			log.error("save sysRole is error : ", e);
		}
		return "error";
	}
	
	public  String updateSysRole(SysRole sysRole){
	    try {
			if (super.update(sysRole) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update sysRole is error : ", e);
		}
		return "error";
	}
	
	public String deleteSysRole(Integer id){
	    try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete sysRole is error : ", e);
		}
		return "error";
	}

	public String checkoutRoleCode(Map<String, Object> params) {
        try {
        	int isExist =sysRoleDao.checkoutRoleCode(params);
    		if(isExist>0){
    			return "false";
    		}
		} catch (Exception e) {
			log.error(" checkoutRoleCode SysRole is error : ", e);
		}		
    	return "true";
	}

	public String allRole(Map<String, Object> params) {
		params.put("status", 1);
		return JSON.toJSONString(super.find(params));
	}
}