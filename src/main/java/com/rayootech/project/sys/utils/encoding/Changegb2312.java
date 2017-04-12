package com.rayootech.project.sys.utils.encoding;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Changegb2312 {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String str = "b李珂镠a";
		changeStr(str);
		createxml();
	}

	/**
	 * 处理字符串，对于ascii字符和gb2312字符不做处理，其它字符转换成unicode
	 * 
	 * @param strText
	 *            待转换的字符串
	 * 
	 * @return 转换后的字符串
	 */
	public static String changeStr(String strText) throws UnsupportedEncodingException {
		char c;
		String strRet = "";
		String strHex;
		strText = new String(strText.getBytes());
		for (int i = 0; i < strText.length(); i++) {
			c = strText.charAt(i);
			if (c <= 128 || isGB2312(c)) {
				strRet = strRet + c;
			} else {
				strHex = Integer.toHexString((int) c);
				strRet = strRet + "&#x" + strHex + ";";
			}
		}
		return strRet;
	}

	public static void createxml() throws IOException, SAXException {
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		fos = new FileOutputStream(new File("c:/test.xml"));
		bos = new BufferedOutputStream(fos);
		OutputFormat of = new OutputFormat("XML", "gb2312", true);
		XMLSerializer serializer = new XMLSerializer(bos, of);
		ContentHandler hd = serializer.asContentHandler();
		AttributesImpl atts = new AttributesImpl();
		hd.startElement("", "", "PassengerName", atts);
		String str = changeStr("李珂镠");
		hd.ignorableWhitespace(str.toCharArray(), 0, str.length());
		hd.endElement("", "", "PassengerName");
		fos.close();
		bos.close();

	}

	/**
	 * GB2312 0xB0-0xF7(176-247) 0xA0-0xFE（160-254） GBK
	 * 0x81-0xFE(129-254)0x40-0xFE（64-254）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isGB2312(String str) {
		char[] chars = str.toCharArray();
		boolean isGB2312 = false;
		for (int i = 0; i < chars.length; i++) {
			byte[] bytes = ("" + chars[i]).getBytes();
			if (bytes.length == 2) {
				int[] ints = new int[2];
				ints[0] = bytes[0] & 0xff;
				ints[1] = bytes[1] & 0xff;
				if (ints[0] >= 176 && ints[0] <= 247 && ints[1] >= 160 && ints[1] <= 254) {
					isGB2312 = true;
					break;
				}
			}
		}
		return isGB2312;

	}

	/**
	 * GB2312 0xB0-0xF7(176-247) 0xA0-0xFE（160-254） GBK
	 * 0x81-0xFE(129-254)0x40-0xFE（64-254）
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isGB2312(char c) {
		boolean isGB2312 = false;
		byte[] bytes = ("" + c).getBytes();
		if (bytes.length == 2) {
			int[] ints = new int[2];
			ints[0] = bytes[0] & 0xff;
			ints[1] = bytes[1] & 0xff;
			if (ints[0] >= 176 && ints[0] <= 247 && ints[1] >= 160 && ints[1] <= 254) {
				isGB2312 = true;
			}
		}
		return isGB2312;

	}

}
