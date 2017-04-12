package com.rayootech.project.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rayootech.project.sys.dao.ISysUserMenuDao;
import com.rayootech.project.sys.entity.SysMenu;
import com.rayootech.project.sys.entity.SysUserMenu;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

/**
 * 
 * <B>功能简述</B><br>
 * 用户菜单 dao接口实现
 * 
 * @date 2015年3月27日 上午10:38:12
 * @author yongweif
 * @since [project/dao v1.0]
 */
@Component
public class SysUserMenuDaoImpl extends MyBatisDao<SysUserMenu, Integer> implements ISysUserMenuDao {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;

	public List<SysMenu> getMenuList(Integer userId) {
		return getSqlSession().selectList("SysMenu.getMenuList",userId);
	}

	public int delBatchPowerMenu(String[] userIds) {
		return getSqlSession().delete(getMapperMethod("delBatchPowerMenu"),userIds);
	}

}