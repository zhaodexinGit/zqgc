<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>project</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${ctx}/source/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/source/css/dialog.css" />
<link rel="stylesheet" href="${ctx}/source/css/unicorn.main.css" />
<link rel="stylesheet" href="${ctx}/source/css/unicorn.blue.css" class="skin-color" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript">
	filterBrowser();
	//过滤浏览器版本：IE9.0 以下、Firefox 20、Chrome 20 以下
	function filterBrowser() {
		var version = navigator.appVersion;
		var versionCode;
		if (version.indexOf("MSIE ") > -1) {
			var browser = version.substring(version.indexOf("MSIE "), version.length);
			versionCode = parseInt(browser.split(";")[0].split(" ")[1]);
			if (versionCode < 9) {
				window.location.href ="${ctx}/main/browser.htm";
			}
		} else if (version.indexOf("Firefox/") > -1) {
			var fireFoxBrowser = version.substring(version.indexOf("Firefox/"), version.length);
			versionCode = parseInt(fireFoxBrowser.split("/")[1]);
			if (versionCode < 20) {
				 window.location.href ="${ctx}/main/browser.htm";
			}
		} else if (version.indexOf("Chrome/") > -1) {
			var ChromeBrowser = version.substring(version.indexOf("Chrome/"), version.length);
			versionCode = parseInt(ChromeBrowser.split("/")[1].split(".")[0]);
			if (versionCode < 20) {
			   window.location.href ="${ctx}/main/browser.htm";
			}
		}
	}
</script>
</head>
<body style="overflow-y:hidden">
<div id="header">
  <h1><a href="javascript:">project</a></h1>
</div>
<div id="search" style="margin-top:6px">
<font color="white">欢迎&nbsp;&nbsp;<b>${user.userName }</b>&nbsp;&nbsp;登录project系统</font>
</div>
<div id="user-nav" class="navbar navbar-inverse">
  <ul class="nav btn-group">
   <!-- <li class="btn btn-inverse"><a title="" href="#authorityModal" data-toggle="modal"><i class="icon icon-cog"></i> <span class="text">申请账号权限</span></a></li> --> 
     <li class="btn btn-inverse"><a title="" href="#myModal" data-toggle="modal"><i class="icon icon-asterisk"></i> <span class="text">修改密码</span></a></li>
    <li class="btn btn-inverse"><a title="安全退出" href="javascript:"  onClick="loginOut()"><i class="icon icon-share-alt"></i> <span class="text">安全退出</span></a></li>
  </ul>
</div>
<div id="sidebar" style="width:220px;height:400px;overflow:auto;overflow-x:hidden;">
  <ul>
    <li class="submenu active"><a  target="mainFrame" href="${ctx}/main/main.htm" id="index"><i class="icon icon-home"></i> <span>首页</span></a></li>
    <c:forEach items="${menus}" var="m" varStatus="mi">
	    <li class="submenu" className="${m.icon}"> <a id="menu${m.id}" href="#"><i class="icon ${m.icon}"></i> <span>${m.name}</span></a>
	      <ul>
	        <c:forEach items="${m.children}" var="l" varStatus="li">
			  	<li><a target="mainFrame" href="${ctx }${l.url}">${l.name}</a></li>
		    </c:forEach>
	      </ul>
	    </li>
     </c:forEach>
  </ul>
</div>
<div id="style-switcher" style="margin-right: -190px;">
	<i class="icon-white icon-arrow-left"></i>
	<span>主题:</span>
	<a id="greyColor" href="#grey" style="background-color: rgb(85, 85, 85); border-color: transparent;"></a>
    <a id="blueColor" href="#blue" style="background-color: rgb(45, 47, 87); border-color: transparent;"></a>
    <a id="redColor" href="#red" style="background-color: rgb(103, 50, 50); border-color: transparent;"></a>
</div>
<div id="content">
  <div id="content-header" class="breadcrumb1"> <a href="#" class="tip-bottom" style="cursor:default"><i class="icon-home"></i> 首页</a> </div>
  <iframe src="${ctx}/main/main.htm" id="mainFrame" name="mainFrame"  frameborder="no" width="100%" height="360" ></iframe>
</div>
<div id="myModal" class="modal hide fade" style="display: none;width:500px" aria-hidden="false">
  <div class="modal-header">
    <button class="close" type="button" data-dismiss="modal">×</button>
    <h3>修改密码</h3>
  </div>
  <div class="modal-body">
    <form id="updatePasswordForm" action="${ctx}/sys/user/updatePassword.htm" method="post" class="form-horizontal">
      <div class="control-group">
        <label class="control-label" style="width:88px">旧密码：</label>
        <div class="controls" style="margin-left: 100px;">
          <input id="oldPassword"  type="password" name="oldPassword" style="width:200px"/>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" style="width:88px">新密码：</label>
        <div class="controls" style="margin-left: 100px;">
          <input id="newPassword"  type="password" name="newPassword" style="width:200px"/>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" style="width:88px">确认密码：</label>
        <div class="controls" style="margin-left: 100px;">
          <input type="password" name="newPassword1" style="width:200px"/>
        </div>
      </div>
    </form>
  </div>
  <div class="modal-footer">
<button class="btn btn-primary" type="button" onClick="updatePassword()" >确定</button>
<a class="btn" href="#" data-dismiss="modal">取消</a>
</div>
</div>

<div id="authorityModal" class="modal hide in" style="display: none;width:500px" aria-hidden="false">
  <div class="modal-header">
    <button class="close" type="button" data-dismiss="modal">×</button>
    <h3>账号权限申请</h3>
  </div>
  <div class="modal-body">
		<p>英语图书馆后台权限申请，请联系:<font color="blue">zhangjun2@100tal.com</font></p>
  </div>
</div>
<script src="${ctx}/source/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/source/js/bootstrap.min.js"></script>
<script src="${ctx}/source/js/jquery-ui-dialog.min.js"></script>
<script type="text/javascript" src="${ctx}/source/js/jquery.form.js"></script>
<script src="${ctx}/source/plugins/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/source/plugins/validate/messages_cn.js" type="text/javascript"></script>
<script src="${ctx}/source/js/unicorn.js"></script>
<script>
$(document).ready(function () {
	windowResize(); //初始化iframe和左侧div高度
	$(window).resize(function(){ //屏幕改变大小时触发的事件
	   windowResize();
	});
	//改变面包屑导航标题
	$("#sidebar > ul > li > ul > li > a").click(function(){
	   var firstTitle=$(this).parents("ul").parents("li").find("a span").html();
	   var secondTitle=$(this).html();
	   var className=$(this).parents("ul").parents("li").attr("className");
	   $("#content-header").html('<a class="tip-bottom" href="#" style="cursor:default"><i class="'+className+'"></i>'+firstTitle+'</a><a class="current" href="#"  style="cursor:default">'+secondTitle+'</a>');
	});
	$("#index").click(function(){
		$("#content-header").html('<a class="tip-bottom" href="#" style="cursor:default"><i class="icon-home"></i>首页</a>');
		$("#mainFrame").attr("src","${ctx}/main/main.htm");
	});
	
	$("#oldPassword").focus();
	$("#oldPassword").val("");
	$("#updatePasswordForm").validate({
		rules: {
			oldPassword: {
				required:true,
				minlength:1
			},
			newPassword: {
				required:true,
				minlength:1
			},
			newPassword1: {
				required:true,
				minlength:1,
				equalTo:'#newPassword'
			}
		},
		 messages: {
			   oldPassword: "请输入旧密码",
			   newPassword: "请输入新密码",
			   newPassword1: {
			    required: "请输入确认密码",
			    equalTo: "两次输入密码不一致"
			   }
		},
		errorClass: "help-inline",
		errorElement: "span",
		highlight:function(element, errorClass, validClass) {
			$(element).parents('.control-group').addClass('error');
		},
		unhighlight: function(element, errorClass, validClass) {
			$(element).parents('.control-group').removeClass('error');
			$(element).parents('.control-group').addClass('success');
		},
		submitHandler: function(form) {
			updatePass();
			return false;
		}
	});
	$('#style-switcher a').click(function()
	{
		var style = $(this).attr('href').replace('#','');
		$('.skin-color').attr('href','${ctx}/source/css/unicorn.'+style+'.css');
		$(this).siblings('a').css({'border-color':'transparent'});
		$(this).css({'border-color':'#aaaaaa'});
		localStorage.setItem('style',style);
	});
	if(localStorage.getItem("style")!=null){
		var style=localStorage.getItem("style");
	    $('.skin-color').attr('href','${ctx}/source/css/unicorn.'+localStorage.getItem("style")+'.css');
	    $("#"+style+"Color").css({'border-color':'transparent'});
	    $("#"+style+"Color").css({'border-color':'#aaaaaa'});
    }else{
    	 $("#blueColor").css({'border-color':'#aaaaaa'});
    }
});
function updatePass()
{
	$('#updatePasswordForm').ajaxSubmit(function(data){
        if(data=="success"){
            alert("修改密码成功,下次登录时生效!");
            $('#myModal').modal('hide');
            $('#updatePasswordForm')[0].reset();
            $(".control-group").removeClass('success');
        }else if(data=="oldError"){
        	alert('旧密码不正确,请重新输入!');
        	$("#oldPassword").focus();
        	$("#oldPassword").val("");
        }else{
        	alert('修改密码失败!');
       	}
    });
}
function updatePassword(){
	$('#updatePasswordForm').submit();
}
//初始化iframe和左侧div高度
function windowResize(){
    var height=QZFL.getClientHeight();
    $("#mainFrame").attr("height",height-90);
	$("#sidebar").css("height",height-86);
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
function loginOut(){
	 /*confirm_msg('操作提示','确认要退出?',function(){
		location.href='${ctx}/main/loginOut.htm';
	 });*/
	 if(confirm("确认要退出吗?")) {
		 location.href='${ctx}/login/logout.htm';	
	 }
}
function openMenu(id){
	$("#menu"+id).trigger("click");
}
</script>
</body>
</html>
