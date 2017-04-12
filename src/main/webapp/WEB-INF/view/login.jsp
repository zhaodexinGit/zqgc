<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>project系统登录</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/source/css/login.css">
<style>
/*
body{background-image:url(${ctx}/source/images/background.jpg);
background-repeat:no-repeat;}
*/
.lay_background {
    left: 0;
    overflow: hidden;
    position: absolute;
    top: 0;
    z-index: -1;
}
.lay_background .lay_background_img {
    left: 0;
    position: absolute;
    top: 0;
    z-index: -1;
}
.lay_background .lay_background_img {
    opacity: 0;
    transition: opacity 0.8s ease 0s;
}
.lay_background .lay_background_img_fade_out {
    opacity: 1;
}
.change-code {
    color: #666;
    display: inline-block;
    line-height: 14px;
    margin: 0;
    vertical-align: middle;
}
</style>
</head>
<body>
<script type="text/javascript">
	var bgArr = [],p_bgPics = [],p_bgPic = [];
	if(p_bgPic.length == 0){
		p_bgPic = [[1,'background.jpg',0],[0,'background1.jpg',0],[1,'background2.jpg',0],[1,'background3.jpg',0]];
	}
	for(var i = 0,len = p_bgPic.length;i < len;i++){
		if(p_bgPic[i].length > 0){
			bgArr.push(p_bgPic[i]);
		}
	}
	var bg_Data = bgArr[Math.floor(Math.random() * (bgArr.length))],bg_type = bg_Data[0],ft_col = bg_Data[2] || 0;
</script>
<div class="buc-login-box">
  <div class="login-container">
    <div class="header" style="margin-bottom:10px"></div>
    <form name="loginForm" id="loginForm" action="" method="post">
      <div class="legend">project系统登录入口</div>
      <hr>
      <hr class="decoration">
      <div class="hint"></div>
      <fieldset>
      <div id="container">
        <div class="input-prepend" style="padding-left:1px;"> <span class="add-on"> <i class="icon-user"></i> </span>
          <input autocomplete="off" id="username" name="username" value="admin" placeholder="登录账号" class="input" type="text">
        </div>
        <div class="input-prepend" style="padding-left:1px;"> <span class="add-on"> <i class="icon-key"></i> </span>
          <input autocomplete="off" id="password" name="password" value="admin" placeholder="密　码" class="input" type="password">
        </div>
        <div class="input-prepend" style="padding-left:1px;"> <span class="add-on" style="float:left"> <i class="icon-code"></i> </span>
             <input autocomplete="off" id="validateCode" name="validateCode" value="" placeholder="验证码" class="input" type="text" style="width:160px;float:left" maxlength="4">
             <img alt="验证码" title="看不清点击切换验证码" id="imgValidateCode" src="${ctx}/login/getValidateCode.htm" style="height:38px;float:right;line-height: 38px;cursor:pointer;"/>
        </div>
      </div>
      <label class="checkbox" id="keepLogin" style="display: none"> </label>
      <button type="button" class="btn-login" id="login" style="margin-top:20px">登录</button>
      </fieldset>
    </form>
  </div>
</div>
<script src="${ctx}/source/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/source/js/jquery_002.js"></script>
<script>
if(top!=self){
	if(top.location!=self.location){
		top.location=self.location;
	}
}
$(function () {
	
	var bg_img = document.getElementById('lay_bg_img');
    bg_img.src = '${ctx}/source/images/' + bg_Data[1];
    bg_img.onload = function(){
	   $("#lay_bg_img").addClass("lay_background_img_fade_out");
	   resizeBackground();
    };
    window.onresize = function(){
		resizeBackground();
    };
    $('#imgValidateCode').click(function () {
        $(this).attr('src', "${ctx}/login/getValidateCode.htm?n=" + Math.random());
    });
	
    //初始化placeholder
	$('input').placeholder(); 
	//禁用页面滚动条
	$(document.body).css({"overflow-x":"hidden","overflow-y":"hidden"});
   //登录
   $("#login").click(function () {
	   loginSubmit();
    });
   $(window).scroll(function(){
	   return false;
   });
});
/*注册事件*/    
if(document.addEventListener){    
document.addEventListener('DOMMouseScroll',scrollFunc,false);    
}//W3C    
window.onmousewheel=document.onmousewheel=scrollFunc;//IE/Opera/Chrome 
function scrollFunc(){
	return false;
}
var QZFL = {
		getById:function(id){
			return document.getElementById(id);
		},
		getClientHeight:function(doc){
			var _doc = doc || document;
			return _doc.compatMode == "CSS1Compat"?_doc.documentElement.clientHeight:_doc.body.clientHeight;
		},
		getClientWidth:function(doc){
			var _doc = doc || document;
			return _doc.compatMode == "CSS1Compat"?_doc.documentElement.clientWidth:_doc.body.clientWidth;
		}
	};
function resizeBackground(){
	var bg = document.getElementById('lay_bg'),
			bg_img = document.getElementById('lay_bg_img'),
			cw = QZFL.getClientWidth(),
			ch = QZFL.getClientHeight(),
			iw = bg_img.width,
			ih = bg_img.height;

	bg.style.width = cw + "px";
	bg.style.height = ch + "px";

	if(cw / ch > iw / ih){
		var new_h = cw * ih / iw,
				imgTop = (ch - new_h) / 2;
		bg_img.style.width = cw + "px";
		bg_img.style.height = new_h + "px";
		bg_img.style.top = imgTop + "px";
		bg_img.style.left = "";
	}else{
		var new_w = ch * iw / ih,
				imgLeft = (cw - new_w) / 2;
		bg_img.style.width = new_w + "px";
		bg_img.style.height = ch + "px";
		bg_img.style.left = imgLeft + "px";
		bg_img.style.top = "";
	}
}
function loginSubmit(){
	if (!$("#username").val()) {
		$(".hint").html('<span class="error" id="errorInfo">请输入正确账号！</span>');
		$("#username").focus();
		return false;
	} else if (!$("#password").val()) {
		$(".hint").html('<span class="error" id="errorInfo">您还没有输入密码！</span>');
		$("#password").focus();
		return false;
	}else if (!$("#validateCode").val()) {
		$(".hint").html('<span class="error" id="errorInfo">请输入验证码！</span>');
		$("#validateCode").focus();
		return false;
	} else {
	   $(".hint").html('<span style="color:green">登录中...</span>&nbsp;&nbsp;<img src="${ctx}/source/images/load.gif" alt="登录中..." />');
		 $.ajax({
			   type: "POST",
			   url:"${ctx}/login/loginIn.htm",
			   cache:false,
			   data: {
				   'userName':$("#username").val(),
				   'passWord':$("#password").val(),
				   'validateCode':$("#validateCode").val()
			   },
			   success: function(msg){
				  $(".hint").html("");
				 if('success'==msg){
					window.location.href='${ctx}/main/index.htm';
				 }else{
					if('error'==msg){
						alert("用户名或密码错误!");
					}else if('emptyUser'==msg){
						alert("用户名和密码不能为空!");
					}else if('forbiden'==msg){
						alert("该用户被禁用!");
					}else if('errorCode'==msg){
						alert("验证码错误");
						$('#imgValidateCode').attr('src', "${ctx}/login/getValidateCode.htm?n=" + Math.random());
					} else{errorCode
						
						alert("异常信息");
					}
				 }
			   }
			});
	}
}
if(document.addEventListener){
	document.addEventListener("keypress",fireFoxHandler, true);
	}else{
	document.attachEvent("onkeypress",ieHandler);
	}
	function fireFoxHandler(evt){
	if(evt.keyCode==13){
		loginSubmit();
	}
	}
	function ieHandler(evt){
	if(evt.keyCode==13){
		loginSubmit();
	}
}
</script>
<div id="lay_bg" class="lay_background">
<img id="lay_bg_img" class="lay_background_img" alt="">
</div>
</body>
</html>
