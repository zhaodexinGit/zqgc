<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户</title>
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
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
	<form id="userUpdateForm" action="${ctx}/sys/user/updateUser.htm" method="post">
	   <input id="id" name="id" type="hidden" />
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">

					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-pencil"></i>
							</span>
							<h5>编辑用户</h5>
						</div>
						<div class="widget-content nopadding">
							<table cellspacing="0" cellpadding="5" style="width: 96%; margin: 20px" class="bootsTable">
								<tbody>
									<tr>
										<td width="12%">用户名</td>
										<td width="36%"><input type="text" name="userName" id="userName" /></td>
										<td width="12%">手机号</td>
										<td><input type="text" name="mobile" id="mobile" /></td>
									</tr>
									<tr>
										<td>邮箱</td>
										<td><input type="text" name="email"  id="email"/></td>
										<td>状态</td>
									    <td>
										    <div style="width:133px"><span style="float:left"><label><input type="radio" name="enableStatus" checked="checked" value="1"/>启用</label></span>
											<span style="float:right"><label><input type="radio" name="enableStatus" value="0"/>禁用</label></span></div>
										</td>
										</tr>
										<tr>
									    <td>角色</td>
										<td colspan="3">
								            <input type="text" name="roles"  id="roles"  />
								            <input type="hidden" name="roleIds"  id="roleIds" value="${roles}"/>
								            &nbsp;
								            <button type="button" id="selectRole" class="btn btn-success btn-mini"><i class="icon-share icon-white"></i>选择角色</button>
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
    //修改用户
	function updateUser() {
		$('#userUpdateForm').ajaxSubmit(function(data) {
			if (data == "success") {
				alert("修改用户成功");
				window.location.href = '${ctx}/sys/user/userList.htm';
			} else {
				alert("修改用户失败!");
			}
		});
	}

	$(document).ready(function() {
		 var obj=${user};
		 //赋值
		 for(var p in obj){     
	           // p 为属性名称，obj[p]为对应属性的值  
		    if(p=="enableStatus"){
				$("input[type=radio][name=enableStatus][value="+obj[p]+"]").attr("checked",'checked'); 
				$('input[type=checkbox],input[type=radio],input[type=file]').uniform();
		    }else{
				$("input[name='"+p+"']").val(obj[p]);
			}
		 }  
		//表单校验
		$("#userUpdateForm").validate({
			rules : {
				userName : {
					required : true,
					minlength : 1,
					remote : {
						url : "${ctx}/sys/user/uniqueValueUser.htm?id="+$("#id").val(),
						type : "POST",
						dateType : "json",
						data : {
							userName : function() {
								return $("#userName").val();
							}
						}
					}
				},
				email:{
					required:true,
					email: true
				},
				mobile:{
					isMobile:true
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
				userName : {
					remote : "已存在"
				}
			},
			submitHandler : function(form) {
				updateUser();
				return false;
			}
		});
		
		$("#selectRole").click(function(){
			 var btngrid;
	           var setDialog = $.hDialog({
	               title: '选择角色',
	               width: 440, height: 400, iconCls: 'icon-group_gear', cache: false,
	               href: '${ctx}/source/html/roles.html?n=' + Math.random(),
	               onLoad:function() {
	                   btngrid = $('#left_btns').datagrid({
	                       title:'所有角色',
	                       url: '${ctx}/sys/sysRole/allRole.htm',
	                       nowrap: false, //折行
	                       fit: true,
	                       border:false,
	                       rownumbers: true, //行号
	                       striped: true, //隔行变色
	                       idField: 'id',//主键
	                       loadMsg:'加载中...',
	                       singleSelect: true, //单选
	                       frozenColumns: [[]],
	                       columns: [[
								{ title: '角色名称', field: 'roleName', width: 152}
	                       ]],
	                       onDblClickRow: function (rowIndex, rowData) {
	                           var currRows = $('#right_btns').datagrid('getRows');
	                          // var hasBtns = Enumerable.from(currRows).where("x=>x.KeyId==" + rowData.KeyId).select("$").toArray();
	                           var hasBtns = hasRole(rowData.id,currRows);
	                           if (!hasBtns){
	                               $('#right_btns').datagrid('appendRow', rowData);
	                           }
	                       },
	                       onLoadSuccess: function (data) {
	                           var arr= eval('['+$("#roleIds").val().split(",")+']');
	                          $('#right_btns').datagrid({
	                               title:'已选角色',
	                               nowrap: false, //折行
	                               fit: true,
	                               border:false,
	                               rownumbers: true, //行号
	                               striped: true, //隔行变色
	                               idField: 'id',//主键
	                               loadMsg:'加载中...',
	                               singleSelect: true, //单选
	                               frozenColumns: [[]],
	                               columns: [[
	                                   { title: '角色名称', field: 'roleName', width: 152}
	                               ]],
	                               onDblClickRow: function (rowIndex, rowData) {
	                                  $('#right_btns').datagrid('deleteRow', rowIndex);
	                               }
	                           });

	                           $.each(data.rows, function (i, n) {
	                               if ($.inArray(n.id, arr) > -1)
	                                   $('#right_btns').datagrid('appendRow', n);
	                           });
	                           
	                           //绑定移动按钮事件
	                          // top.$('#btnUp').click(function () { moveGridRow.Up(top.$('#right_btns')); });
	                           //top.$('#btnDown').click(function () { moveGridRow.Down(top.$('#right_btns')); });
	                           $('#btnRight').click(function () { moveGridRow.Insert($('#left_btns'),$('#right_btns')); });
	                           $('#btnLeft').click(function () { moveGridRow.Remove($('#right_btns')); });
	                       }
	                   });

	                   
	               },
	               submit: function() {
	                   var btns = $('#right_btns').datagrid('getRows');
	                   
	                   if(btns.length >0) {
	                	   var roles="",roleIds="";
	                	   $.each(btns, function (i, n) {
	                		   roles+=n.roleName+",";
	                		   roleIds+=n.id+",";
	                	   });
	                	   $("#roles").val(roles.substring(0,roles.length-1));
	                	   $("#roleIds").val(roleIds.substring(0,roleIds.length-1));
	                       setDialog.dialog('close');
	                   } else {
	                       alert('请选择角色啊！');
	                   }
	               }
	           });
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
	
function hasRole(roleId,currRows)
{
	var bool=false;
	$.each(currRows, function (i, n) {
      if (n.id==roleId){
          	bool= true;
       }
   });
	return bool;
}
</script>
</body>
</html>
