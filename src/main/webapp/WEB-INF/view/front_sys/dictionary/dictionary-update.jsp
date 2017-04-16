<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改数据字典</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/source/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/source/plugins/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/source/css/icon.css" />
<link rel="stylesheet" href="${ctx}/source/css/widget.css" />
<link rel="stylesheet" href="${ctx}/source/css/uniform.css" />	
<link rel="stylesheet" href="${ctx}/source/css/select2.css" />
<script src="${ctx}/source/js/jquery-1.8.3.min.js"></script>
<script src="${ctx}/source/js/jquery.form.js" type="text/javascript" ></script>
<script src="${ctx}/source/plugins/validate/jquery.validate.js" type="text/javascript"></script>
<script src="${ctx}/source/plugins/validate/jqueryValidateExtend.js" type="text/javascript"></script>
<script src="${ctx}/source/plugins/validate/messages_cn.js" type="text/javascript"></script>
<script src="${ctx}/source/js/jquery.uniform.js" type="text/javascript" ></script>
<script src="${ctx}/source/js/select2.min.js" type="text/javascript" ></script>
<script src="${ctx}/source/js/unicorn.js" type="text/javascript" ></script>
<script type="text/javascript" src="${ctx}/source/js/xiucai.js"></script>

<!-- ckeditor -->
<script type="text/javascript" src="${ctx}/source/plugins/ckeditor_4.5.10_full/ckeditor/ckeditor.js"></script>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
	<form id="updateDictionaryForm" action="${ctx}/front_sys/dictionary/updateDictionary.htm" method="post">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-plus"></i>
							</span>
							<h5>数据字典详情</h5>
						</div>
						<div class="widget-content nopadding">
							<table cellspacing="0" cellpadding="5" style="width: 96%; margin: 20px" class="bootsTable">
							<tbody>
									<tr>
										<td width="12%">字典类别</td>
										<td width="36%"><input type="text" name="TYPE" value="${dictionary.TYPE}" id="TYPE" /></td>
										<td width="12%">父节点</td>
										<td><input type="text" name="PID" value="${dictionary.PID}" id="PID" /></td>
									</tr>
									<tr>
										<td>名称</td>
										<td><input type="text" name="NAME" value="${dictionary.NAME}" id="NAME"/></td>
										<td>数值</td>
										<td><input type="text" name="VALUE" value="${dictionary.VALUE}" id="VALUE" /></td>
									</tr>
									<tr>
										
										<td>备注</td>
										    <td><input type="text" name="REMARK" value="${dictionary.REMARK}" id="REMARK"/></td>
										<td>序号</td>
										<td><input type="text" name="SNO" value="${dictionary.SNO}" id="SNO"/></td>
									</tr>
									<tr>
										
										<td>所属字典类型</td>
										    <td><input type="text" name="BELONGTYPE" value="${dictionary.BELONGTYPE}" id="BELONGTYPE"/></td>
										<td>所属字典数值</td>
										<td><input type="text" name="BELONGVALUE" value="${dictionary.BELONGVALUE}" id="BELONGVALUE"/></td>
									</tr>
									
								</tbody>
							</table>
							<div class="form-actions">
								<input type='hidden' name='BDID' value='${dictionary.BDID}'/>
								
								<button style="margin-left:100px" type="submit" class="btn btn-primary">保存</button>
								<!--
								<button type="reset" class="btn btn-primary">重置</button>
								--> 
								<button type="button" class="btn btn-primary" onClick="history.go(-1)">返回</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</form>
<script>

    function dynamicUpload() {
       var url = '${ctx}/front_sys/accessor/uploadDynamic.htm?id='+id
       $.ajax({
          url: url,
		  type :"POST",
		  dataType : $( '#postForm').serialize(), 
		  success:function (data){
				if(data=='success'){
					alert("上传成功");
				}
			},
		  error: function (data){
				alert("上传失败");
			}
       });
    
    }
    
    
	function update() {
		$('#updateDictionaryForm').ajaxSubmit(function(data) {
			if (data == "success") {
				alert("保存成功");
				window.location.href = '${ctx}/front_sys/dictionary/dictionaryList.htm';
			} else {
				alert("保存失败!");
			}
		});
	}

	$(document).ready(function() {
		$('input[type=radio]').uniform();
		$('select').select2();
		$("#updateDictionaryForm").validate({
			rules : {
				
				TYPE:{
					required:true,
				
				},
				PID : {
					required : true,
				},
				NAME:{
					required:true,
				},
				VALUE:{
					required:true,
					rangelength:[0,3]
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
				TYPE : {
					required : "商品编号不能为空"
				},
				PID : {
					required : "父节点不能为空"
				},
				NAME : {
					required : "名称不能为空"
				},
				VALUE : {
					required : "数值不能为空",
					rangelength:"数值的长度最大为3位数"
				}
			},
			submitHandler : function(form) {
		
				update();
				return false;
			}
		});
		
		
});
	var moveGridRow = {
		    Up: function (jq) {
		        var rowindex = jq.datagrid('getSelectedIndex');
		        if (rowindex > -1) {
		            var rows = jq.datagrid('getRows');
		            var newRowIndex = rowindex - 1;
		            if (newRowIndex < 0)
		                newRowIndex = 0;

		            var targetRow = rows[newRowIndex];
		            var currentRow = rows[rowindex];

		            rows[newRowIndex] = currentRow;
		            rows[rowindex] = targetRow;

		            jq.datagrid('loadData', rows);
		            jq.datagrid('selectRow', newRowIndex);

		        } else
		            alert('亲，都到顶啦，在点就可以见到天宫1号啦！');
		    },
		    Down:function(jq) {
		        var rowindex = jq.datagrid('getSelectedIndex');
		        var rows = jq.datagrid('getRows');
		        if (rowindex < rows.length - 1) {
		            var newRowIndex = rowindex + 1;

		            var targetRow = rows[newRowIndex];
		            var currentRow = rows[rowindex];

		            rows[newRowIndex] = currentRow;
		            rows[rowindex] = targetRow;

		            jq.datagrid('loadData', rows);
		            jq.datagrid('selectRow', newRowIndex);

		        } else
		            alert('亲，到底啦，在点就罢工啦！');
		    },
		    Insert: function(ljq,rjq) {
		        var rows = ljq.datagrid('getSelected');
		        if(rows) {
		            var currRows = rjq.datagrid('getRows');
		           // var hasBtns = Enumerable.from(currRows).where("x=>x.KeyId==" + rows.KeyId).select("$").toArray();
		            var hasBtns = hasRole(rows.id,currRows);
		            if (!hasBtns) {
		                rjq.datagrid('appendRow', rows);
		            }
		        } else {
		            alert('请选择按钮。');
		            return false;
		        }
		    },
		    Remove: function (jq) {
		        var rowindex = jq.datagrid('getSelectedIndex');
		        if(rowindex >-1)
		            jq.datagrid('deleteRow', rowindex);
		        return false;
		    }
		}
	
</script>
</body>
</html>
