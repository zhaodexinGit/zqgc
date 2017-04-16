package com.rayootech.project.utils;

import java.io.IOException;
import java.util.UUID;

/**
 * 生成唯一序列
 * @author 刘宇
 *
 */
public class Sequence {

	/*private static long sequenceNumber=1;*/
	
	public Sequence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 根据当前系统时间+序列号生成唯一主键
	 * @return
	 * @throws IOException 
	 */
	public static String getSequence() throws IOException{
		long sequenceNumber = PropertyUtil.getPropertiesValue("sequenceNumber");
		if(sequenceNumber == 999)
			sequenceNumber = 0;
		String strSequence = String.valueOf(System.currentTimeMillis());
		int i=strSequence.length()+String.valueOf(sequenceNumber).length();
		while(i<16){
			strSequence += "0";
			++i;
		}
		strSequence += String.valueOf(sequenceNumber);
		PropertyUtil.updatePropertiesValue("sequenceNumber", ++sequenceNumber);
		return strSequence;
	}
	
	public static String getSequenceNumber() {  
        UUID uuid = UUID.randomUUID();  
        String str = uuid.toString();  
        // 去掉"-"符号  
        String temp = str.substring(0, 8) + str.substring(9, 13) + str.substring(14, 18) + str.substring(19, 23) + str.substring(24);  
        return temp;  
    }
	
	public static void Main(String args[]) throws IOException{
		System.out.println(getSequence());
//		System.out.println(getUUID());
	}
}
