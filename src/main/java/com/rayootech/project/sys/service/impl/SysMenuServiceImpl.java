package com.rayootech.project.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;
import com.rayootech.project.sys.dao.ISysMenuDao;
import com.rayootech.project.sys.entity.SysMenu;
import com.rayootech.project.sys.service.ISysMenuService;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 service接口实现
 * 
 * @date 2015年3月27日 上午10:41:50
 * @author yongweif
 * @since [project/service v1.0]
 */
@Service
public class SysMenuServiceImpl extends MyBatisService<SysMenu, Integer> implements ISysMenuService {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * logBack日志
	 */
	private static final Logger log = LoggerFactory.getLogger(SysMenuServiceImpl.class);

	@Autowired
	private ISysMenuDao sysMenuDao;

	public SysMenu getById(Integer id) {
		return super.get(id);
	}

	public String saveSysMenu(SysMenu sysMenu) {
		try {
			if(sysMenu.getParentMenuId()==null){
				sysMenu.setParentMenuId(0);
			}
			sysMenu.setOrderNum(sysMenuDao.getMaxOrderNum() + 1);
			if (super.insert(sysMenu) != 0) {
				return "success";
			}
			return "success";
		} catch (Exception e) {
			log.error("save sysMenu is error : ", e);
		}
		return "error";
	}

	public String updateSysMenu(SysMenu sysMenu) {
		try {
			if (super.update(sysMenu) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update sysMenu is error : ", e);
		}
		return "error";
	}

	public String deleteSysMenu(Integer id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete sysMenu is error : ", e);
		}
		return "error";
	}

	public List<Object> getAllMenu() {
		List<SysMenu> MenuList = sysMenuDao.getAllMenu();
		List<Object> allList = new ArrayList<Object>();
		for (SysMenu i : MenuList) {
			if (i.getParentMenuId() == 0) {
				List<Object> list = new ArrayList<Object>();
				for (SysMenu o : MenuList) {
					if (i.getId().equals(o.getParentMenuId())) {
						Map<String, Object> tmp = new HashMap<String, Object>();
						tmp.put("id", o.getId());
						tmp.put("name", o.getMenuName());
						tmp.put("menuLevel", o.getMenuLevel());
						tmp.put("orderNum", o.getOrderNum());
						// tmp.put("icon",o.getIcon());
						tmp.put("dropInner", false);// 不要成为父节点
						tmp.put("parentid", o.getParentMenuId());
						list.add(tmp);
					}
				}
				Map<String, Object> menus = new HashMap<String, Object>();
				menus.put("id", i.getId());
				menus.put("name", i.getMenuName());
				menus.put("menuLevel", i.getMenuLevel());
				menus.put("orderNum", i.getOrderNum());
				menus.put("childOuter", false);// 禁止子节点移走
				menus.put("dropRoot", false);// 不要成为根节点
				// menus.put("icon",i.getIcon());
				menus.put("children", list);
				allList.add(menus);
			}
		}
		return allList;
	}

	public List<SysMenu> getOneMenu() {
		return sysMenuDao.getOneMenu();
	}

	public String updateMenuOrderNum(int menuId, int moveId, Integer orderNum1, Integer orderNum2) {
		SysMenu m1 = new SysMenu();
		SysMenu m2 = new SysMenu();
		m1.setId(menuId);
		m1.setOrderNum(orderNum2);

		m2.setId(moveId);
		m2.setOrderNum(orderNum1);

		int result = super.update(m1);
		result += super.update(m2);
		if (result >= 2) {
			return "success";
		}
		return "error";
	}

	public List<Object> getUserMenu(int userId) {
		List<SysMenu> menuList = sysMenuDao.getUserMenu(userId);
		List<Object> allList = new ArrayList<Object>();
		for (SysMenu i : menuList) {
			if (i.getParentMenuId() == 0) {
				List<Object> list = new ArrayList<Object>();
				for (SysMenu o : menuList) {
					if (i.getId().equals(o.getParentMenuId())) {
						Map<String, Object> tmp = new HashMap<String, Object>();
						tmp.put("id", o.getId());
						tmp.put("name", o.getMenuName());
						tmp.put("url", o.getMenuUrl());
						list.add(tmp);
					}
				}
				Map<String, Object> menus = new HashMap<String, Object>();
				menus.put("id", i.getId());
				menus.put("name", i.getMenuName());
				menus.put("icon", i.getIconClass());
				menus.put("children", list);
				allList.add(menus);
			}
		}
		return allList;
	}
	
	public List<SysMenu> listMenu(int parentId) {
		Map<String, Object> params = Maps.newHashMap();
		params.put("parentMenuId", parentId);
		List<SysMenu> menuList = super.find(params);
		for (SysMenu m : menuList) {
			m.setText(m.getMenuName());
			m.setChildren(listMenu(m.getId()));
		}
		return menuList;
	}

}