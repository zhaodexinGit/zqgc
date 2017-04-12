package com.rayootech.project.sys.dao;

import java.util.List;
import java.util.Map;

import com.rayootech.project.sys.entity.NlbCompanyNews;
import com.rayootech.project.utils.PageJson;
import com.rayootech.project.utils.orm.Page;

public interface NlbCompanyNewsDao {
	
	/**
	 * 
	 * <B>功能简述</B><br>
	 * 通过id删除一条数据
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param id
	 * @return
	 */
    int deleteById(Integer id);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 插入一条数据
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    int insert(NlbCompanyNews record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 插入一条数据
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    int insertSelective(NlbCompanyNews record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id查询对应的实体对象
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    NlbCompanyNews findById(Integer id);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改除大文本对应的实体对象
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    int updateByPrimaryKeySelective(NlbCompanyNews record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改对应的实体对象的大文本属性
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    int updateByPrimaryKeyWithBLOBs(NlbCompanyNews record);

    /**
	 * 
	 * <B>功能简述</B><br>
	 * 根据id修改对应的整个实体对象
	 * 
	 * @date 2016年8月19日 上午10:26:46
	 * @author caolei
	 * @param NlbCompanyNews
	 * @return
	 */
    int update(NlbCompanyNews record);
    
    /**
	 * 
	 * <B>功能简述</B><br>
	 * 获取公司动态列表
	 * 
	 * @author caolei
	 * @param page
	 * @param params
	 * @return
	 */
	String getDynamicList(PageJson<NlbCompanyNews> page, Map<String, Object> params);
    
    /**
	 * 
	 * <B>功能简述</B><br>
	 * 获取公司动态列表
	 * 
	 * @author caolei
	 * @param pageData
	 * @param params
	 * @return
	 */
	List<NlbCompanyNews> dynamicList(Page<NlbCompanyNews> pageData, Map<String, Object> params);
	
}