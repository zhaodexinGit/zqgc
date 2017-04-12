package com.rayootech.project.utils;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.PropertyResourceBundle;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * <B>功能简述</B><br>
 * 加密工具
 * 
 * @date 2015年3月26日 下午3:10:04
 * @author XuSheng
 * @since [project/加密基础类v1.0]
 */
public class SignUtil {

	/**
	 * 
	 * <B>功能简述</B><br>
	 * SHA1加密方法
	 * 
	 * @date 2015年3月26日 下午4:10:08
	 * @author XuSheng
	 * @param key
	 *            公钥
	 * @param param
	 *            私钥
	 * @param timestamp
	 *            时间戳
	 * @param nonce
	 *            随机数
	 * @param encrypt
	 *            随机字符串
	 * @return 加密串
	 */
	public static String getSHA1(String key, String param, String timestamp, String nonce, String encrypt) {
		try {
			String[] array = new String[] { key, param, timestamp, nonce, encrypt };
			StringBuffer sb = new StringBuffer();
			// 字符串排序
			Arrays.sort(array);
			for (int i = 0; i < array.length; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获取配置文件key参数
	 * 
	 * @date 2015年3月27日 上午10:18:56
	 * @author XuSheng
	 * @param fileName
	 *            配置文件名
	 * @param key
	 *            配置文件中的键
	 * @return
	 */
	public static String getValueByKey(final String fileName, final String key) {
		final PropertyResourceBundle pb = (PropertyResourceBundle) PropertyResourceBundle.getBundle(fileName);
		return pb.getString(key);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 凭证MD5校验
	 * 
	 * @date 2015年3月27日 上午10:31:08
	 * @author XuSheng
	 * @param fileName
	 *            配置文件名
	 * @param key
	 *            配置文件中的键
	 * @param params
	 *            加密参数
	 * @param signature
	 *            凭证
	 * @return true 校验成功 /false 校验失败
	 */
	public static boolean checkSignCode(final String fileName, final String key, final String params,
			final String signature) {

		final String value = getValueByKey(fileName, key);
		if ((signature).equals(DigestUtils.md5Hex(DigestUtils.md5Hex(params).concat(value)))) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 凭证SHA1校验
	 * 
	 * @date 2015年3月27日 下午2:58:33
	 * @author XuSheng
	 * @param fileName
	 *            配置文件名
	 * @param key
	 *            配置文件中的键
	 * @param params
	 *            加密参数
	 * @param signature
	 *            凭证
	 * @param timeStamp
	 *            时间戳
	 * @param nonce
	 *            随机数字
	 * @param encrypt
	 *            随机字符串
	 * @return
	 */
	public static boolean checkSignCode(final String fileName, final String key, final String params,
			final String signature, final String timeStamp, final String nonce, final String encrypt) {
		final String value = getValueByKey(fileName, key);
		String sha1 = getSHA1(value, params, timeStamp, nonce, encrypt);
		if (signature.equals(sha1)) {
			return true;
		}
		return false;
	}

}
