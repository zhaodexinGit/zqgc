package com.rayootech.project.sys.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.sys.service.NlbCompanyNewsService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 诺兰帮动态管理
 * 
 * @date 
 * @author caolei
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("front_sys/dynamic")
public class NlbCompanyNewsController {

	@Autowired
	private NlbCompanyNewsService nlbCompanyNewsService;
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司动态列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "dynamicList")
	public String dynamicList(HttpServletRequest request, Page<NlbCompanyNews> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", nlbCompanyNewsService.dynamicList(pageData, params));
		return "front_sys/dynamic/dynamic";
	}
	/**
	 * 列表(json数据)
	 * 
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "getDynamicList")
	@ResponseBody
	public String getDynamicList(HttpServletRequest request, PageJson<NlbCompanyNews> pageData) {
//		Map<String, Object> params = Utils.reqParamToGenericMap(request);
//		return nlbCompanyProfileService.nlbmmList(pageData, params);
		return null;
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到添加界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toAddDynamic")
	public String toAddDynamic() {
		return "front_sys/dynamic/dynamic-add";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 诺兰帮动态上传方法
	 * 
	 * @author 
	 * @return
	 */
	@RequestMapping(value = "uploadDynamic" ,method = RequestMethod.POST)
	public String uploadDynamic(MultipartHttpServletRequest multipartRequest,  
            HttpServletResponse response) throws IOException {
		return "front_sys/dynamic/dynamic-update";
	}
	
	
	
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮动态详情界面
	 * 
	 * @author yongweif
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(HttpServletRequest request,Integer id, ModelMap modelMap) {
		NlbCompanyNews dynamic = nlbCompanyNewsService.getById(id);
		modelMap.put("dynamic",dynamic);
		return "front_sys/dynamic/dynamic-detail";
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮动态修改界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toUpdateDynamic")
	public String toUpdateDynamic(HttpServletRequest request,Integer id, ModelMap modelMap) {
		NlbCompanyNews dynamic = nlbCompanyNewsService.getById(id);
		modelMap.put("dynamic",dynamic);
//		modelMap.put("user", JSON.toJSONString(nlbCompanyProfileService.(userId)));
		return "front_sys/dynamic/dynamic-update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveDynamic")
	@ResponseBody
	public String saveDynamic(NlbCompanyNews dynamic) {
		return nlbCompanyNewsService.saveDynamic(dynamic);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateDynamic")
	@ResponseBody
	public String updateDynamic(NlbCompanyNews dynamic) {
		return nlbCompanyNewsService.updateDynamic(dynamic);
	}
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteDynamic")
	@ResponseBody
	public String deleteDynamic(Integer id) {
		return nlbCompanyNewsService.deleteDynamic(id);
	}
}
