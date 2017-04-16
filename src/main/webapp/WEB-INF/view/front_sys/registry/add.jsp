<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增公司注册</title>
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
<script type="text/javascript" src="${ctx}/source/js/jquery.upload.js"></script>

<script type="text/javascript" src="${ctx}/source/js/xiucai.js"></script>

<!-- ckeditor -->
<script type="text/javascript" src="${ctx}/source/plugins/ckeditor_4.5.10_full/ckeditor/ckeditor.js"></script>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
	<form id="addDynamicForm" action="${ctx}/front_sys/registry/save.htm" method="post">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-plus"></i>
							</span>
							<h5>新增公司注册</h5>
						</div>
						<div class="widget-content nopadding">
							<table cellspacing="0" cellpadding="5" style="width: 96%; margin: 20px" class="bootsTable">
								<tbody>
									<tr>
										<td width="12%">标题 *</td>
										<td style='width:78%'><input type="text"style='width:70%' name="title" id="title" /></td>
									
									</tr>
									
									<tr>
										<td width="12%">图片 *</td>
										<td style='width:78%' id="imageTD"><input type="button" onClick="upload()" value="上传"></td>
									</tr>
									<tr>
										<td>内容</td>
										<td colspan="3"><textarea name="content" id="content" class="ckeditor" value='ss'></textarea></td>
									</tr>
								    
								</tbody>
							</table>
							<div class="form-actions">
								<button style="margin-left:100px" type="submit" class="btn btn-primary">保存</button>
								<button type="reset" class="btn btn-primary">重置</button>
								<button type="button" class="btn btn-primary" onClick="history.go(-1)">返回</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</form>
<script>

//上传文件
function upload(){
	// 上传方法
	$.upload({
		// 上传地址
		url: "${ctx}/front_sys/accessor/upload.htm?pbid=" +$("#pbid").val()
				+ "&businesscode=news",
		// 文件域名字
		fileName: 'uploadFile', 
		// 其他表单数据(后台无法获取)
		params: {pbid: $("#pbid").val()},
		// 上传完成后, 返回json, text
		dataType: 'json',
		// 上传之前回调,return true表示可继续上传
		onSend: function() {
			return true;
		},
		// 上传之后回调
		onComplate: function(data) {
			if(data.status){
				$("#imageTD").html("<image src='${ctx}/" + data.imageSrc + "' width='100px'/>"
						+ "<input type='hidden' name='baid' id='baid' value='" + data.baid + "'>"
//						+ "<input type='button' onClick=downloadFile('" + data.baid + "') value='下载'>"
						+ "<input type='button' onClick=deleteFile('" + data.baid + "') value='删除'>");
			}else{
				alert("上传文件失败！");
			}
		}
	});
}
	function save() {
		$('#addDynamicForm').ajaxSubmit(function(data) {
			if (data == "success") {
				alert("保存成功");
				window.location.href = '${ctx}/front_sys/registry/list.htm';
			} else {
				alert("保存失败!");
			}
		});
	}

	$(document).ready(function() {
		$('input[type=radio]').uniform();
		$('select').select2();
		$("#addDynamicForm").validate({
			rules : {
				
				title:{
					required:true,
				
				},
				introduction:{
					required:true,
				},
				
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
				title : {
					remote : "标题不能为空"
				},
				introduction: {
					remote : "类型不能为空"
				}
			},
			submitHandler : function(form) {
				$('#content').val(CKEDITOR.instances.content.getData());
				save();
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