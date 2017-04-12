package com.rayootech.project.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rayootech.project.sys.service.ISysUserMenuService;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 Controller类
 * 
 * @date 2015年3月27日 上午10:13:42
 * @author yongweif
 * @since [project/controller v1.0]
 */
@Controller
@RequestMapping("sys/sysUserMenu")
public class SysUserMenuController {

	@Autowired
	private ISysUserMenuService sysUserMenuService;

	@RequestMapping(value = "toSysUserMenu")
	public String toSysUserMenu(ModelMap modelMap) {
		return "sys/sysUserMenu";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 查询用户菜单
	 * 
	 * @date 2015年3月28日 下午2:08:12
	 * @author yongweif
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "getUserMenu", produces = { "text/text;charset=UTF-8" })
	@ResponseBody
	public String getUserMenu(Integer userId) {
		return JSON.toJSONString(sysUserMenuService.getUserMenu(userId));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 用户菜单授权
	 * 
	 * @date 2015年3月28日 下午2:08:45
	 * @author yongweif
	 * @param userIds
	 * @param menuIds
	 * @return
	 */
	@RequestMapping("powerUserMemu")
	@ResponseBody
	public String powerUserMemu(String userIds, String menuIds) {
		return sysUserMenuService.powerUserMemu(userIds, menuIds);
	}
}