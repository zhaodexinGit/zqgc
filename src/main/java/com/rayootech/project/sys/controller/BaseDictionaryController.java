package com.rayootech.project.sys.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rayootech.project.sys.entity.BaseAccessor;
import com.rayootech.project.sys.entity.BaseDictionary;
import com.rayootech.project.sys.service.BaseDictionaryService;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;

/**
 * 
 * <B>功能简述</B><br>
 * 诺兰帮数据字典管理
 * 
 * @date 
 * @author caolei
 * @since [project/v1.0]
 */
@Controller
@RequestMapping("front_sys/dictionary")
public class BaseDictionaryController {

	@Autowired
	private BaseDictionaryService baseDictionaryService;
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 数据字典列表页
	 * 
	 * @param request
	 * @param pageData
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "dictionaryList")
	public String dictionaryList(HttpServletRequest request, Page<BaseDictionary> pageData, ModelMap modelMap) {
		Map<String, Object> params = Utils.reqParamToGenericMap(request);
		modelMap.put("pageData", baseDictionaryService.dictionaryList(pageData, params));
		return "front_sys/dictionary/dictionary";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到添加界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toAddDictionary")
	public String toAddDictionary() {
		return "front_sys/dictionary/dictionary-add";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "saveDictionary")
	@ResponseBody
	public String saveDictionary(BaseDictionary dictionary) {
		return baseDictionaryService.saveDictionary(dictionary);
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮动态修改界面
	 * 
	 * @author caolei
	 * @return
	 */
	@RequestMapping("toUpdateDictionary")
	public String toUpdateDictionary(HttpServletRequest request,String id, ModelMap modelMap) {
		BaseDictionary dictionary = baseDictionaryService.getById(id);
		modelMap.put("dictionary",dictionary);
//		modelMap.put("user", JSON.toJSONString(nlbCompanyProfileService.(userId)));
		return "front_sys/dictionary/dictionary-update";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "updateDictionary")
	@ResponseBody
	public String updateDictionary(BaseDictionary dictionary) {
		return baseDictionaryService.updateDictionary(dictionary);
	}
	

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳到诺兰帮数据字典详情界面
	 * 
	 * @author yongweif
	 * @return
	 */
	@RequestMapping("toDetail")
	public String toDetail(HttpServletRequest request,String id, ModelMap modelMap) {
		BaseDictionary dictionary = baseDictionaryService.getById(id);
		modelMap.put("dictionary",dictionary);
		return "front_sys/dictionary/dictionary-detail";
	}
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteDictionary")
	@ResponseBody
	public String deleteDictionary(String id) {
		return baseDictionaryService.deleteDictionary(id);
	}
	
	
}
