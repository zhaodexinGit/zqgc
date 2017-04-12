<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>用户管理</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/sys/user/userList.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">用户账号：<input name="userName" value="${param['userName']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				<td width="200">状态：
                   <select id="enableStatus" name="enableStatus" style="width:120px">
			            <option value="-1" <c:if test="${param['enableStatus']=='-1'}">selected</c:if>>全部</option>
			            <option value="1" <c:if test="${param['enableStatus']=='1'}">selected</c:if>>启用</option>
				        <option value="0" <c:if test="${param['enableStatus']=='0'}">selected</c:if>>禁用</option>
		        	</select>
                </td>
                <td width="100">
                 <button type="button" onClick="javascript:search();" class="btn btn-info">
       			 <i class="icon-search  icon-white"></i>搜索</button>  
                </td>
                <td></td>
			</tr>
        </table>
      <div class="widget-box" style="margin-top:0px">
		<div class="widget-title">
			<span class="icon">
				<i class="icon-user"></i>
			</span>
			<h5>用户信息列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/sys/user/toAddUser.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增用户</button>   
            </span>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="40">序号</th>
						<th>用户名</th>
						<th>手机号</th>
						<th>邮箱</th>
						<th>创建时间</th>
						<th>状态</th>
						<th>角色</th>
						<th width="200">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="u" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${u.userName}</td>
						<td>${u.mobile}</td>
						<td>${u.email}</td>
						<td>
							<fmt:formatDate value="${u.createDate}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
						    <c:if test="${'0' == u.enableStatus}"> 
						              禁用
	                        </c:if>
	                        <c:if test="${'1' == u.enableStatus}">
	                                                                    启用
	                        </c:if>
	                    </td>
	                    <td>${u.roles}</td>
						<td>
                            <button type="button" onClick="toUpdateUser('${u.id}')" class="btn btn-info btn-mini"><i class="icon-pencil icon-white"></i>编辑</button>
                            <button type="button" onClick="userPower('${u.id}')" class="btn btn-success btn-mini"><i class="icon-share icon-white"></i>权限</button>
	                        <button type="button" onClick="initializePassword('${u.id}')" class="btn btn-warning btn-mini"><i class="icon-asterisk icon-white"></i>初始密码</button>
                 		    <!-- <button class="btn btn-danger btn-mini"><i class="icon-remove icon-white"></i>删除</button> -->
                        </td>
					</tr>
				</c:forEach>
				</tbody>
			</table>							
		</div>
		<!-- footer start-->
        <%@include file="/source/common/page.jsp" %>
		<!-- footer end-->
      </div>
    </div>
  </div>
</div>
</form>
<div id="dialog" title="用户权限">
	<div style="height: 300px;overflow-y: scroll;width: 100%;"><ul id="menuTree" class="ztree"></ul></div>
</div>
<script>
var main_userId=0;
//ztree基本设置
var setting={
	    check: {
	        enable: true
	    },
	    data: {
	        simpleData: {
	            enable: true
	        }
	    }
	};
$(document).ready(function() {
	//弹出权限ztree窗口
	$( "#dialog").dialog({
		autoOpen: false,
		modal:true,
		width: 400,
		buttons: [
			{
				text: "确定",
				click: function() {
					var treeObj = $.fn.zTree.getZTreeObj("menuTree");
					var nodes = treeObj.getCheckedNodes(true);
					var menuIds="";
					  $.each(nodes, function(i,node){
					       menuIds+=node.id+",";
					  }); 
					  $.ajax({
						   type: "POST",
						   url: "${ctx}/sys/sysUserMenu/powerUserMemu.htm",
						   cache:false,
						   data: {
							   'userIds':main_userId,
							   'menuIds':menuIds.substring(0,menuIds.length-1)
						   },
						   success: function(msg){
							 msg = decodeURI(msg);
						     if('success'==msg){
						    	 alert("授权成功!");
						     }else{
						    	 alert("授权失败!");
						     }
						   }
						});	
					$( this ).dialog( "close" );
				}
			},
			{
				text: "取消",
				click: function() {
					$( this ).dialog( "close" );
				}
			}
		]
	});        
});
//用户授权
function userPower(userId){
	main_userId=userId;
   	$( "#dialog" ).dialog( "open" );
   	$.post("${ctx}/sys/sysUserMenu/getUserMenu.htm",{
	 'userId':userId
    },
    function(data){
    	$.fn.zTree.init($("#menuTree"), setting,eval('('+data+')'));
    });
}

//跳到修改用户界面
function toUpdateUser(userId){
	toUrl('${ctx}/sys/user/toUpdateUser.htm?userId='+userId);
}

//初始化密码
function initializePassword(userId){
	$.ajax({
	   type: "POST",
	   url: "${ctx}/sys/user/initializePassword.htm",
	   cache:false,
	   data: {
		   'userId':userId
	   },
	   success: function(msg){
	     if('success'==msg){
	    	 alert("初始化密码成功(密码：admin)!");
	     }else{
	    	 alert("初始化密码失败!");
	     }
	   }
	});
}
</script>
</body>
</html>
