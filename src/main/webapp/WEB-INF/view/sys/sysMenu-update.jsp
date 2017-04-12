<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改菜单</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<%@include file="/source/common/header-add-update.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
	<form id="updateMenuForm" action="${ctx}/sys/sysMenu/updateSysMenu.htm" method="post">
	 <input id="id" name="id" type="hidden" />
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-edit"></i>
							</span>
							<h5>修改菜单</h5>
						</div>
						<div class="widget-content nopadding">
							<table cellspacing="0" cellpadding="5" style="width: 96%; margin: 20px" class="bootsTable">
								<tbody>
									<tr>
									    <td width="12%">菜单等级</td>
									    <td width="36%">
										    <div style="width:133px"><span style="float:left"><label><input type="radio" name="menuLevel" checked="checked" value="1"  onClick="selectRadio()"/>一级</label></span>
											<span style="float:right"><label><input type="radio" name="menuLevel" value="2"  onClick="selectRadio()"/>二级</label></span></div>
										</td>
										<td width="12%">上级菜单</td>
										<td width="36%">
										    <select id="parentMenuId" name="parentMenuId" style="width:218px" disabled="disabled">
										         <c:forEach var="u" items="${oneMenu}">
														 <option value="${u.id}">${u.menuName}</option>
												 </c:forEach>
									        </select>
										</td>
									</tr>
									<tr>
										<td>菜单名</td>
										<td><input type="text" name="menuName" id="menuName" /></td>
										<td>图标样式</td>
										<td><input type="text" name="iconClass" id="iconClass" /></td>
									</tr>
									<tr>
										<td>菜单地址</td>
										<td colspan="3"><input type="text" name="menuUrl" id="menuUrl" style="width:80%"/></td>
									</tr>
									<tr>
									    <td>状态</td>
									    <td colspan="3">
										    <div style="width:133px"><span style="float:left"><label><input type="radio" name="isDisable" checked="checked" value="1"/>启用</label></span>
											<span style="float:right"><label><input type="radio" name="isDisable" value="0"/>禁用</label></span></div>
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
</body>
<script>
	function menuUpdate() {
		$('#updateMenuForm').ajaxSubmit(function(data) {
			if (data == "success") {
				alert("保存菜单成功");
				window.location.href = '${ctx}/sys/sysMenu/sysMenuList.htm';
			} else {
				alert("保存菜单失败!");
			}
		});
	}

	$(document).ready(function() {
		var obj=${sysMenu};
		 for(var p in obj){     
	           // p 为属性名称，obj[p]为对应属性的值  
			if(p=="parentMenuId" && obj[p]!=null){
				$("#parentMenuId option[value='"+obj[p]+"']").attr("selected", true);
			}else if(p=="menuLevel"){
				$("input[type=radio][name='"+p+"'][value="+obj[p]+"]").attr("checked",'checked');
				if(obj[p]==2){
					$("#parentMenuId").removeClass("disable").removeAttr('disabled');
            		$("#parentMenuId").attr("value",obj["parentMenuId"]);
           		}
		    }else if(p=="isDisable"){
				$("input[type=radio][name='"+p+"'][value="+obj[p]+"]").attr("checked",'checked'); 
		    }else{
				$("input[name='"+p+"']").val(obj[p]);
			}
		 } 
		 $('select').select2();
		 $('input[type=checkbox],input[type=radio],input[type=file]').uniform();
		$("#updateMenuForm").validate({
			rules : {
				menuName : {
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
			submitHandler : function(form) {
				menuUpdate();
				return false;
			}
		});
	});
	function selectRadio(){
		$("input[type=radio][name='menuLevel']").each(function (){
			if ($(this).attr("checked")){
			    if($(this).val()==1){
				    $("#parentMenuId").addClass("disable").attr({disabled: true});
				}else{
			    	$("#parentMenuId").removeClass("disable").removeAttr('disabled');
		    	}
			    $('select').select2();
			}
		});
	}
</script>
</html>
