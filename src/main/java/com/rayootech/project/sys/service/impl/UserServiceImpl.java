package com.rayootech.project.sys.service.impl;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.IUserDao;
import com.rayootech.project.sys.entity.SysUserRole;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.sys.service.ISysUserRoleService;
import com.rayootech.project.sys.service.IUserService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.sys.utils.encoding.Encodes;
import com.rayootech.project.sys.utils.security.Digests;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;
import com.google.common.collect.Maps;

@Service
public class UserServiceImpl extends MyBatisService<User, Integer> implements IUserService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ISysUserRoleService sysUserRoleService;
	

	public String loginIn(HttpServletRequest request, String userName, String passWord, String validateCode) {
		try {
			HttpSession session = request.getSession(true);
			if(null!=session.getAttribute("sValiCode")){
				String sValiCode = session.getAttribute("sValiCode").toString();
				if (!sValiCode.equals(validateCode.toLowerCase())) {
					return "errorCode"; // 验证码错误
				}
			}else{
				return "errorCode"; // 验证码错误
			}
			
			if (userName != null && passWord != null && userName.length() > 0 && passWord.length() > 0) {
				UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
				// subject权限对象
				Subject subject = SecurityUtils.getSubject();
				subject.login(token);

				ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
				if (user != null) {
					if (user.enablestatus == 1) {
						return "success";
					} else {
						// 用户被禁用
						return "forbiden";
					}
				}
			} else {
				// 用户名或密码为空
				return "emptyUser";
			}
		} catch (Exception e) {
			 log.error("user loginIn is error : ", e);
		}
		return "error";
	}

	public User getById(Integer id) {
		return super.get(id);
	}

	public Page<User> userList(Page<User> pageData, Map<String, Object> params) {
		return super.findPage(pageData, params);
	}

	public String saveUser(User user, String roleIds) {
		try {
			entryptPassword(user);
			ShiroUser loginUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
			user.setCreateUser(loginUser.getUserName());
			user.setCreateDate(Utils.getCurrentDatetime());
			if (super.insert(user) != 0) {
				if(roleIds!=null && !"".equals(roleIds)){
					String[] roleArray= roleIds.split(",");
					for (int i = 0; i < roleArray.length; i++) {
						SysUserRole ur = new SysUserRole();
						ur.setUserId(user.getId());
						ur.setRoleId(Integer.parseInt(roleArray[i]));
						ur.setCreator(user.getId());
						ur.setCreateTime(Utils.getCurrentDatetime());
						sysUserRoleService.saveSysUserRole(ur);
					}
				}
				return "success";
			}
			return "success";
		} catch (Exception e) {
			log.error("save user is error : ", e);
		}
		return "error";
	}

	public String updateUser(User user, String roleIds) {
		try {
			if (super.update(user) != 0) {
				sysUserRoleService.deleteSysUserRole(user.getId());
				if(roleIds!=null && !"".equals(roleIds)){
					String[] roleArray= roleIds.split(",");
					for (int i = 0; i < roleArray.length; i++) {
						SysUserRole ur = new SysUserRole();
						ur.setUserId(user.getId());
						ur.setRoleId(Integer.parseInt(roleArray[i]));
						ur.setCreator(user.getId());
						ur.setCreateTime(Utils.getCurrentDatetime());
						sysUserRoleService.saveSysUserRole(ur);
					}
				}
				return "success";
			}
		} catch (Exception e) {
			log.error("update user is error : ", e);
		}
		return "error";
	}

	public String deleteUser(Integer id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete user is error : ", e);
		}
		return "error";
	}

	public String uniqueName(Integer id, String userName) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("id", id);
		params.put("userName", userName);
		if (userDao.uniqueName(params) > 0) {
			return "false";
		}
		return "true";
	}

	public String initializePassword(Integer id) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		byte[] hashPassword = Digests.sha1("admin".getBytes(), salt, HASH_INTERATIONS);
		User user = new User();
		user.setId(id);
		user.setPassWord(Encodes.encodeHex(hashPassword));
		user.setSalt(Encodes.encodeHex(salt));
		if (super.update(user) != 0) {
			return "success";
		}
		return "error";
	}

	public String updatePassword(String oldPassword, String newPassword) {
		ShiroUser loginUser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		byte[] salt = Encodes.decodeHex(loginUser.getSalt());
		byte[] hashPassword = Digests.sha1(oldPassword.getBytes(), salt, HASH_INTERATIONS);
		String password = Encodes.encodeHex(hashPassword);
		if (!password.equals(loginUser.getPassWord())) {
			return "oldError";
		}
		byte[] newhashPassword = Digests.sha1(newPassword.getBytes(), salt, HASH_INTERATIONS);
		String newpassword = Encodes.encodeHex(newhashPassword);

		User user = new User();
		user.setId(loginUser.getId());
		user.setPassWord(newpassword);
		user.setEnableStatus(1);
		if (super.update(user) != 0) {
			return "success";
		}
		return "error";
	}

	public void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPassWord().getBytes(), salt, HASH_INTERATIONS);
		user.setPassWord(Encodes.encodeHex(hashPassword));
	}

	public String getUserList(PageJson<User> page, Map<String, Object> params) {
		return userDao.getUserList(page, params);
	}
}