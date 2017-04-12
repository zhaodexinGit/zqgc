/*
 * Translated default messages for the jQuery validation plugin.
 * Locale: CN
 */
jQuery.extend(jQuery.validator.messages, {
        required: "必填",
		remote: "请修正该字段",
		email: "格式错误",  //邮件
		url: "网址错误",    
		date: "格式错误",  //时间 
		dateISO: "请输入合法的日期 (ISO).",
		number: "必填数字",
		digits: "只能输入整数",
		creditcard: "格式错误",
		equalTo: "请再次输入相同的值",
		accept: "请输入拥有合法后缀名的字符串",
		maxlength: jQuery.validator.format("请输入一个长度最多是 {0} 的字符串"),
		minlength: jQuery.validator.format("请输入一个长度最少是 {0} 的字符串"),
		rangelength: jQuery.validator.format("请输入一个长度介于 {0} 和 {1} 之间的字符串"),
		range: jQuery.validator.format("请输入一个介于 {0} 和 {1} 之间的值"),
		max: jQuery.validator.format("请输入一个最大为 {0} 的值"),
		min: jQuery.validator.format("请输入一个最小为 {0} 的值")
});