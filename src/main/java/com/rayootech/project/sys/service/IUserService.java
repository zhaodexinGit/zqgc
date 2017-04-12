package com.rayootech.project.sys.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.rayootech.project.sys.entity.User;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;

public interface IUserService {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 用户列表
	 * 
	 * @date 2015年3月26日 上午11:34:10
	 * @author yongweif
	 * @param pageData
	 * @param params
	 * @return
	 */
	Page<User> userList(Page<User> pageData, Map<String, Object> params);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @date 2015年3月26日 上午11:55:14
	 * @author yongweif
	 * @param user
	 * @return
	 */
	String saveUser(User user, String roleIds);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @date 2015年3月26日 上午11:55:21
	 * @author yongweif
	 * @param user
	 * @return
	 */
	String updateUser(User user, String roleIds);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @date 2015年3月25日 上午11:29:15
	 * @author yongweif
	 * @param id
	 * @return
	 */
	String deleteUser(Integer id);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 用户登录
	 * 
	 * @date 2015年3月25日 上午11:29:22
	 * @author yongweif
	 * @param request
	 * @param userName
	 * @param passWord
	 * @param validateCode
	 * @return
	 */
	String loginIn(HttpServletRequest request, String userName,
			String passWord, String validateCode);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 校验登录名是否存在
	 * 
	 * @date 2015年3月25日 上午11:29:30
	 * @author yongweif
	 * @param id
	 * @param userName
	 * @return
	 */
	String uniqueName(Integer id, String userName);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 初始化密码
	 * 
	 * @date 2015年3月25日 上午11:29:38
	 * @author yongweif
	 * @param id
	 * @return
	 */
	String initializePassword(Integer id);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改密码
	 * 
	 * @date 2015年3月26日 上午11:54:56
	 * @author yongweif
	 * @param oldPassword
	 * @param newPassword
	 * @return
	 */
	String updatePassword(String oldPassword, String newPassword);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 * 
	 * @date 2015年3月25日 上午11:32:00
	 * @author yongweif
	 * @param user
	 */
	void entryptPassword(User user);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 功能详细描述
	 * 
	 * @date 2015年3月25日 下午2:40:58
	 * @author yongweif
	 * @param id
	 * @return
	 */
	User getById(Integer id);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 授权时获取用户列表
	 * 
	 * @date 2015年5月6日 下午1:40:24
	 * @author yongweif
	 * @param page
	 * @param params
	 * @return
	 */
	String getUserList(PageJson<User> page, Map<String, Object> params);
}