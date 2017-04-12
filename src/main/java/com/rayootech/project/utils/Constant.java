package com.rayootech.project.utils;

/**
 * <B>功能简述</B><br>
 * APP请求全局返回码 /其余返回码APP过来从4开头 保持6位
 * 
 * @date 2015年3月25日 上午11:12:03
 * @author XuSheng
 * @since [project/全局返回码]
 */
public final class Constant {

	/**
	 * 请求成功
	 */
	public static final int RESULT_CODE_SUCCESS = 0;

	/**
	 * 系统繁忙
	 */
	public static final int RESULT_CODE_TIMEOUT = -1;

	/**
	 * 请求服务器凭证错误
	 */
	public static final int RESULT_CODE_APP_SIGN_ISERROR = 400001;

	/**
	 * 账户初始化失败
	 */
	public static final int RESULT_CODE_ACCOUNT_INIT_ISFAIL = 400002;

	/**
	 * 参数为空
	 */
	public static final int RESULT_CODE_PARAMS_IS_NULL = 400003;

	/**
	 * 该用户账户存在
	 */
	public static final int RESULT_CODE_ACCOUNT_INFO_EXIST = 400004;

	/**
	 * 用户不存在
	 */
	public static final int RESULT_CODE_ACCOUNT_INFO_NOT_EXIST = 400005;

	/**
	 * 生成订单失败
	 */
	public static final int RESULT_CODE_CREATE_ORDER_ERROR = 400006;

	/**
	 * 医生预约人数已满
	 */
	public static final int RESULT_CODE_FLULL_PEOPLE_ERROR = 400007;

	/**
	 * 患者绑定医生失败
	 */
	public static final int RESULT_CODE_BING_DOCTOR_ERROR = 400008;

	/**
	 * 患者加入解决方案失败
	 */
	public static final int RESULT_CODE_JOIN_PLAN_ERROR = 400009;

	/**
	 * 支付余额不足
	 */
	public static final int RESULT_CODE_MONEY_NOT_ENOUGH_ERROR = 400010;

	/**
	 * 患者已经预约过了
	 */
	public static final int RESULT_CODE_ALREADY_SUBSCRIBE = 400011;

	/**
	 * 预约日期已过
	 */
	public static final int RESULT_CODE_PAST_SUBSCRIBE_TIME = 400012;

	/**
	 * 健康券赠送失败
	 */
	public static final int RESULT_CODE_ACCOUNT_GIFTS_FAIL = 400013;

	/**
	 * 账户登录密码错误
	 */
	public static final int RESULT_CODE_ACCOUNT_PASSWORD_LOGIN_ERROR = 400014;

	/**
	 * 账户修改密码错误
	 */
	public static final int RESULT_CODE_ACCOUNT_PASSWORD_UPDATE_ERROR = 400015;

	/**
	 * 打赏数量超限制1314
	 */
	public static final int RESULT_COUNT_LIMIT_ERROR = 400016;

	/**
	 * 银行卡添加失败
	 */
	public static final int RESULT_CODE_ACCOUNT_BANK_CARD_ADD_ISERROR = 400017;

	/**
	 * 修改医生出诊时间出错
	 */
	public static final int RESULT_CHANGE_VISIT_ERROR = 400018;

	/**
	 * 医生已经有预约了
	 */
	public static final int RESULT_DOCTOR_ALREADY_SUBSCRIBE = 400019;

	/**
	 * 银行卡删除失败
	 */
	public static final int RESULT_CODE_ACCOUNT_BANK_CARD_DELETE_ISERROR = 400020;
	/**
	 * 用户不存在
	 */
	public static final int RESULT_USER_NOT_EXIST = 400021;

	/**
	 * 商品不存在
	 */
	public static final int RESULT_CODE_PRODUCT_INFO_NOT_EXIST = 400022;

	/**
	 * 还未加入治疗方案
	 */
	public static final int RESULT_CODE_NO_JOIN = 400023;

	/**
	 * 添加的银行卡号已存在
	 */
	public static final int RESULT_CODE_ACCOUNT_BANK_CARD_ADD_IS_EXIST = 400024;

}
