package com.rayootech.project.sys.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.ISysUserMenuDao;
import com.rayootech.project.sys.entity.SysMenu;
import com.rayootech.project.sys.entity.SysUserMenu;
import com.rayootech.project.sys.service.ISysUserMenuService;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 service接口实现
 * 
 * @date 2015年3月27日 上午10:41:50
 * @author yongweif
 * @since [project/service v1.0]
 */
@Service
public class SysUserMenuServiceImpl extends MyBatisService<SysUserMenu, Integer> implements ISysUserMenuService {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * logBack日志
	 */
	private static final Logger log = LoggerFactory.getLogger(SysUserMenuServiceImpl.class);

	@Autowired
	private ISysUserMenuDao sysUserMenuDao;

	public String deleteSysUserMenu(Integer id) {
		try {
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete sysUserMenu is error : ", e);
		}
		return "error";
	}

	public List<Object> getUserMenu(Integer userId) {
		List<SysMenu> MenuList = sysUserMenuDao.getMenuList(userId);
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
						if (o.getChecked() != null && !"".equals(o.getChecked())) {
							tmp.put("checked", true);
						}
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
				if (i.getChecked() != null && !"".equals(i.getChecked())) {
					menus.put("checked", true);
				}
				menus.put("childOuter", false);// 禁止子节点移走
				menus.put("dropRoot", false);// 不要成为根节点
				menus.put("children", list);
				allList.add(menus);
			}
		}
		return allList;
	}

	public String powerUserMemu(String userIds, String menuIds) {
		try {
			sysUserMenuDao.delBatchPowerMenu(userIds.split(","));
			if (!"".equals(menuIds)) {
				String[] userArray = userIds.split(",");
				String[] menuArray = menuIds.split(",");
				// ShiroUser user = (ShiroUser)
				// SecurityUtils.getSubject().getPrincipal();
				for (int i = 0; i < userArray.length; i++) {
					for (int j = 0; j < menuArray.length; j++) {
						SysUserMenu um = new SysUserMenu();
						um.setUserId(Integer.parseInt(userArray[i]));
						um.setMenuId(Integer.parseInt(menuArray[j]));
						super.insert(um);
					}
				}
			}
			return "success";
		} catch (Exception e) {
			log.error("power user menu is error : ", e);
		}
		return "error";
	}
}