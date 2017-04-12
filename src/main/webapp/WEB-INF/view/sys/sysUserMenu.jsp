<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>给用户授权</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/source/plugins/easyui/themes/bootstrap/easyui.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/source/css/icon.css" />
<link rel="stylesheet" href="${ctx}/source/plugins/alertify/alertify.css"/>
<link rel="stylesheet" href="${ctx}/source/plugins/qqmsg/msgbox.css" rel="stylesheet" />
<script src="${ctx}/source/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx}/source/js/xiucai.js"></script>
<script type="text/javascript" src="${ctx}/source/plugins/alertify/alertify.js"></script>
<script type="text/javascript" src="${ctx}/source/plugins/qqmsg/jQuery.qqmsg.js"></script>
    <script type="text/javascript">
        if (top.location == self.location) {
            top.location = '/';
        }
        var PAGESIZE = 10; //每页显示数据条数
        $(function() {
            $('#toolbar,.toolbar').css({
                height:'28px',
                padding:'3px 2px 0 10px',
                'padding-bottom': '0px'
            });
        });
    </script>
</head>
<body onselectstart="return false;" style="height:100%;width:100%;border:none; overflow:hidden;">
    <form method="post" id="searchForm">
    <div style="padding:2px; margin:0px ">
    <div id="layout">
        <div region="west" style="width:50%;" split="false" >
                <div id="userToolbar" class="toolbar" style="background:#efefef;border-bottom:1px solid #ccc">
                                                  登录名：<input name="userName" style="width: 100px;" class="txt03" />
                                                       角色：
		                   <input class="easyui-combobox" id="roleid"
									name="roleid"
									url="${ctx}/sys/sysRole/allRole.htm" 
									valueField="id" 
									textField="roleName"
									data-options="panelHeight:'auto'"/>
                   &nbsp;&nbsp;
                   <a id="a_search"  href="javascript:;"  plain="true" class="easyui-linkbutton" icon="icon-search" title="查询">查询</a>
                   <a id="a_authorize" href="javascript:;" plain="true" class="easyui-linkbutton" icon="icon-group_gear" title="授权">授权</a>
                </div>
                <table id="userGrid" border="false"></table>
        </div>
        <div region="center" border="false" style="overflow: hidden;" >
           <table id="treeGrid"></table>
        </div>
    </div>
    </div>
    </form>
 <script>
    alertify.set({ delay: 3000 });
	alertify.warning = alertify.extend('warning');
	var msg = {
	    ok: function(message) {
	        alertify.success(message);
	    },
	    error: function(message) {
	        alertify.error(message);
	    },
	    warning: function(message) {
	        alertify.warning(message);
	    }
	};
	var serializeObject = function(form) {
		var o = {};
		$.each(form.serializeArray(), function(index) {
			if (this['value'] != undefined && this['value'].length > 0) {// 如果表单项的值非空，才进行序列化操作
				if (o[this['name']]) {
					o[this['name']] = o[this['name']] + "," + this['value'];
				} else {
					o[this['name']] = this['value'];
				}
			}
		});
		return o;
	};
 $(function () {
     var size = { width: $(window).width(), height: $(window).height() };
     mylayout.init(size);
     $(window).resize(function () {
         size = { width: $(window).width(), height: $(window).height() };
         mylayout.resize(size);
     });
     
     autoResize({ dataGrid: '#userGrid', gridType: 'datagrid', callback: userGrid.bind, height: 0,notAuto:true });
     autoResize({ dataGrid: '#treeGrid', gridType: 'treegrid', callback: treeGrid.databind, height: 0,notAuto:true });
     
     $('#a_search').click(function () {
	    	$('#userGrid').datagrid('load',serializeObject($('#searchForm')));
	  });
     $('#a_authorize').click(function () {
    	  var users = userGrid.getSelectedRow();
		  if (users.length==0) {
	            msg.warning('请选择帐号哦。');
	            return false;
	      }
		  var menus=treeGrid.selected();
		  if (menus.length==0) {
	            msg.warning('请选择要授权的菜单哦。');
	            return false;
	      }
		 
		  var userIds="",menuIds="";
		  $.each(users, function(i,user){
			  userIds+=user.id+",";
		  });
		  $.each(menus, function(i,menu){
		       menuIds+=menu.id+",";
		  });
		  
		   $.ajaxtext("${ctx}/sys/sysUserMenu/powerUserMemu.htm", {
			   'userIds':userIds.substring(0,userIds.length-1),
			   'menuIds':menuIds.substring(0,menuIds.length-1)
		   },
           function(data) {
    		 if('success'==data){
    			 msg.ok('授权成功!');
   		     }else{
   		    	top.$.messager.alert("系统提示","授权失败!", "warning");
   		     }
         });
		  
	  });
     
     
     /**
 	 * 扩展树表格级联勾选方法：
 	 * @param {Object} container
 	 * @param {Object} options
 	 * @return {TypeName} 
 	 */
 	$.extend($.fn.treegrid.methods,{
 		/**
 		 * 级联选择
 	     * @param {Object} target
 	     * @param {Object} param 
 		 *		param包括两个参数:
 	     *			id:勾选的节点ID
 	     *			deepCascade:是否深度级联
 	     * @return {TypeName} 
 		 */
 		cascadeCheck : function(target,param){
 			var opts = $.data(target[0], "treegrid").options;
 			if(opts.singleSelect)
 				return;
 			var idField = opts.idField;//这里的idField其实就是API里方法的id参数
 			var status = false;//用来标记当前节点的状态，true:勾选，false:未勾选
 			var selectNodes = $(target).treegrid('getSelections');//获取当前选中项
 			for(var i=0;i<selectNodes.length;i++){
 				if(selectNodes[i][idField]==param.id)
 					status = true;
 			}
 			//级联选择父节点
 			selectParent(target[0],param.id,idField,status);
 			selectChildren(target[0],param.id,idField,param.deepCascade,status);
 			/**
 			 * 级联选择父节点
 			 * @param {Object} target
 			 * @param {Object} id 节点ID
 			 * @param {Object} status 节点状态，true:勾选，false:未勾选
 			 * @return {TypeName} 
 			 */
 			function selectParent(target,id,idField,status){
 				var parent = $(target).treegrid('getParent',id);
 				if(parent){
 					var parentId = parent[idField];
 					if(status)
 						$(target).treegrid('select',parentId);
 					else
 						$(target).treegrid('unselect',parentId);
 					selectParent(target,parentId,idField,status);
 				}
 			}
 			/**
 			 * 级联选择子节点
 			 * @param {Object} target
 			 * @param {Object} id 节点ID
 			 * @param {Object} deepCascade 是否深度级联
 			 * @param {Object} status 节点状态，true:勾选，false:未勾选
 			 * @return {TypeName} 
 			 */
 			function selectChildren(target,id,idField,deepCascade,status){
 				//深度级联时先展开节点
 				if(!status&&deepCascade)
 					$(target).treegrid('expand',id);
 				//根据ID获取下层孩子节点
 				var children = $(target).treegrid('getChildren',id);
 				for(var i=0;i<children.length;i++){
 					var childId = children[i][idField];
 					if(status)
 						$(target).treegrid('select',childId);
 					else
 						$(target).treegrid('unselect',childId);
 					selectChildren(target,childId,idField,deepCascade,status);//递归选择子节点
 				}
 			}
 		}
 	});
 });

 var mylayout = {
     init: function (size) {
         $('#layout').layout();
         $('#layout').layout("resize",{width:size.width - 4,height:size.height - 4});
         var center = $('#layout').layout('panel', 'center');
         center.panel({
             onResize: function (w, h) {
                 $('#userGrid').datagrid('resize', { width: w-5, height: h-5 });
                 $('#treeGrid').datagrid('resize', { width: w, height: h });
             }
         });
     },
     resize: function (size) {
         mylayout.init(size);
         $('#layout').layout('resize');
     }
 };
 
	var userGrid = {
	    bind: function (winSize) {
	        $('#userGrid').datagrid({
	            url: "${ctx}/sys/user/getUserList.htm" ,
	            toolbar:'#userToolbar',
	            title: "授权用户",
	            iconCls: 'icon-users',
	            width: winSize.width/2-2,
	            height: winSize.height-6,
	            nowrap: false, //折行
	            rownumbers: true, //行号
	            striped: true, //隔行变色
	            idField: 'id',//主键
	            singleSelect: false, //单选
	            frozenColumns: [[]],
	            columns: [[
	                {field:'id',checkbox:true},
	                { title:'用户名',field:'userName',width:160},
	                { title:'角色',field:'roles',width:160}
	            ]],
	            pagination: true,
	            pageSize: PAGESIZE,
	            pageList:[10,20,40,50,100]
	        });
	    },
	    getSelectedRow: function () {
	        return $('#userGrid').datagrid('getSelections');
	    },
	    reload:function(){
	        $('#userGrid').datagrid('clearSelections').datagrid('reload', { filter: '' });
	    }
	};
 

	var treeGrid = {
		    databind: function (winSize) {
		       $('#treeGrid').treegrid({
		           // toolbar: '#toolbar',
		            width: winSize.width/2+2,
	                height: winSize.height-4,
		            url: '${ctx}/sys/sysMenu/listMenu.htm',
		            idField: 'id',
		            treeField: 'text',
		            title: '选择菜单授权',
		            iconCls: 'icon-nav',
		            nowrap: false,
		            rownumbers: true,
		            animate: true,
		           // lines:true,
		            collapsible: false,
		            singleSelect: false, //单选
		            onClickRow:function(row){  
	                    //级联选择  
	                    $(this).treegrid('cascadeCheck',{  
	                        id:row.id, //节点ID  
	                        deepCascade:true //深度级联  
	                    });  
	                },
					frozenColumns: [[]],
		            columns: [[
		                {field:'id',checkbox:true},
		                { title: '菜单名称', field: 'text', width: 200 }
		            ]]
		        });
		    },
		    reload: function () {
		    	$('#treeGrid').treegrid('reload');
		    },
		    selected: function () {
		    	 return $('#treeGrid').treegrid('getSelections');
		    }
		};
 </script>
</body>
</html>