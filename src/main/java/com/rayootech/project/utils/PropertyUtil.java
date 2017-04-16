package com.rayootech.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 属性文件（properties）加载类
 * <p>
 * Deprecated, use {@link PropertyUtils}
 * 
 * @author waf
 */
@Deprecated
public abstract class PropertyUtil {

	private static final Log log = LogFactory.getLog(PropertyUtil.class);

	/**
	 * Root配置文件固定名称
	 */
	private static final String ROOT_PROPERTY_FILE = "config.properties";

//	/**
//	 * Root配置文件中配置子配置文件的关键字前缀
//	 */
//	private static final String PROPERTY_FILE_PREFIX = "property.file.";

	/**
	 * 外联配置文件的前缀
	 */
	private static final String VALUE_FILE_PREFIX = "file://";

	/**
	 * ClassPath的物理地址
	 */
	private static String classLocation = "";

	/**
	 * 配置存储对象
	 */
	private static Properties props = new Properties();

	/**
	 * 配置文件名缓存
	 */
	private static Set<String> files = new HashSet<String>();

	/**
	 * 初始化配置内容
	 */
	static {

		// 取得ClassPath的物理地址
		classLocation = getClassLocation();

		// 加载Root配置文件
		load(ROOT_PROPERTY_FILE);

//		// 加载子配置文件
//		if (props != null) {
//
//			for (int i = 1;; i++) {
//
//				// 加载Root配置文件中配置的各子配置
//				String path = getProperty(PROPERTY_FILE_PREFIX + i);
//
//				if (path == null) {
//					// 如果没有加载到子配置文件，就退出整个加载流程
//					break;
//				}
//
//				// 按照指定的文件名加载配置文件
//				addPropertyFile(path);
//			}
//		}

		// 加载配置文件中以("file://")开头的外联文件
		loadValuePropertyFile();

		// 检查并重新加载属性值
		overrideProperties();
	}

	/**
	 * 加载配置文件内容
	 *
	 * @param name
	 *            配置文件文件名
	 */
	private static void load(String name) {

		InputStream is = null;

		try {

			try {

				log.debug("载入配置文件: " + name);

				is = new FileInputStream(new File(classLocation, name));

				props.load(is);

				files.add(name);

			} catch (NullPointerException e) {
				log.error("!!! 错误: 无法加载 " + name + " !!!");
			} catch (IOException e) {
				log.error("!!! 错误: 无法加载 " + name + " !!!");
			}

		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}

	/**
	 * 加载properties文件中的外联文件
	 */
	private static void loadValuePropertyFile() {

		Collection<Object> values = props.values();
		Iterator<Object> it = values.iterator();

		List<String> valueFileList = new ArrayList<String>();

		// 收集所有以"file://"开头的外联配置文件
		while (it.hasNext()) {

			String strValue = (String) it.next();

			if (strValue != null && (strValue.startsWith(VALUE_FILE_PREFIX))) {
				// 如果值是以"file://"开头的值，说明是外联文件
				// 缓存起来，在下面的处理中统一进行加载

				valueFileList.add(strValue.substring(strValue.indexOf(VALUE_FILE_PREFIX) + VALUE_FILE_PREFIX.length()));
			}
		}

		// 加载外联文件
		for (String value : valueFileList) {
			load(value);
		}
	}

	/**
	 * 检查并重新加载属性值。 如果设置的文件中的键与系统键一致， 为了安全， 将会强制使用系统值
	 */
	private static void overrideProperties() {

		Enumeration<?> enume = props.propertyNames();

		while (enume.hasMoreElements()) {

			String name = (String) enume.nextElement();
			String value = System.getProperty(name);

			if (value != null) {
				props.setProperty(name, value);
			}
		}
	}

	/**
	 * 按照指定的文件名加载配置文件
	 * 
	 * @param name
	 *            配置文件文件名
	 */
	public static void addPropertyFile(String name) {

		if (!name.endsWith(".properties")) {
			name = name + ".properties";
		}

		if (!files.contains(name)) {
			load(name);
		}
	}

	/**
	 * 从配置文件中取得配置的值
	 * 
	 * @param key
	 *            键
	 * @return 值。如果没有对应的配置键，返回null。
	 */
	public static String getProperty(String key) {

		String result = props.getProperty(key);

		if (result != null) {
			if (result.startsWith("@")) {
				// 如果值以@开头，说明该值引用了键是@之后的文字的配置的值

				result = getProperty(result.substring(1));

			} else {
				// 如果是以"${}"包围的值，也对被包围的键进行再取值
				int paraIndex = result.indexOf("${");

				// 可对一行中多个以"${}"包围的值进行解析
				while (paraIndex >= 0) {

					String temp = getProperty(result.substring(paraIndex + 2, result.indexOf("}")));

					if (temp != null) {
						result = result.replaceFirst("\\$\\{(.*?)\\}", temp);
					}

					paraIndex = result.indexOf("${");
				}
			}
		}

		return result;
	}

	/**
	 * 以列表的形式返回指定键的值（值默认是以","为分割符）
	 * 
	 * @param key
	 *            键
	 * @return 值的列表
	 */
	public static List<String> getPropertyAsList(String key) {
		return getPropertyAsList(key, ",");
	}

	/**
	 * 以列表的形式返回指定键的值
	 * 
	 * @param key
	 *            键
	 * @param split
	 *            分隔符
	 * @return 值的列表
	 */
	public static List<String> getPropertyAsList(String key, String split) {

		String property = getProperty(key);

		if (property == null || property.length() <= 0) {
			return new ArrayList<String>();
		}

		String[] propertyArray = property.split(split);

		return Arrays.asList(propertyArray);
	}

	/**
	 * 取得指定键的值，如果没有指定，则以默认值代替
	 * 
	 * @param key
	 *            键
	 * @param defaultValue
	 *            默认值
	 * @return 值
	 */
	public static String getProperty(String key, String defaultValue) {

		String result = props.getProperty(key, defaultValue);

		if (result != null) {

			if (result.startsWith("@")) {
				result = getProperty(result.substring(1), defaultValue);
			} else {

				int paraIndex = result.indexOf("${");

				while (paraIndex >= 0) {

					String temp = getProperty(result.substring(paraIndex + 2, result.indexOf("}")));

					if (temp != null) {
						result = result.replaceFirst("\\$\\{(.*?)\\}", temp);
					}

					paraIndex = result.indexOf("${");
				}
			}
		}

		return result;
	}

	/**
	 * 取得所有配置键
	 * 
	 * @return 所有配置文件的键
	 */
	public static Enumeration<?> getPropertyNames() {
		return props.propertyNames();
	}

	/**
	 * 取得所有指定文字前缀的配置键
	 * 
	 * @param keyPrefix
	 *            文字前缀
	 * @return 所有指定文字前缀的配置键
	 */
	public static Enumeration<?> getPropertyNames(String keyPrefix) {

		Collection<String> matchedNames = new ArrayList<String>();

		Enumeration<?> propNames = props.propertyNames();

		while (propNames.hasMoreElements()) {

			String name = (String) propNames.nextElement();

			if (name.startsWith(keyPrefix)) {
				matchedNames.add(name);
			}
		}

		return Collections.enumeration(matchedNames);
	}

	/**
	 * 设置一个配置
	 * 
	 * @param key
	 *            键
	 * @param value
	 *            值
	 */
	public static void setProperty(String key, String value) {
		props.setProperty(key, value);
	}

	/**
	 * 取得ClassPath的物理地址
	 * 
	 * @return ClassPath的物理地址
	 */
	private static String getClassLocation() {
		String path = "";

		URL url = PropertyUtil.class.getResource("/");

		try {
			URI uri = url.toURI();
			path = uri.getPath();
		} catch (URISyntaxException e) {
			log.warn("!!! 错误: URI转换错误 !!!");
			path = url.getPath();
		}

		return path;
	}
	public static void updatePropertiesValue(String key,long value) throws IOException{
		 FileInputStream inputStream = new FileInputStream(new File(classLocation, ROOT_PROPERTY_FILE));
	      Properties prop = new Properties();
	      // 加载
	      prop.load(inputStream);
	      // 设置
	      prop.setProperty(key, Long.toString(value));
	      // 写到配置文件
	      FileOutputStream outputStream = new FileOutputStream(new File(classLocation, ROOT_PROPERTY_FILE));
	      prop.store(outputStream, "update message");
	      inputStream.close();
	      outputStream.close();
	}
	public static long getPropertiesValue(String key) throws IOException{
		 FileInputStream inputStream = new FileInputStream(new File(classLocation, ROOT_PROPERTY_FILE));
	      Properties prop = new Properties();
	      // 加载
	      prop.load(inputStream);
	      // 设置
	      long value = Long.parseLong( prop.getProperty(key));
	      inputStream.close();
	      return value;
	}
}
