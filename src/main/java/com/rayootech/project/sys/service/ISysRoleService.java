package com.rayootech.project.sys.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rayootech.project.sys.entity.SysRole;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole service接口
 * 
 * @date  2015年5月6日 上午10:39:49
 * @author    hanchunlin
 * @since     [project/service v1.0]
 */
public interface ISysRoleService{
    /**
     * 
     * <B>功能简述</B><br>
     * 角色列表
     * 
     * @date 2015年5月6日 上午10:59:31
     * @author hcl
     * @param pageData
     * @param params
     * @return
     */
    Page<SysRole> sysRoleList(Page<SysRole> pageData, Map<String, Object> params);
    /**
     * 
     * <B>功能简述</B><br>
     * 根据id得到详细
     * 
     * @date 2015年5月6日 上午10:59:55
     * @author hcl
     * @param id
     * @return
     */
    SysRole getById(Integer id);
    /**
     * 
     * <B>功能简述</B><br>
     * 保存
     * 
     * @date 2015年5月6日 上午11:00:08
     * @author hcl
     * @param request
     * @param sysRole
     * @return
     */
    String saveSysRole(HttpServletRequest request,SysRole sysRole);
    /***
     * 
     * <B>功能简述</B><br>
     * 修改
     * 
     * @date 2015年5月6日 上午11:00:19
     * @author hcl
     * @param sysRole
     * @return
     */
    String updateSysRole(SysRole sysRole);
   /**
    * 
    * <B>功能简述</B><br>
    * 删除
    * 
    * @date 2015年5月6日 上午11:00:39
    * @author hcl
    * @param id
    * @return
    */
    String deleteSysRole(Integer id);
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 验证角色编码是否存在
	 * 
	 * @date 2015年5月6日 上午10:30:06
	 * @author hcl
	 * @param params
	 * @param roleCode ： 角色编码
	 * @return
	 */
	String checkoutRoleCode(Map<String, Object> params);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 所有角色
	 * 
	 * @date 2015年5月6日 下午2:07:31
	 * @author yongweif
	 * @param params
	 * @return
	 */
	String allRole(Map<String, Object> params);
}