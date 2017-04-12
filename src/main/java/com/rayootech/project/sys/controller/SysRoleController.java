package com.rayootech.project.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rayootech.project.sys.entity.SysRole;
import com.rayootech.project.sys.service.ISysRoleService;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * SysRole Controller类
 * 
 * @date  2015年5月5日 上午10:13:42
 * @author    hanchunlin
 * @since     [project/controller v1.0]
 */
@Controller
@RequestMapping("sys/sysRole")
public class SysRoleController {

	@Autowired
	private ISysRoleService sysRoleService;

   /**
    * 
    * <B>功能简述</B><br>
    * 角色列表
    * 
    * @date 2015年5月6日 上午10:57:57
    * @author hcl
    * @param request
    * @param pageData
    * @param modelMap
    * @return
    */
    @RequestMapping(value = "sysRoleList")
	public String sysRoleList(HttpServletRequest request, Page<SysRole> pageData,
			ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", sysRoleService.sysRoleList(pageData, params));
		return "sys/sysRole";
	}
    
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳转到添加页面
	 * 
	 * @date 2015年5月6日 上午10:58:10
	 * @author hcl
	 * @return
	 */
	@RequestMapping("toAddSysRole")
	public String toAddSysRole() {
		return "sys/sysRole-add";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @date 2015年5月6日 上午10:58:23
	 * @author hcl
	 * @param request
	 * @param sysRole
	 * @return
	 */
	@RequestMapping(value = "saveSysRole")
	@ResponseBody
	public String saveSysRole(HttpServletRequest request,SysRole sysRole) {
		return sysRoleService.saveSysRole(request,sysRole);
	}

    /**
     * 
     * <B>功能简述</B><br>
     * 跳转到修改页面
     * 
     * @date 2015年5月6日 上午10:58:34
     * @author hcl
     * @param id
     * @param modelMap
     * @return
     */
	@RequestMapping("toUpdateSysRole")
	public String toUpdateSysRole(Integer id, ModelMap modelMap) {
	    modelMap.put("sysRole",JSON.toJSONString(sysRoleService.getById(id)));
		return "sys/sysRole-update";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @date 2015年5月6日 上午10:58:44
	 * @author hcl
	 * @param sysRole
	 * @return
	 */
	@RequestMapping(value = "updateSysRole")
	@ResponseBody
	public String updateSysRole(SysRole sysRole) {
		return sysRoleService.updateSysRole(sysRole);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @date 2015年5月6日 上午10:58:56
	 * @author hcl
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteSysRole")
	@ResponseBody
	public String deleteSysRole(Integer id) {
		return sysRoleService.deleteSysRole(id);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 校验角色编码是否已经存在
	 * 
	 * @date 2015年5月6日 上午11:17:34
	 * @author hcl
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "checkoutRoleCode")
	@ResponseBody
	public String checkoutRoleCode(HttpServletRequest request){
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		return sysRoleService.checkoutRoleCode(params);
	}
	
	/**
     * 
     * <B>功能简述</B><br>
     * 所有角色
     * 
     * @date 2015年5月6日 下午2:05:53
     * @author yongweif
     * @param request
     * @return
     */
	@RequestMapping(value = "allRole")
	@ResponseBody
	public String allRole(HttpServletRequest request) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		return sysRoleService.allRole(params);
	}
}