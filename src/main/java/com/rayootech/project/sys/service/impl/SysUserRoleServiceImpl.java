package com.rayootech.project.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.ISysUserRoleDao;
import com.rayootech.project.sys.entity.SysUserRole;
import com.rayootech.project.sys.service.ISysUserRoleService;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

/**
 * 
 * <B>功能简述</B><br>
 * SysUserRole service接口实现
 * 
 * @date 2015年3月27日 上午10:41:50
 * @author yongweif
 * @since [project/service v1.0]
 */
@Service
public class SysUserRoleServiceImpl extends MyBatisService<SysUserRole, Integer> implements ISysUserRoleService {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * logBack日志
	 */
	private static final Logger log = LoggerFactory.getLogger(SysUserRoleServiceImpl.class);

	@Autowired
	private ISysUserRoleDao sysUserRoleDao;

	public Page<SysUserRole> sysUserRoleList(Page<SysUserRole> pageData, Map<String, Object> params) {
		return super.findPage(pageData, params);
	}

	public SysUserRole getById(Integer id) {
		return super.get(id);
	}

	public String saveSysUserRole(SysUserRole sysUserRole) {
		try {
			if (super.insert(sysUserRole) != 0) {
				return "success";
			}
			return "success";
		} catch (Exception e) {
			log.error("save sysUserRole is error : ", e);
		}
		return "error";
	}

	public String updateSysUserRole(SysUserRole sysUserRole) {
		try {
			if (super.update(sysUserRole) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update sysUserRole is error : ", e);
		}
		return "error";
	}

	public String deleteSysUserRole(Integer id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete sysUserRole is error : ", e);
		}
		return "error";
	}

	public String getUserRoleIds(Map<String, Object> params) {
		List<SysUserRole> urList = super.find(params);
		String result = "";
		for (SysUserRole userRole : urList) {
			result += userRole.getRoleId() + ",";
		}
		if (result.length() > 0) {
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
}