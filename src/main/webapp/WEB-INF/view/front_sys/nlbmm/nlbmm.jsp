<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>诺蓝帮密码</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/front_sys/nlbmm/nlbmmList.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">标题：<input name="title" value="${param['title']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				<td width="200">类型：
                   <select id="type" name="type" style="width:120px">
                   		 <option value="" <c:if test="${param['type']==''}">selected</c:if>> </option>
			            <option value="公司篇" <c:if test="${param['type']=='公司篇'}">selected</c:if>>公司篇</option>
			            <option value="价值篇" <c:if test="${param['type']=='价值篇'}">selected</c:if>>价值篇</option>
				        <option value="文化篇" <c:if test="${param['type']=='文化篇'}">selected</c:if>>文化篇</option>
				        <option value="愿望篇" <c:if test="${param['type']=='愿望篇'}">selected</c:if>>愿望篇</option>
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
				<i class="icon-application_view_gallery"></i>
			</span>
			<h5>诺蓝帮密码列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/front_sys/nlbmm/toAddNlbmm.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增密码</button>   
            </span>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="40">序号</th>
						<th>标题</th>
						<th>类型</th>
						<th>创建人</th>
						<th>创建时间</th>
						<th>最后修改人</th>
						<th>修改时间</th>
						<th width="200">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="u" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${u.title}</td>
						<td>${u.type}</td>
						<td>${u.createUser.userName}</td>
						<td>
							<fmt:formatDate value="${u.create_time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>${u.updateUser.userName}</td>
						<td>
							<fmt:formatDate value="${u.update_time}" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
                            <button type="button" onClick="toDetail('${u.id}')" class="btn btn-success btn-mini"><i class="icon-share icon-white"></i>查看</button>
                            <button type="button" onClick="toUpdateNlbmm('${u.id}')" class="btn btn-info btn-mini"><i class="icon-pencil icon-white"></i>编辑</button>
                 		    <button type="button" onClick="deleteNlbmm('${u.id}')" class="btn btn-danger btn-mini"   ><i class="icon-remove icon-white"></i>删除</button>
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

//跳到修改界面
function toUpdateNlbmm(id){
	toUrl('${ctx}/front_sys/nlbmm/toUpdateNlbmm.htm?id='+id);
}
//跳到详情界面
function toDetail(id){
	toUrl('${ctx}/front_sys/nlbmm/toDetail.htm?id='+id);
}
//跳到新增界面
function toAddNlbmm(id){
	toUrl('${ctx}/front_sys/nlbmm/toAddNlbmm.htm');
}

//删除记录
function deleteNlbmm(id){
	if(confirm("此操作不可撤销，确认删除此记录？")){
		var url='${ctx}/front_sys/nlbmm/deleteNlbmm.htm?id='+id;
		$.ajax({
			url: url,
			async : true,
			type :"GET",
			dataType : "text",
			success:function (data){
				if(data=='success'){
					alert("删除成功");
					window.location.href="${ctx}/front_sys/nlbmm/nlbmmList.htm?title=${param['title']}&type=${param['type']}";
				}
			},
			error: function (data){
				alert("删除失败");
			}
			
			
		})
	}
	
	
}

</script>
</body>
</html>
<!-- 


 -->
