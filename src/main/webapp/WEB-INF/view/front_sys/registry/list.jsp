<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>公司注册</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/front_sys/registry/list.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">标题：<input name="title" value="${param['title']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				
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
			<h5>公司注册信息列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/front_sys/registry/toAdd.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增介绍</button>   
            </span>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="40">序号</th>
						<th>主题</th>
						<th>操作用户</th>
						<th>操作时间</th>
						<th width="200">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="e" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${e.title}</td>
						<td>
							${e.operateUser.name}
						</td>
						<td>${e.operate_time}</td>
	                    <td>
                            <button type="button" onClick="toDetail('${e.id}')" class="btn btn-info btn-mini"><i class="icon-pencil icon-white"></i>查看</button>
                            <button type="button" onClick="toUpdate('${e.id}')" class="btn btn-success btn-mini"><i class="icon-share icon-white"></i>编辑</button>
	                        <button type="button" onClick="deleteById('${e.id}')" class="btn btn-warning btn-mini"><i class="icon-asterisk icon-white"></i>删除</button>
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
	
//跳转到修改界面
function toUpdate(id){
	toUrl('${ctx}/front_sys/registry/toUpdate.htm?id='+id);
}

//跳到详情界面
function toDetail(id){
	toUrl('${ctx}/front_sys/registry/toDetail.htm?id='+id);
}

//跳到新增界面
function toAddNlbmm(id){
	toUrl('${ctx}/front_sys/registry/toAdd.htm');
}

//删除记录
function deleteById(id){
	if(confirm("此操作不可撤销，确认删除此记录？")){
		var url='${ctx}/front_sys/registry/delete.htm?id='+id;
		$.ajax({
			url: url,
			async : true,
			type :"GET",
			dataType : "text",
			success:function (data){
				if(data=='success'){
					alert("删除成功");
					window.location.href="${ctx}/front_sys/registry/list.htm?title=${param['title']}&introduction=${param['introduction']}";
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
