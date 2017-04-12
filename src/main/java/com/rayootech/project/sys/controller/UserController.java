package com.rayootech.project.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.sys.service.ISysUserRoleService;
import com.rayootech.project.sys.service.IUserService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 系统用户管理
 * 
 * @date 2015年3月27日 上午10:14:03
 * @author yongweif
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("sys/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 用户列表
	 * 
	 * @date 2015年3月26日 上午9:49:54
	 * @author yongweif
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "userList")
	public String userList(HttpServletRequest request, Page<User> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", userService.userList(pageData, params));
		return "sys/user";
	}
	/**
	 * 列表(json数据)
	 * 
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "getUserList")
	@ResponseBody
	public String getUserList(HttpServletRequest request, PageJson<User> pageData) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		return userService.getUserList(pageData, params);
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到添加用户界面
	 * 
	 * @date 2015年3月26日 上午11:10:36
	 * @author yongweif
	 * @return
	 */
	@RequestMapping("toAddUser")
	public String toAddUser() {
		return "sys/user-add";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存用户
	 * 
	 * @date 2015年3月26日 上午11:15:54
	 * @author yongweif
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveUser")
	@ResponseBody
	public String saveUser(User user, String roleIds) {
		return userService.saveUser(user, roleIds);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳转到修改用户界面
	 * 
	 * @date 2015年3月26日 上午11:33:21
	 * @author yongweif
	 * @param userId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("toUpdateUser")
	public String toUpdateUser(HttpServletRequest request,Integer userId, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		params.put("userId",userId);
		modelMap.put("roles", sysUserRoleService.getUserRoleIds(params));
		modelMap.put("user", JSON.toJSONString(userService.getById(userId)));
		return "sys/user-update";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改用户
	 * 
	 * @date 2015年3月26日 上午11:33:48
	 * @author yongweif
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateUser")
	@ResponseBody
	public String updateUser(User user, String roleIds) {
		return userService.updateUser(user, roleIds);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @date 2015年3月26日 上午9:50:30
	 * @author yongweif
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteUser")
	@ResponseBody
	public String deleteUser(Integer id) {
		return userService.deleteUser(id);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 验证登录账号是否已经存在
	 * 
	 * @date 2015年3月26日 上午9:50:39
	 * @author yongweif
	 * @param request
	 * @param id
	 * @param userName
	 * @return
	 */
	@RequestMapping("uniqueValueUser")
	@ResponseBody
	public String uniqueValue(HttpServletRequest request, Integer id, String userName) {
		return userService.uniqueName(id, userName);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 初始化密码
	 * 
	 * @date 2015年3月26日 上午9:50:50
	 * @author yongweif
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "initializePassword", produces = { "text/text;charset=UTF-8" })
	@ResponseBody
	public String initializePassword(Integer userId) {
		return userService.initializePassword(userId);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改密码
	 * 
	 * @date 2015年3月26日 上午11:54:41
	 * @author yongweif
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	@RequestMapping(value = "updatePassword")
	@ResponseBody
	public String updatePassword(String oldPassword, String newPassword) {
		return userService.updatePassword(oldPassword, newPassword);
	}
}