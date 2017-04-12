<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改角色</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%@include file="/source/common/header-add-update.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
	<form id="updateSysRoleForm" action="${ctx}/sys/sysRole/updateSysRole.htm" method="post">
		<input id="id" name="id" type="hidden" />
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-plus"></i>
							</span>
							<h5>修改角色</h5>
						</div>
						<div class="widget-content nopadding">
							<table cellspacing="0" cellpadding="5" style="width: 96%; margin: 20px" class="bootsTable">
								<tbody>
									<tr>
										<td width="12%">角色名称</td>
										<td width="36%"><input type="text" name="roleName" id="roleName" /></td>
										<td width="12%">角色编码</td>
										<td><input type="text" name="roleCode" id="roleCode" /></td>
									</tr>
									<tr>
										<td>是否禁用</td>
										<td>
										 	<select id="status" name="status" style="width:218px">
									            <option value="1">启用</option>
										        <option value="0">禁用</option>
								        	</select>
										</td>
									</tr>
									<tr>
										<td>描述</td>
										<td colspan="3"> 
										   <textarea rows="3" cols="18" name="remark" id="remark" style="width:78%"></textarea>
										</td>
									</tr>
									
								</tbody>
							</table>
							<div class="form-actions">
								<button style="margin-left:100px" type="submit" class="btn btn-primary">保存</button>
								<button type="button" class="btn btn-primary" onClick="history.go(-1)">返回</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</form>
<script>
	function updateSysRole() {
		$('#updateSysRoleForm').ajaxSubmit(function(data) {
			if (data == "success") {
				alert("保存角色成功");
				window.location.href = '${ctx}/sys/sysRole/sysRoleList.htm';
			} else {
				alert("保存角色失败!");
			}
		});
	}

	$(document).ready(function() {
	    var obj=${sysRole};
		 //赋值
		 for(var p in obj){  
		    // alert("p:"+obj[p]);   
				if(p=="status" && obj[p]!=null){
					$("#status option[value='"+obj[p]+"']").attr("selected", true);
				}else{
					$("#"+p).val(obj[p]);
				}
		 } 
		 $('select').select2();
		$("#updateSysRoleForm").validate({
			rules : {
				roleName:{
					required:true
				},
				roleCode : {
					required : true,
					minlength : 1,
					remote : {
						url : "${ctx}/sys/sysRole/checkoutRoleCode.htm?id="+$("#id").val(),
						type : "POST",
						dateType : "json",
						data : {
							roleCode : function() {
								return $("#roleCode").val();
							}
						}
					}
				},
				filed3 : {
					required : true
				},
				filed4 : {
					required : true

				}
			},
			errorClass: "help-inline",
			errorElement: "span",
			highlight:function(element, errorClass, validClass) {
				$(element).parents('td').addClass('error');
			},
			unhighlight: function(element, errorClass, validClass) {
				$(element).parents('td').removeClass('error');
				$(element).parents('td').addClass('success');
			},
			messages : {
				roleCode : {
					remote : "角色编码已存在"
				}
			},
			submitHandler : function(form) {
				updateSysRole();
				return false;
			}
		});
	});
</script>
</body>
</html>
