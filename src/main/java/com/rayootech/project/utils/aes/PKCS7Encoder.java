/**
 * 对公众平台发送给公众账号的消息加解密示例代码.
 * 
 * @copyright Copyright (c) 1998-2014 Tencent Inc.
 */

// ------------------------------------------------------------------------

package com.rayootech.project.utils.aes;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 
 * <B>功能简述</B><br>
 * 提供基于PKCS7算法的加解密接口工具.
 * 
 * @date 2015年3月31日 下午2:24:39
 * @author XuSheng
 * @since [project/PKCS7算法 v1.0]
 */
class PKCS7Encoder {
	static Charset CHARSET = Charset.forName("utf-8");
	static int BLOCK_SIZE = 32;

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 获得对明文进行补位填充的字节.
	 * 
	 * @date 2015年3月31日 下午2:25:08
	 * @author XuSheng
	 * @param count
	 *            需要进行填充补位操作的明文字节个数
	 * @return 补齐用的字节数组
	 */
	static byte[] encode(int count) {
		int amountToPad = BLOCK_SIZE - (count % BLOCK_SIZE);
		if (amountToPad == 0) {
			amountToPad = BLOCK_SIZE;
		}
		char padChr = chr(amountToPad);
		String tmp = new String();
		for (int index = 0; index < amountToPad; index++) {
			tmp += padChr;
		}
		return tmp.getBytes(CHARSET);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 删除解密后明文的补位字符
	 * 
	 * @date 2015年3月31日 下午2:25:48
	 * @author XuSheng
	 * @param decrypted
	 *            解密后的明文
	 * @return 删除补位字符后的明文
	 */
	static byte[] decode(byte[] decrypted) {
		int pad = (int) decrypted[decrypted.length - 1];
		if (pad < 1 || pad > 32) {
			pad = 0;
		}
		return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 将数字转化成ASCII码对应的字符，用于对明文进行补码
	 * 
	 * @date 2015年3月31日 下午2:26:09
	 * @author XuSheng
	 * @param amountToPad
	 *            需要转化的数字
	 * @return 转化得到的字符
	 */
	static char chr(int amountToPad) {
		byte target = (byte) (amountToPad & 0xFF);
		return (char) target;
	}

}
