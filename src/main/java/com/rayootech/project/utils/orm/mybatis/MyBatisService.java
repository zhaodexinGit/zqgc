package com.rayootech.project.utils.orm.mybatis;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.rayootech.project.utils.orm.Page;

@Transactional
public class MyBatisService<T, PK extends Serializable> implements
		Serializable {

	private static final long serialVersionUID = -5436679052320291288L;

	@Autowired(required = true)
	private MyBatisDao<T, PK>	myBatisDao;

	public MyBatisDao<T, PK> getMyBatisDao() {
		return myBatisDao;
	}


	/**
	 * 分页查询
	 * 
	 * @param params
	 * @return
	 */
	@Transactional(readOnly = true)
	public Page<T> findPage(Page<T> page, Map<String, Object> params) {
		return getMyBatisDao().findPage(page, params);
	}

	/**
	 * 列表查询
	 * 
	 * @param params
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<T> find(Map<String, Object> params) {
		return getMyBatisDao().find(params);
	}

	@Transactional(readOnly = true)
	public List<T> find() {
		return getMyBatisDao().find();
	}

	/**
	 * 分页数量查询
	 * 
	 * @param params
	 * @return
	 */
	@Transactional(readOnly = true)
	public int count(Map<String, Object> params) {
		return getMyBatisDao().count(params);
	}

	@Transactional(readOnly = true)
	public int count() {
		return getMyBatisDao().count();
	}

	/**
	 * 得到某一条
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public T get(Integer id) {
		return getMyBatisDao().get(id);
	}

	/**
	 * 新增
	 * 
	 * @param t
	 */
	public int insert(T t) {
		return getMyBatisDao().insert(t);
	}

	/**
	 * 更新
	 * 
	 * @param t
	 * @return
	 */
	public int update(T t) {
		return getMyBatisDao().update(t);
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	public int delete(Integer id) {
		return getMyBatisDao().delete(id);
	}


	public int delete(String id) {
		// TODO Auto-generated method stub
		return getMyBatisDao().delete(id);
	}

}
