package com.rayootech.project.sys.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rayootech.project.sys.dao.ISysMenuDao;
import com.rayootech.project.sys.entity.SysMenu;
import com.rayootech.project.utils.orm.mybatis.MyBatisDao;

/**
 * 
 * <B>功能简述</B><br>
 * 菜单 dao接口实现sdk 
 * 
 * @date 2015年3月27日 上午10:38:12
 * @author yongweif
 * @since [project/dao v1.0]
 */
@Component
public class SysMenuDaoImpl extends MyBatisDao<SysMenu, Integer> implements ISysMenuDao {
	/**
	 * 字段描述
	 */
	private static final long serialVersionUID = 1L;

	public List<SysMenu> getAllMenu() {
		return getSqlSession().selectList(getMapperMethod("getAllMenu"));
	}

	public List<SysMenu> getOneMenu() {
		return getSqlSession().selectList(getMapperMethod("getOneMenu"));
	}

	public List<SysMenu> getUserMenu(Integer userId) {
		return getSqlSession().selectList(getMapperMethod("getUserMenu"),userId);
	}

	public int getMaxOrderNum() {
		return getSqlSession().selectOne(getMapperMethod("getMaxOrderNum"));
	}

}