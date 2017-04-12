package com.rayootech.project.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayootech.project.sys.dao.NlbCompanyProfileDao;
import com.rayootech.project.sys.entity.NlbCompanyProfile;
import com.rayootech.project.sys.service.NlbCompanyProfileService;
import com.rayootech.project.sys.service.ShiroDbRealm.ShiroUser;
import com.rayootech.project.utils.Utils;
import com.rayootech.project.utils.orm.Page;
import com.rayootech.project.utils.orm.mybatis.MyBatisService;

/***
 * 诺兰帮密码业务实现类
 * 
 * 基本的增删查该功能可以直接使用父类方法进行调用，也可以使用DAO层自定义实现
// "get"; 获取指定记录
// "find"; 查找
// "count"; 计数
// "insert"; 插入
// "update"; 修改
// "delete"; 删除
// "findPage" 分页查询
 * @author hkz
 *
 */
@Service
public class NlbCompanyProfileServiceImpl extends
		MyBatisService<NlbCompanyProfile, Integer> implements
		NlbCompanyProfileService {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(NlbCompanyProfileServiceImpl.class);
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;

	@Autowired
	private NlbCompanyProfileDao nlbCompanyProfileDao;

	public String saveNlbmm(NlbCompanyProfile nlbmm) {
		try {
			// 获取当前登录用户
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject()
					.getPrincipal();

			if (user == null) {
				throw new Exception("用户未登录");
			} else {
				// 关联创建人、创建时间
				nlbmm.setCreate_user_id(user.getId());
				nlbmm.setCreate_time(Utils.getCurrentDatetime());
			}
			
			// 调用父类方法，此方式调用必须在改实体对象相应的mapper.xml中配置相关方法，
			// 支持的方法有
			// "get";
			// "find";
			// "count";
			// "insert";
			// "update";
			// "delete";
			if (super.insert(nlbmm) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("insert nlbCompanyProfile is error : ", e);
		}
		return "error";

	}

	public String updateNlbmm(NlbCompanyProfile nlbmm) {
		try {
			// 获取当前用户
			ShiroUser user = (ShiroUser) SecurityUtils.getSubject()
					.getPrincipal();

			if (user == null) {
				throw new Exception("用户未登录");
			} else {
				// 创建人、创建时间
				nlbmm.setUpdate_user_id(user.getId());
				nlbmm.setUpdate_time(Utils.getCurrentDatetime());
			}
			if (super.update(nlbmm) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("update nlbCompanyProfile is error : ", e);
		}
		return "error";
	}

	public String deleteNlbmm(Integer id) {
		try {
			// 调用父类方法，此方式调用必须在改实体对象相应的mapper.xml中配置相关方法，
			// 支持的方法有
			// "get";
			// "find";
			// "count";
			// "insert";
			// "update";
			// "delete";
			if (super.delete(id) != 0) {
				return "success";
			}
		} catch (Exception e) {
			log.error("delete nlbCompanyProfile is error : ", e);
		}
		return "error";
	}

	public Page<NlbCompanyProfile> nlbmmList(Page<NlbCompanyProfile> pageData,
			Map<String, Object> params) {
		//以分页方式获取列表数据
		// "get";
		// "find";
		// "count";
		// "insert";
		// "update";
		// "delete";
		return super.findPage(pageData, params);
	}

	public NlbCompanyProfile getById(Integer id) {
		
		//返回制定ID的记录
		return nlbCompanyProfileDao.findById(id);
	}

}