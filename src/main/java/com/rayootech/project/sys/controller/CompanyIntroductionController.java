package com.rayootech.project.sys.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.rayootech.project.sys.entity.CompanyIntroduction;
import com.rayootech.project.sys.service.CompanyIntroductionService;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 公司简介
 * 
 * @date 
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("front_sys/introduction")
public class CompanyIntroductionController {

	@Autowired
	private CompanyIntroductionService companyIntroductionService;
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 公司简介列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "list")
	public String queryList(HttpServletRequest request, Page<CompanyIntroduction> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", companyIntroductionService.queryList(pageData, params));
		return "front_sys/introduction/list";
	}
	/**
	 * 列表(json数据)
	 * 
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "getList")
	@ResponseBody
	public String getList(HttpServletRequest request, PageJson<CompanyIntroduction> pageData) {
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
	@RequestMapping("toAdd")
	public String toAddDynamic() {
		return "front_sys/introduction/add";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 诺兰帮动态上传方法
	 * 
	 * @author 
	 * @return
	 */
	@RequestMapping(value = "upload" ,method = RequestMethod.POST)
	public String uploadDynamic(MultipartHttpServletRequest multipartRequest,  
            HttpServletResponse response) throws IOException {
		return "front_sys/introduction/update";
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
	public String toDetail(HttpServletRequest request,String id, ModelMap modelMap) {
		CompanyIntroduction entity = companyIntroductionService.findById(id);
		modelMap.put("entity",entity);
		return "front_sys/introduction/detail";
	}
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到修改界面
	 * 
	 * @author hkz
	 * @return
	 */
	@RequestMapping("toUpdate")
	public String toUpdateDynamic(HttpServletRequest request,String id, ModelMap modelMap) {
		CompanyIntroduction entity = companyIntroductionService.findById(id);
		modelMap.put("entity",entity);
//		modelMap.put("user", JSON.toJSONString(nlbCompanyProfileService.(userId)));
		return "front_sys/introduction/update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "save")
	@ResponseBody
	public String saveDynamic(CompanyIntroduction entity) {
		return companyIntroductionService.save(entity);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "update")
	@ResponseBody
	public String updateDynamic(CompanyIntroduction entity) {
		return companyIntroductionService.updateAllValue(entity);
	}
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete")
	@ResponseBody
	public String deleteDynamic(String id) {
		return companyIntroductionService.deleteById(id);
	}
}
