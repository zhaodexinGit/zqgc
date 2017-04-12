package com.rayootech.project.utils;

import java.math.BigDecimal;

/**
 * 
 * <B>功能简述</B><br>
 * BigDecimal计算帮助类
 * 
 * @date 2015年3月27日 下午3:26:31
 * @author DaiLu
 * @since [project/utils v1]
 */
public class AmountUtils {

	/**
	 * 提供默认精度(数字2表示保留小数点后两位)
	 */
	private static final int scale = 2;

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 构造函数不可被实例化
	 *
	 * @date 2015年3月27日下午3:38:35
	 * @author DaiLu 参数说明
	 */
	private AmountUtils() {
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个double类型变量相加
	 * 
	 * @date 2015年3月27日 下午3:28:17
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal add(double v1, double v2) {
		// 按照JDK帮助文档说明,如果采用double类型的话有可能丢失精度,推荐采用String类型.
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.add(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个double类型变量相减
	 * 
	 * @date 2015年3月27日 下午3:28:22
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal subtract(double v1, double v2) {
		// 按照JDK帮助文档说明,如果采用double类型的话有可能丢失精度,推荐采用String类型.
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.subtract(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个double类型变量相乘
	 * 
	 * @date 2015年3月27日 下午4:52:04
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal multiply(double v1, double v2) {
		// 按照JDK帮助文档说明,如果采用double类型的话有可能丢失精度,推荐采用String类型.
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.multiply(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个double类型变量相除
	 * 
	 * @date 2015年3月27日 下午4:18:00
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal divide(double v1, double v2) {
		// 按照JDK帮助文档说明,如果采用double类型的话有可能丢失精度,推荐采用String类型.
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		// ROUND_HALF_UP表示遇到.5的情况时往上近似,例:1.5 --> 2
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个String类型变量进行相加
	 * 
	 * @date 2015年3月27日 下午3:28:27
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal add(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个String类型变量相减
	 * 
	 * @date 2015年3月27日 下午3:28:50
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal subtract(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.subtract(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个String类型变量相乘
	 * 
	 * @date 2015年3月27日 下午3:28:43
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal multiply(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.multiply(b2);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 两个String类型变量相除
	 * 
	 * @date 2015年3月27日 下午3:28:33
	 * @author DaiLu
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal divide(String v1, String v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		// ROUND_HALF_UP表示遇到.5的情况时往上近似,例:1.5 --> 2
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
	}

	/**
	 * 
	 * <B>功能简述</B><br>
	 * 初始化计算数据
	 * 
	 * @date 2015年3月27日 下午6:08:11
	 * @author DaiLu
	 * @param obj
	 * @return
	 */
	public static BigDecimal initBigDecimal(Object obj) {
		if ("".equals(obj) || obj == null) {
			// 抛出不合法或不正确的参数异常
			throw new IllegalArgumentException("初始化计算数据时传入了空的参数!");
		}
		return new BigDecimal(String.valueOf(obj));
	}

	/**
	 * 小数位精确方式
	 */
	public enum RoundType {

		/** 四舍五入 */
		roundHalfUp,

		/** 向上取整 */
		roundUp,

		/** 向下取整 */
		roundDown
	}

	/**
	 * 设置精度
	 * 
	 * @param amount
	 *            数值
	 * @return 数值
	 */
	public static BigDecimal setScale(int priceScale, int roundingMode, BigDecimal amount) {
		if (amount == null) {
			return null;
		}
		return amount.setScale(priceScale, roundingMode);
	}
	
	public static BigDecimal multiply(BigDecimal b1, int i2) {
		// 按照JDK帮助文档说明,如果采用double类型的话有可能丢失精度,推荐采用String类型.
		BigDecimal b2 = new BigDecimal(Double.toString(i2));
		return b1.multiply(b2);
	}

}
