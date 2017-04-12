package com.rayootech.project.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.rayootech.project.sys.entity.SysMenu;
import com.rayootech.project.sys.service.ISysMenuService;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 Controller类
 * 
 * @date 2015年3月27日 上午10:13:42
 * @author yongweif
 * @since [project/controller v1.0]
 */
@Controller
@RequestMapping("sys/sysMenu")
public class SysMenuController {

	@Autowired
	private ISysMenuService sysMenuService;

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 查询所有菜单
	 * 
	 * @date 2015年3月28日 下午2:04:26
	 * @author yongweif
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "sysMenuList")
	public String sysMenuList(ModelMap modelMap) {
		modelMap.put("treeData", JSON.toJSONString(sysMenuService.getAllMenu()));
		return "sys/sysMenu";
	}

	/**
	 * 列表(json数据)
	 * 
	 * @param request
	 * @param pageData
	 * @return
	 */
	@RequestMapping(value = "listMenu")
	@ResponseBody
	public String listMenu() {
		return JSON.toJSONStringWithDateFormat(sysMenuService.listMenu(0), "yyyy-MM-dd HH:mm:ss",
				SerializerFeature.WriteDateUseDateFormat);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳转到添加页面
	 * 
	 * @date 2015年3月28日 下午2:06:14
	 * @author yongweif
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("toAddSysMenu")
	public String toAddSysMenu(ModelMap modelMap) {
		modelMap.put("oneMenu", sysMenuService.getOneMenu());
		return "sys/sysMenu-add";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 保存菜单
	 * 
	 * @date 2015年3月28日 下午2:06:24
	 * @author yongweif
	 * @param sysMenu
	 * @return
	 */
	@RequestMapping(value = "saveSysMenu")
	@ResponseBody
	public String saveSysMenu(SysMenu sysMenu) {
		return sysMenuService.saveSysMenu(sysMenu);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 跳转到修改页面
	 * 
	 * @date 2015年3月28日 下午2:06:44
	 * @author yongweif
	 * @param id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("toUpdateSysMenu")
	public String toUpdateSysMenu(Integer id, ModelMap modelMap) {
		modelMap.put("sysMenu", JSON.toJSONString(sysMenuService.getById(id)));
		modelMap.put("oneMenu", sysMenuService.getOneMenu());
		return "sys/sysMenu-update";
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 修改菜单
	 * 
	 * @date 2015年3月28日 下午2:07:12
	 * @author yongweif
	 * @param sysMenu
	 * @return
	 */
	@RequestMapping(value = "updateSysMenu")
	@ResponseBody
	public String updateSysMenu(SysMenu sysMenu) {
		return sysMenuService.updateSysMenu(sysMenu);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除菜单
	 * 
	 * @date 2015年3月28日 下午2:07:24
	 * @author yongweif
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteSysMenu")
	@ResponseBody
	public String deleteSysMenu(Integer id) {
		return sysMenuService.deleteSysMenu(id);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 移动菜单顺序
	 * 
	 * @date 2015年3月28日 下午2:07:33
	 * @author yongweif
	 * @param menuId
	 * @param moveId
	 * @param orderNum1
	 * @param orderNum2
	 * @return
	 */
	@RequestMapping(value = "menuMove", produces = { "text/text;charset=UTF-8" })
	@ResponseBody
	public String menuMove(int menuId, int moveId, Integer orderNum1, Integer orderNum2) {
		return sysMenuService.updateMenuOrderNum(menuId, moveId, orderNum1, orderNum2);
	}
}