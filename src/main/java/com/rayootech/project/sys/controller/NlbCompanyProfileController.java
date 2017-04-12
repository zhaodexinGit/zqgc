package com.rayootech.project.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.rayootech.project.sys.entity.NlbCompanyProfile;
import com.rayootech.project.sys.entity.User;
import com.rayootech.project.sys.service.ISysUserRoleService;
import com.rayootech.project.sys.service.IUserService;
import com.rayootech.project.sys.service.NlbCompanyProfileService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 诺兰帮密码管理
 * 
 * @date 
 * @author huangkaizheng
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("front_sys/nlbmm")
public class NlbCompanyProfileController {

	@Autowired
	private NlbCompanyProfileService nlbCompanyProfileService;
	
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳转到诺兰帮密码（公司介绍）列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "nlbmmList")
	public String nlbmmList(HttpServletRequest request, Page<NlbCompanyProfile> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", nlbCompanyProfileService.nlbmmList(pageData, params));
		return "front_sys/nlbmm/nlbmm";
	}
	/**
	 * 获取列表(json数据)
	 * 未使用
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "getNlbmmList")
	@ResponseBody
	public String getNlbmmList(HttpServletRequest request, PageJson<NlbCompanyProfile> pageData) {
//		Map<String, Object> params = Utils.reqParamToGenericMap(request);
//		return nlbCompanyProfileService.nlbmmList(pageData, params);
		return null;
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到添加界面
	 * 
	 * @author hkz
	 * @return
	 */
	@RequestMapping("toAddNlbmm")
	public String toAddNlbmm() {
		return "front_sys/nlbmm/nlbmm-add";
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮密码详情界面
	 * 
	 * @author yongweif
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(HttpServletRequest request,Integer id, ModelMap modelMap) {
		NlbCompanyProfile nlbmm = nlbCompanyProfileService.getById(id);
		modelMap.put("nlbmm", nlbmm); 
		return "front_sys/nlbmm/nlbmm-detail"; 
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮密码修改界面
	 * 
	 * @author hkz
	 * @return
	 */
	@RequestMapping("toUpdateNlbmm")
	public String toUpdateNlbmm(HttpServletRequest request,Integer id, ModelMap modelMap) {
		NlbCompanyProfile nlbmm = nlbCompanyProfileService.getById(id);
		modelMap.put("nlbmm", nlbmm); 
		return "front_sys/nlbmm/nlbmm-update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 新增到数据库
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveNlbmm")
	@ResponseBody
	public String saveNlbmm(HttpServletRequest request,NlbCompanyProfile nlbmm) {
		
		return nlbCompanyProfileService.saveNlbmm(nlbmm);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改到数据库
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateNlbmm")
	@ResponseBody
	public String updateNlbmm(NlbCompanyProfile nlbmm) {
		return nlbCompanyProfileService.updateNlbmm(nlbmm);
	}
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除数据库记录
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteNlbmm")
	@ResponseBody
	public String deleteNlbmm(Integer id) {
		return nlbCompanyProfileService.deleteNlbmm(id);
	}
	
}