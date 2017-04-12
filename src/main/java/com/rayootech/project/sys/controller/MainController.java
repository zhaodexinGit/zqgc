package com.rayootech.project.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rayootech.project.sys.service.ISysMenuService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;

/**
 * 
 * <B>功能简述</B><br>
 * 主界面
 * 
 * @date  2015年3月27日 上午10:13:22
 * @author    yongweif
 * @since     [project/controller v1.0]
 */
@Controller
@RequestMapping("main")
public class MainController {

	@Autowired
	private ISysMenuService sysMenuService;
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 主页面
	 * 
	 * @date 2015年3月25日 上午11:19:36
	 * @author yongweif
	 * @param url
	 * @return
	 */
	@RequestMapping("{url}")
	public String main(@PathVariable("url") String url,ModelMap modelMap) {
		if ("index".equals(url)) {
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			modelMap.put("user", user);
			modelMap.put("menus",sysMenuService.getUserMenu(user.getId()));
	    }
		
		return "sys/".concat(url);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 错误页面
	 * 
	 * @date 2015年3月25日 上午11:19:03
	 * @author yongweif
	 * @param url
	 * @return
	 */
	@RequestMapping("error/{url}")
	public String error(@PathVariable("url") String url) {
		return "sys/".concat(url);
	}
}
