package com.rayootech.project.utils.aes;

import java.nio.charset.Charset;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <B>功能简述</B><br>
 * AES加密解密工具
 * 
 * @date 2015年3月31日 上午10:28:32
 * @author XuSheng
 * @since [project/AES加密工具 v.10]
 */
public class MsgCryptUtils {

	private static final Charset CHARSET = Charset.forName("UTF-8");
	private static final Logger log = LoggerFactory.getLogger(MsgCryptUtils.class);
	private Base64 base64 = new Base64();
	private byte[] aesKey;
	private String token;

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 功能详细描述
	 * 
	 *
	 * @date 2015年3月31日下午2:12:08
	 * @author XuSheng
	 * @param encodingAesKey
	 *            加密参数
	 * @param token
	 *            私钥
	 */
	public MsgCryptUtils(String encodingAesKey, String token) {
		this.token = token;
		this.aesKey = Base64.decodeBase64(encodingAesKey + "=");
	}

	// 生成4个字节的网络字节序
	byte[] getNetworkBytesOrder(int sourceNumber) {
		byte[] orderBytes = new byte[4];
		orderBytes[3] = (byte) (sourceNumber & 0xFF);
		orderBytes[2] = (byte) (sourceNumber >> 8 & 0xFF);
		orderBytes[1] = (byte) (sourceNumber >> 16 & 0xFF);
		orderBytes[0] = (byte) (sourceNumber >> 24 & 0xFF);
		return orderBytes;
	}

	// 还原4个字节的网络字节序
	int recoverNetworkBytesOrder(byte[] orderBytes) {
		int sourceNumber = 0;
		for (int i = 0; i < 4; i++) {
			sourceNumber <<= 8;
			sourceNumber |= orderBytes[i] & 0xff;
		}
		return sourceNumber;
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 对明文进行加密
	 * 
	 * @date 2015年3月31日 下午2:16:12
	 * @author XuSheng
	 * @param randomStr
	 *            随机字符串
	 * @param text
	 *            需要加密的明文
	 * @return 加密后base64编码的字符串
	 */
	public String encrypt(String randomStr, String text) {
		ByteGroup byteCollector = new ByteGroup();
		byte[] randomStrBytes = randomStr.getBytes(CHARSET);
		byte[] textBytes = text.getBytes(CHARSET);
		byte[] networkBytesOrder = getNetworkBytesOrder(textBytes.length);
		byte[] appidBytes = token.getBytes(CHARSET);
		byteCollector.addBytes(randomStrBytes);
		byteCollector.addBytes(networkBytesOrder);
		byteCollector.addBytes(textBytes);
		byteCollector.addBytes(appidBytes);
		byte[] padBytes = PKCS7Encoder.encode(byteCollector.size());
		byteCollector.addBytes(padBytes);
		byte[] unencrypted = byteCollector.toBytes();

		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keySpec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(aesKey, 0, 16);
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);
			byte[] encrypted = cipher.doFinal(unencrypted);
			return base64.encodeToString(encrypted);
		} catch (Exception e) {
			log.error("the plaintext encryption method is error : ", e);
			return null;
		}
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 对密文进行解密.
	 * 
	 * @date 2015年3月31日 下午2:20:36
	 * @author XuSheng
	 * @param text
	 *            密文
	 * @return 解密得到的明文
	 */
	public String decrypt(String text) {
		String content = null;
		try {
			byte[] original = null;
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec key_spec = new SecretKeySpec(aesKey, "AES");
			IvParameterSpec iv = new IvParameterSpec(Arrays.copyOfRange(aesKey, 0, 16));
			cipher.init(Cipher.DECRYPT_MODE, key_spec, iv);
			byte[] encrypted = Base64.decodeBase64(text);
			original = cipher.doFinal(encrypted);
			byte[] bytes = PKCS7Encoder.decode(original);
			byte[] networkOrder = Arrays.copyOfRange(bytes, 16, 20);
			int xmlLength = recoverNetworkBytesOrder(networkOrder);
			content = new String(Arrays.copyOfRange(bytes, 20, 20 + xmlLength), CHARSET);
		} catch (Exception e) {
			log.error("the decrypted to recover iserror : ", e);
		}
		return content;
	}

}
