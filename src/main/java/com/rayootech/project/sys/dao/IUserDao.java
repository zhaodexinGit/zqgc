package com.rayootech.project.sys.dao;

import java.util.Map;

import com.rayootech.project.sys.entity.User;
import com.rayootech.project.utils.PageJson;

public interface IUserDao {
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 通过userName查询详细信息
	 * 
	 * @date 2015年3月25日 上午11:36:46
	 * @author yongweif 
	 * @param userName
	 * @return
	 */
	User loginIn(String userName);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 检验用户名是否唯一
	 * 
	 * @date 2015年3月24日 下午5:48:20
	 * @author yongweif
	 * @param params
	 * @return
	 */
	int uniqueName(Map<String, Object> params);
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 授权时获取用户列表
	 * 
	 * @date 2015年5月6日 下午1:40:52
	 * @author yongweif
	 * @param page
	 * @param params
	 * @return
	 */
	String getUserList(PageJson<User> page, Map<String, Object> params);
}