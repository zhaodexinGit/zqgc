package com.rayootech.project.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

public final class Utils {
	/**
	 * 
	 * <B>获得当前时间</B><br>
	 * 使用joda-time获取当前时间Timestamp
	 * 
	 * @date 2015年3月24日 下午2:48:54
	 * @author yongweif
	 * @return
	 */
	public static Timestamp getCurrentDatetime() {
		DateTime dateTime = new DateTime(); // 使用joda-time
		return new Timestamp(dateTime.getMillis());
	}

	/**
	 * 
	 * <B>获取登录IP</B><br>
	 * 获取用户登录的IP
	 * 
	 * @date 2015年3月24日 下午3:02:57
	 * @author yongweif
	 * @param request
	 * @return
	 */
	public static String getClientIp(HttpServletRequest request) {

		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 功能详细描述
	 * 
	 * @date 2015年3月24日 下午7:53:44
	 * @author yongweif
	 * @param request
	 * @return
	 */
	public static Map<String, Object> reqParamToGenericMap(HttpServletRequest request) {
		Map<String, Object> newMap = new HashMap<String, Object>();
		Enumeration<?> names = request.getParameterNames();
		while (names.hasMoreElements()) {
			final String name = (String) names.nextElement();
			newMap.put(name, getArraySubset(request.getParameterValues(name)));
		}
		return newMap;
	}

	private static String getArraySubset(String[] array) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]).append(",");
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		return sb.toString();
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 随机生成字符串sum 位字符串
	 * 
	 * @date 2015年3月26日 下午4:35:11
	 * @author XuSheng
	 * @param sum
	 *            任意数字
	 * @return
	 */
	public static String getRandomStr(final int sum) {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < sum; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取文件后缀名
	 * 
	 * @date 2015年4月8日 上午11:34:13
	 * @author yongweif
	 * @param fileName
	 * @return
	 */
	public static String getExtention(String fileName) {
		String fname = "";
		try {
			int pos = fileName.lastIndexOf(".");
			fname = fileName.substring(pos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fname;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 将文件保存到本地
	 * 
	 * @date 2015年4月8日 上午11:39:04
	 * @author yongweif
	 * @param file
	 * @param path
	 * @return
	 */
	public static String copy(MultipartFile file, String path) {
		String fileName = "";
		if (!file.isEmpty()) {
			fileName = System.nanoTime() + RandomStringUtils.randomAlphanumeric(4)
					+ getExtention(file.getOriginalFilename());
			byte[] bytes;
			try {
				bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream(path + fileName);
				fos.write(bytes);
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
				return "";
			}
		}
		return fileName;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获得日期是周几了
	 * 
	 * @date 2015年4月13日 下午12:01:37
	 * @author yongweif
	 * @param time
	 * @return
	 */
	public static String getWeek(Timestamp time) {
		DateTime dt = new DateTime(time);
		switch (dt.getDayOfWeek()) {
		case 1:
			return "周一";
		case 2:
			return "周二";
		case 3:
			return "周三";
		case 4:
			return "周四";
		case 5:
			return "周五";
		case 6:
			return "周六";
		default:
			return "周日";
		}
	}
}
