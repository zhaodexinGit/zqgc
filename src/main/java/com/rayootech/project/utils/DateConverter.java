package com.rayootech.project.utils;

import java.text.SimpleDateFormat;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;
/**
 * 
 * <B>功能简述</B><br>
 * 使用WebBindingInitializer 对数据类型转换
 * 
 * @date  2015年3月30日 上午11:50:27
 * @author    yongweif
 * @since     [project/v1.0]
 */
public class DateConverter implements WebBindingInitializer {

	public void initBinder(WebDataBinder binder, WebRequest request) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//dateFormat.setLenient(false);

		SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		datetimeFormat.setLenient(false);

		//binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
		binder.registerCustomEditor(java.util.Date.class, new CustomTimestampEditor(datetimeFormat, true));
	}
}