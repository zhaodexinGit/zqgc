<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>诺蓝邦数据字典</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<%@include file="/source/common/header-list.jsp" %>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
<form id="mainForm" action="${ctx}/front_sys/dictionary/dictionaryList.htm" method="post" style="margin:0;padding:0">
<div class="container-fluid" >
  <div class="row-fluid">
    <div class="span12">
        <table cellspacing="0" cellpadding="0" style="width: 96%; margin: 0px">
            <tr>
				<td width="240">名称：<input name="NAME" value="${param['NAME']}" type="text" style="width:120px;margin-top:10px" placeholder="模糊查询" /></td>
				
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
			<h5>数据字典信息列表</h5>
			<span class="badge badge-info" style="margin-top:8px">${pageData.totalCount}</span>
			<span style="margin-top:3px; float:right">
		         <button type="button" onClick="toUrl('${ctx}/front_sys/dictionary/toAddDictionary.htm')" class="btn btn-info">
		         <i class="icon-plus  icon-white"></i>新增数据字典</button>   
            </span>
		</div>
		<div class="widget-content nopadding">
			<table class="table table-bordered table-striped" >
				<thead>
					<tr>
						<th width="40">序号</th>
						<th width="80">字典类别</th>
						<th>父节点</th>
						<th>名称</th>
						<th>数值</th>
						<th width="300">备注</th>
						<th width="80">所属字典类型</th>
						<th width="80">所属字典数值</th>
						<th width="200">操作</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="u" items="${pageData.result}" varStatus="status">
					<tr>
						<td>${status.index+1+(pageData.pageNo-1)*(pageData.pageSize)}</td>
						<td>${u.TYPE}</td>
						<td>${u.PID}</td>
						<td>${u.NAME}</td>
						<td>${u.VALUE}</td>
						<td>${u.REMARK}</td>
	                    <td>${u.BELONGTYPE}</td>
	                    <td>${u.BELONGVALUE}</td>
	                    <td>
                            <button type="button" onClick="toDetail('${u.BDID}')" class="btn btn-success btn-mini"><i class="icon-pencil icon-white"></i>查看</button>
                            <button type="button" onClick="toUpdateDictionary('${u.BDID}')" class="btn btn-info btn-mini"><i class="icon-share icon-white"></i>编辑</button>
	                        <button type="button" onClick="deleteDictionary('${u.BDID}')" class="btn btn-danger btn-mini"><i class="icon-asterisk icon-white"></i>删除</button>
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
function toUpdateDictionary(id){
	toUrl('${ctx}/front_sys/dictionary/toUpdateDictionary.htm?id='+id);
}

//跳到详情界面
function toDetail(id){
	toUrl('${ctx}/front_sys/dictionary/toDetail.htm?id='+id);
}

//跳到新增界面
function toAddDictionary(id){
	toUrl('${ctx}/front_sys/dictionary/toAddDictionary.htm');
}

//删除记录
function deleteDictionary(id){
	if(confirm("此操作不可撤销，确认删除此记录？")){
		var url='${ctx}/front_sys/dictionary/deleteDictionary.htm?id='+id;
		$.ajax({
			url: url,
			async : true,
			type :"GET",
			dataType : "text",
			success:function (data){
				if(data=='success'){
					window.location.href="${ctx}/front_sys/dictionary/dictionaryList.htm?BUSINESSCODE=${param['BUSINESSCODE']}&BUSINESSNAME=${param['BUSINESSNAME']}";
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
