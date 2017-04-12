package com.rayootech.project.utils;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * <B>功能简述</B><br>
 * JSON串格式化工具
 * 
 * @date 2015年3月25日 上午11:08:46
 * @author XuSheng
 * @since [project/基础工具v1.0]
 */
public class JsonUtils {

	private static final String JSON_MSG = "{\"code\":\"%d\",\"data\":%s}";

	/**
	 * 
	 * <B>功能简述</B><br>
	 * json文本串
	 * 
	 * @date 2015年3月25日 上午10:32:28
	 * @author XuSheng
	 * @param code
	 *            返回码
	 * @param msg
	 *            返回信息
	 * @return
	 */
	public static String makeJsonText(final int code, final String msg) {
		String jsonMsg = "{\"code\":\"%d\",\"data\":\"%s\"}";
		return String.format(jsonMsg, code, msg);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体串List
	 * 
	 * @date 2015年3月25日 上午10:34:20
	 * @author XuSheng
	 * @param list
	 *            集合/数组
	 * @return
	 */
	public static String makeJsonForList(final List<?> list) {
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(list));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体串List 时间格式化
	 * 
	 * @date 2015年3月25日 上午11:27:33
	 * @author XuSheng
	 * @param list
	 *            集合/数组
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String makeJsonForList(final List<?> list, final String format) {
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONStringWithDateFormat(list, format));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体List，选择性传入需要用的字段
	 * 
	 * @date 2015年3月28日 下午5:25:21
	 * @author XuSheng
	 * @param list
	 *            集合/数组
	 * @param strs
	 *            需要用到的字段String数组
	 * @return
	 */
	public static String makeJsonForListFilter(final List<?> list, final String... strs) {
		final SimplePropertyPreFilter filter = new SimplePropertyPreFilter(strs);
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(list, filter));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体串
	 * 
	 * @date 2015年3月25日 上午11:35:06
	 * @author XuSheng
	 * @param obj
	 *            实体
	 * @return
	 */
	public static String makeJsonForObject(final Object obj) {
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(obj));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体串 时间格式
	 * 
	 * @date 2015年3月25日 上午11:37:06
	 * @author XuSheng
	 * @param obj
	 *            实体
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String makeJsonForObject(final Object obj, final String format) {
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONStringWithDateFormat(obj, format));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON实体串,选择性传入需要用的字段
	 * 
	 * @date 2015年3月28日 下午5:28:34
	 * @author XuSheng
	 * @param obj
	 *            实体
	 * @param strs
	 *            需要用到的字段String数组
	 * @return
	 */
	public static String makeJsonForObjectFilter(final Object obj, final String... strs) {
		final SimplePropertyPreFilter filter = new SimplePropertyPreFilter(strs);
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(obj, filter));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON 分页串
	 * 
	 * @date 2015年3月25日 上午11:49:35
	 * @author XuSheng
	 * @param list
	 *            集合
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            当前页大小
	 * @param sortTarget
	 *            0服务端排序\1客户端排序
	 * @return
	 */
	public static String makeJsonForPage(final List<?> list, final int pageNo, final int pageSize, final int sortTarget) {
		JsonPageUtils page = new JsonPageUtils();
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setSortTarget(sortTarget);
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(page));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON 分页串 时间格式
	 * 
	 * @date 2015年3月25日 下午12:01:33
	 * @author XuSheng
	 * @param list
	 *            集合
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            当前页大小
	 * @param sortTarget
	 *            0服务端排序\1客户端排序
	 * @param format
	 *            时间格式
	 * @return
	 */
	public static String makeJsonForPage(final List<?> list, final int pageNo, final int pageSize,
			final int sortTarget, final String format) {
		JsonPageUtils page = new JsonPageUtils();
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setSortTarget(sortTarget);
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONStringWithDateFormat(page, format));
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * JSON 分页串 ,选择性传入需要用的字段
	 * 
	 * @date 2015年3月28日 下午5:30:21
	 * @author XuSheng
	 * @param list
	 *            集合
	 * @param pageNo
	 *            当前页
	 * @param pageSize
	 *            当前页大小
	 * @param sortTarget
	 *            0服务端排序\1客户端排序
	 * @param strs
	 *            需要用到的字段String数组
	 * @return
	 */
	public static String makeJsonForPageFilter(final List<?> list, final int pageNo, final int pageSize,
			final int sortTarget, String... strs) {
		JsonPageUtils page = new JsonPageUtils();
		page.setList(list);
		page.setPageNo(pageNo);
		page.setPageSize(pageSize);
		page.setSortTarget(sortTarget);
		String[] filters = new String[strs.length + 4];
		for (int i = 0; i < strs.length; i++) {
			filters[i] = strs[i];
		}
		filters[strs.length] = "pageNo";
		filters[strs.length + 1] = "pageSize";
		filters[strs.length + 2] = "sortTarget";
		filters[strs.length + 3] = "list";
		final SimplePropertyPreFilter filter = new SimplePropertyPreFilter(filters);
		return String.format(JSON_MSG, Constant.RESULT_CODE_SUCCESS, JSON.toJSONString(page, filter));
	}

}
