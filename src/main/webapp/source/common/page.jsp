<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
function jumpPage(pageNo) {
	if(pageNo==-1){	
		var sumPages="${pageData.totalPages}";
	    pageNo= $("#pageNo").val();
	    if(pageNo==""){
			alert("请输入要跳转的页数!");
			return;
		}
	    if(pageNo<=0){
			pageNo=1;
		}else if(parseInt(pageNo)>parseInt(sumPages)){
			pageNo=sumPages;
		}
	}
	$("#pageNo").val(pageNo);
	$("#mainForm").submit();
}

function search() {
	$("#mainForm").submit();
}
$(function() {
	//只能输入0-9的整数数字。
	$("#pageNo").keyup(function(){  
	    $(this).val($(this).val().replace(/[^0-9]/g,''));  
	}).bind("paste",function(){  //CTR+V事件处理  
	    $(this).val($(this).val().replace(/[^0-9]/g,''));   
	}).css("ime-mode", "disabled"); //CSS设置输入法不可用  
});
function toUrl(url){
	window.location.href=url;
}
</script>
<div class="fg-toolbar" style="border-bottom:1px solid #D5D5D5; padding:8px">
	<div class="dataTables_filter">
		<label>【第${pageData.pageNo}页/共${pageData.totalPages}页】【本页${pageData.pageNum}条/共 ${pageData.totalCount}条】 </label>
	</div>
	<div class="dataTables_paginate" style="margin-top:0px"> 
    	<button class="btn first btn-mini" onClick="jumpPage(1)" <c:if test="${pageData.pageNo==1}">disabled="disabled"</c:if> >首页</button>
    	<button class="btn previous btn-mini" onClick="jumpPage(${pageData.prePage})" <c:if test="${pageData.pageNo==1}">disabled="disabled"</c:if> >上一页</button>
    	<button class="btn next btn-mini" onClick="jumpPage(${pageData.nextPage})"  <c:if test="${pageData.pageNo==pageData.totalPages}">disabled="disabled"</c:if> >下一页</button>
    	<button class="btn last btn-mini" onClick="jumpPage(${pageData.totalPages})" <c:if test="${pageData.pageNo==pageData.totalPages}">disabled="disabled"</c:if> >尾页</button>
		<span>&nbsp;&nbsp;转 &nbsp;<input type="text" id="pageNo" name="pageNo" value="${pageData.pageNo }" maxlength="10" style="margin:0;width:30px;height:20px;padding:0"/>
		&nbsp;页&nbsp;&nbsp;<button type="button" class="btn btn-info btn-mini" onclick="jumpPage(-1)">确定</button>&nbsp;&nbsp;</span>
	</div>
</div>