<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>角色管理</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/sys/sysRole/sysRoleList.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">角色名称：<input name="roleName" value="${param['roleName']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				<td width="200">状态：
                   <select id="status" name="status" style="width:120px">
			            <option value="-1" <c:if test="${param['status']=='-1'}">selected</c:if>>全部</option>
			            <option value="1" <c:if test="${param['status']=='1'}">selected</c:if>>启用</option>
				        <option value="0" <c:if test="${param['status']=='0'}">selected</c:if>>禁用</option>
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
				<i class="icon-list-alt"></i>
			</span>
			<h5>角色信息列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/sys/sysRole/toAddSysRole.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增角色</button>   
            </span>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="40">序号</th>
						<th>角色名称</th>
						<th>角色编码</th>
						<th>创建人</th>
						<th>创建时间</th>
						<th>状态</th>
						<th>备注</th>
						<th width="80">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="l" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${l.roleName}</td>
						<td>${l.roleCode}</td>
						<td>${l.creatorName}</td>
						<td>${l.createTime}</td>
						<td>	
						    <c:if test="${l.status=='1'}">启用</c:if>
						    <c:if test="${l.status=='0'}">禁用</c:if>
						</td>
						<td>${l.remark}</td>
						<td>
                            <button type="button" onClick="toUpdateSysRole('${l.id}')" class="btn btn-info btn-mini"><i class="icon-pencil icon-white"></i>编辑</button>
	                        <!-- <button type="button" onClick="deleteSysRole('${l.id}')" class="btn btn-danger btn-mini"><i class="icon-remove icon-white"></i>删除</button> -->
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
<script>

//跳到修改界面
function toUpdateSysRole(id){
	toUrl('${ctx}/sys/sysRole/toUpdateSysRole.htm?id='+id);
}
/**
 * 删除信息
 */
function deleteSysRole(id){
	if(!confirm("确定要删除这条数据吗？")){
		return;
	}
	$.ajax({
		   type: "POST",
		   url: "${ctx}/sys/sysRole/deleteSysRole.htm",
		   cache:false,
		   data: {
			   'id':id
		   },
		   success: function(msg){
		     if('success'==msg){
		    	 alert("删除成功!");
		    	 toUrl('${ctx}/sys/sysRole/sysRoleList.htm');
		     }else{
		    	 alert("删除失败!");
		     }
		   }
		});
}
</script>
</body>
</html>