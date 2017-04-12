package com.rayootech.project.utils.aes;

import java.util.ArrayList;

/**
 * 
 * <B>功能简述</B><br>
 * 字节组处理工具
 * 
 * @date 2015年3月31日 下午2:28:32
 * @author XuSheng
 * @since [project/字节组v1.0]
 */
class ByteGroup {

	ArrayList<Byte> byteContainer = new ArrayList<Byte>();

	public byte[] toBytes() {
		byte[] bytes = new byte[byteContainer.size()];
		for (int i = 0; i < byteContainer.size(); i++) {
			bytes[i] = byteContainer.get(i);
		}
		return bytes;
	}

	public ByteGroup addBytes(byte[] bytes) {
		for (byte b : bytes) {
			byteContainer.add(b);
		}
		return this;
	}

	public int size() {
		return byteContainer.size();
	}
}
