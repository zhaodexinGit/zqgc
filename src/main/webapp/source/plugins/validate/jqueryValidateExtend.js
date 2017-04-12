//字符验证 
jQuery.validator.addMethod("stringCheck", function(value, element) { 
return this.optional(element) || /^[\u0391-\uFFE5\w]+$/.test(value); 
}, "只能包括中文字、英文字母、数字和下划线");
var enNumStr = /[^a-zA-Z0-9]/g; 
jQuery.validator.addMethod("stringEnNum", function(value, element) { 
	return this.optional(element) || !(enNumStr.test(value)); 
	}, "只能包括英文字母、数字");
// 中文字两个字节 
jQuery.validator.addMethod("byteRangeLength", function(value, element, param) { 
var length = value.length; 
for(var i = 0; i < value.length; i++){ 
if(value.charCodeAt(i) > 127){ 
length++; 
} 
} 
return this.optional(element) || ( length >= param[0] && length <= param[1] ); 
}, "请确保输入的值在3-15个字节之间(一个中文字算2个字节)");
// 身份证号码验证 
jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
return this.optional(element) || isIdCardNo(value); 
}, "格式错误");
// 手机号码验证 
jQuery.validator.addMethod("isMobile", function(value, element) { 
var length = value.length; 
var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
return this.optional(element) || (length == 11 && mobile.test(value)); 
}, "格式错误");
// 电话号码验证 
jQuery.validator.addMethod("isTel", function(value, element) { 
var tel = /^\d{3,4}-?\d{7,9}$/; //电话号码格式010-12345678 
return this.optional(element) || (tel.test(value)); 
}, "格式错误");
// 联系电话(手机/电话皆可)验证 
jQuery.validator.addMethod("isPhone", function(value,element) { 
var length = value.length; 
var mobile = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; 
var tel = /^\d{3,4}-?\d{7,9}$/; 
return this.optional(element) || (tel.test(value) || mobile.test(value));
}, "格式错误");
// 邮政编码验证 
jQuery.validator.addMethod("isZipCode", function(value, element) { 
var tel = /^[0-9]{6}$/; 
return this.optional(element) || (tel.test(value)); 
}, "格式错误"); 
//传真验证 
jQuery.validator.addMethod("isFax", function(value, element) { 
var tel = /^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
return this.optional(element) || (tel.test(value)); 
}, "格式错误"); 
//QQ号码验证   
jQuery.validator.addMethod("isQQ", function(value, element) {
    var tel = /^[1-9]\d{4,9}$/;
    return this.optional(element) || (tel.test(value));
}, "格式错误");
// IP地址验证
jQuery.validator.addMethod("isIp", function(value, element) {
    var ip = /^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$/;
    return this.optional(element) || (ip.test(value) && (RegExp.$1 < 256 && RegExp.$2 < 256 && RegExp.$3 < 256 && RegExp.$4 < 256));
}, "格式错误");

//判断数值类型，包括整数和浮点数
jQuery.validator.addMethod("isNumber", function(value, element) {       
     return this.optional(element) || /^[-\+]?\d+$/.test(value) || /^[-\+]?\d+(\.\d+)?$/.test(value);       
}, "格式错误"); 