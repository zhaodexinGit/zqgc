package com.rayootech.project.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.sys.service.IUserService;
import com.rayootech.project.sys.utils.VerifyCodeUtils;

/**
 * 
 * <B>功能简述</B><br>
 * 登录模块
 * 
 * @date  2015年3月27日 上午10:12:53
 * @author    yongweif
 * @since     [project/controller v1.0]
 */
@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private IUserService userService;

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 转到登录页
	 * 
	 * @date 2015年3月25日 上午10:20:13
	 * @author yongweif
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "toLogin", method = RequestMethod.GET)
	public String login(ModelMap modelMap) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			ShiroUser user = (ShiroUser)subject.getPrincipal();
			if(user!=null){
				return "main/index";
			}
		}
		return "login";
	}

	/**
	 * 
	 * <B>验证码</B><br>
	 * 生成验证码
	 * 
	 * @date 2015年3月23日 下午7:55:52
	 * @author yongweif
	 * @param request
	 * @param response
	 * @param width
	 * @param height
	 * @throws Exception
	 */
	@RequestMapping("getValidateCode")
	public void getValidateCode(HttpServletRequest request,
			HttpServletResponse response, Integer width, Integer height)
			throws Exception {

		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		// 生成随机字串
		String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
		// 存入会话session
		HttpSession session = request.getSession(true);
		session.setAttribute("sValiCode", verifyCode.toLowerCase());
		// 生成图片
		int w = 200, h = 80;
		VerifyCodeUtils.outputImage(w, h, response.getOutputStream(),
				verifyCode);
	}
	/**
	 * 
	 * <B>登录</B><br>
	 * 用户登录
	 * 
	 * @date 2015年3月23日 下午7:56:27
	 * @author yongweif
	 * @param request
	 * @param username
	 * @param password
	 * @param validateCode
	 * @return
	 */
	@RequestMapping(value = "loginIn", produces = { "text/text;charset=UTF-8" })
	@ResponseBody
	public String loginIn(HttpServletRequest request, String userName,
			String passWord, String validateCode) {
		return userService.loginIn(request, userName, passWord, validateCode);
	}

	/**
	 * 
	 * <B>退出</B><br>
	 * 系统退出
	 * 
	 * @date 2015年3月23日 下午7:56:39
	 * @author yongweif
	 * @param request
	 * @return
	 */
	@RequestMapping("logout")
	public String logout(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		if (subject != null) {
			subject.logout();
		}
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "login";
	}
}
