<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>诺蓝邦附件</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/front_sys/accessor/accessorList.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">附件名：<input name="BUSINESSNAME" value="${param['BUSINESSNAME']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				
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
			<h5>附件信息列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<!--
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/front_sys/accessor/toAddAccessor.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增附件</button>   
            </span>
            -->
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="30">序号</th>
						<th width="260">文件名称</th>
						<th width="60">文件类型</th>
						<th>文件说明</th>
						<th width="80">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="u" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${u.FILENAME}</td>
	                    <td>${u.FILETYPE}</td>
	                    <td>${u.FILEEXPLAIN}</td>
	                    <td style="text-align:center">
                            <button  style="align:center" type="button" onClick="toDetail('${u.BAID}')" class="btn btn-success btn-mini"><i class="icon-pencil icon-white"></i>查看</button>
                            <!--
                            <button type="button" onClick="toUpdateDynamic('${u.BAID}')" class="btn btn-info btn-mini"><i class="icon-share icon-white"></i>编辑</button>
	                        <button type="button" onClick="deleteDynamic('${u.BAID}')" class="btn btn-danger btn-mini"><i class="icon-asterisk icon-white"></i>删除</button>
                        	-->
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
function toUpdateDynamic(id){
	toUrl('${ctx}/front_sys/accessor/toUpdateAccessor.htm?id='+id);
}

//跳到详情界面
function toDetail(id){
	toUrl('${ctx}/front_sys/accessor/toDetail.htm?id='+id);
}

//跳到新增界面
function toAddNlbmm(id){
	toUrl('${ctx}/front_sys/accessor/toAddAccessor.htm');
}

//删除记录
function deleteDynamic(id){
	if(confirm("此操作不可撤销，确认删除此记录？")){
		var url='${ctx}/front_sys/accessor/deleteAccessor.htm?id='+id;
		$.ajax({
			url: url,
			async : true,
			type :"GET",
			dataType : "text",
			success:function (data){
				if(data=='success'){
					alert("删除成功");
					window.location.href="${ctx}/front_sys/accessor/accessorList.htm?BUSINESSCODE=${param['BUSINESSCODE']}&BUSINESSNAME=${param['BUSINESSNAME']}";
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
