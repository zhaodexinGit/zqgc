package com.rayootech.project.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <B>功能简述</B><br>
 * 调用http接口工具
 * 
 * @date 2015年4月6日 上午10:39:09
 * @author XuSheng
 * @since [project/基础工具v1.0]
 */
public class HttpRequest {

	private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 向指定URL发送GET方法的请求
	 * 
	 * @date 2015年4月6日 上午10:49:32
	 * @author XuSheng
	 * @param url
	 *            发送请求的URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			URLConnection connection = realUrl.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.connect();
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("http request send get is error : ", e);
		} finally {
			try {
				if (null != in) {
					in.close();
				}
			} catch (Exception ex) {
				log.error("http request send get close is error : ", ex);
			}
		}
		return result;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @date 2015年4月6日 上午10:51:10
	 * @author XuSheng
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return URL 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			out = new PrintWriter(conn.getOutputStream());
			out.print(param);
			out.flush();
			in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			log.error("http request send post is error : ", e);
		} finally {
			try {
				if (null != out) {
					out.close();
				}
				if (null != in) {
					in.close();
				}
			} catch (IOException ex) {
				log.error("http request send post close is error : ", ex);
			}
		}
		return result;
	}
}
