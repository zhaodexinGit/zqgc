<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<link rel="stylesheet" href="${ctx}/source/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx}/source/css/dialog.css" />
<link rel="stylesheet" href="${ctx}/source/css/widget.css" />
<link href="${ctx}/source/plugins/ztree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
<script src="${ctx}/source/js/jquery-1.7.2.min.js"></script>
<script src="${ctx}/source/js/jquery-ui-dialog.min.js"></script>
<script src="${ctx}/source/plugins/ztree/js/jquery.ztree.all-3.5.min.js" type="text/javascript"></script>
<style>
   ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:260px;height:320px;overflow-y:scroll;overflow-x:auto;}
</style>
</head>
<body style="background: none repeat scroll 0 0 #EEEEEE;">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"> <i class="icon-th-list"></i>
							</span>
							<h5>菜单信息</h5>
						</div>
						<div class="widget-content nopadding">
						     <table width="100%" border="0" style="margin-left:20px">
					            <tr>
					              <td>
								  <div >
								   <table cellspacing="0" height="100%" cellpadding="0" class="mainTab">
					                <tbody>
					                  <tr class="mainTab-bg">
					                    <td>
							         	  <ul id="menuTree" class="ztree"></ul>
							         	</td>
					                  </tr>
					                </tbody>
					              </table>
								  </div>
								  </td>
								   </tr>
					          </table>
							<div class="form-actions">
								<button style="margin-left:30px" type="button" class="btn btn-primary" onClick="toUrl('${ctx}/sys/sysMenu/toAddSysMenu.htm')">新增</button>
								<button type="button" class="btn btn-primary" onClick="updateMenu()">修改</button>
								<button type="button" class="btn btn-primary" onClick="deleteMenu()">删除</button>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
</body>
<script>
var selectedNode=null;
var moveNode=null;
$(document).ready(function(){
	$.fn.zTree.init($("#menuTree"), setting, zNodes);
});
var setting = {
		edit: {
			drag: {
				autoExpandTrigger: true,
				prev: dropPrev,
				inner: dropInner,
				next: dropNext
			},
			enable: true,
			showRemoveBtn: false,
			showRenameBtn: false
		},
		data: {
			simpleData: {
				enable: true
			}
		},
		callback: {
			beforeClick: beforeClick,
			onClick: onClick,
			beforeDrag: beforeDrag,
			beforeDrop: beforeDrop,
			beforeDragOpen: beforeDragOpen,
			onDrag: onDrag,
			onDrop: onDrop,
			onExpand: onExpand,
			onMouseDown: onMouseDown
		}
		
	};
	
function dropPrev(treeId, nodes, targetNode) {
	//alert(targetNode.isFirstNode);
	return true;
}
function dropInner(treeId, nodes, targetNode,moveType) {
	return false;
}
function dropNext(treeId, nodes, targetNode) {
	var pNode = targetNode.getParentNode();
	if(targetNode.menuLevel==2 && selectedNode.menuLevel==1)
	{
		return false;
	}
	
	if (pNode && pNode.dropInner === false) {
		return false;
	} else {
		for (var i=0,l=curDragNodes.length; i<l; i++) {
			var curPNode = curDragNodes[i].getParentNode();
			if (curPNode && curPNode !== targetNode.getParentNode() && curPNode.childOuter === false) {
				return false;
			}
		}
	}
	return true;
}

	
	
var log, className = "dark", curDragNodes, autoExpandNode;
function beforeDrag(treeId, treeNodes) {
	className = (className === "dark" ? "":"dark");
	//alert("[ "+getTime()+" beforeDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
	for (var i=0,l=treeNodes.length; i<l; i++) {
		if (treeNodes[i].drag === false) {
			curDragNodes = null;
			return false;
		} else if (treeNodes[i].parentTId && treeNodes[i].getParentNode().childDrag === false) {
			curDragNodes = null;
			return false;
		}
	}
	curDragNodes = treeNodes;
	return true;
}
function beforeDragOpen(treeId, treeNode) {
	autoExpandNode = treeNode;
	return true;
}
function beforeDrop(treeId, treeNodes, targetNode, moveType, isCopy) {
	className = (className === "dark" ? "":"dark");
	//alert("[ "+getTime()+" beforeDrop ]&nbsp;&nbsp;&nbsp;&nbsp; moveType:" + moveType);
	//alert("target: " + (targetNode ? targetNode.name : "root") + "  -- is "+ (isCopy==null? "cancel" : isCopy ? "copy" : "move"));
	return true;
}
function onDrag(event, treeId, treeNodes) {
	className = (className === "dark" ? "":"dark");
	//alert("[ "+getTime()+" onDrag ]&nbsp;&nbsp;&nbsp;&nbsp; drag: " + treeNodes.length + " nodes." );
}
function onDrop(event, treeId, treeNodes, targetNode, moveType, isCopy) {
	className = (className === "dark" ? "":"dark");
	if(targetNode!=null)
	{
		moveNode=targetNode;
		moveMenu();
		//alert("1"+targetNode.name);
	}
	
}
function onExpand(event, treeId, treeNode) {
	if (treeNode === autoExpandNode) {
		className = (className === "dark" ? "":"dark");
		//alert("[ "+getTime()+" onExpand ]&nbsp;&nbsp;&nbsp;&nbsp;" + treeNode.name);
	}
}

function setTrigger() {
	var zTree = $.fn.zTree.getZTreeObj("treeDemo");
	zTree.setting.edit.drag.autoExpandTrigger = $("#callbackTrigger").attr("checked");
}
	
function beforeClick(treeId, treeNode, clickFlag) {
	return (treeNode.click != false);
}
function onClick(event, treeId, treeNode, clickFlag) {
	selectedNode=treeNode;
}	
function onMouseDown(event, treeId, treeNode) {
	selectedNode=treeNode;
}
	var zNodes = ${treeData}; 



function toUrl(url){
	window.location.href=url;
}
function deleteMenu(){
	if(selectedNode==null){
		 alert("请选中要删除的菜单节点");
	}else if(selectedNode.children!=undefined && selectedNode.children.length!=0){
		 alert("删除父节点前请先删除其下的子节点");
	}
	else
	{
	     $.ajax({
			   type: "POST",
			   url: "${ctx}/sys/sysMenu/deleteSysMenu.htm",
			   cache:false,
			   data: {
				   'id':selectedNode.id
			   },
			   success: function(msg){
				 msg = decodeURI(msg);
			     if('success'==msg){
			    	 alert("删除成功!");
					 window.location.href='${ctx}/sys/sysMenu/sysMenuList.htm';
			     }else{
			    	alert("要先删除此菜单下的子菜单!");
			     }
			   }
			});
	}
}

function moveMenu(){
    $.ajax({
	   type: "POST",
	   url: "${ctx}/sys/sysMenu/menuMove.htm",
	   cache:false,
	   data: {
		   'menuId':selectedNode.id,
		   'moveId':moveNode.id,
		   'orderNum1':selectedNode.orderNum,
		   'orderNum2':moveNode.orderNum
	   },
	   success: function(msg){
		 msg = decodeURI(msg);
		 var temp=moveNode.orderNum;
		 moveNode.orderNum=selectedNode.orderNum;
		 selectedNode.orderNum=temp;
		// alert(selectedNode.id);
			 
	     if('success'==msg){
	    	 alert("移动成功!");
	     }else{
	    	alert(msg);
	     }
	   }
	});
	
}


function updateMenu(){
	if(selectedNode==null){
		 alert("请选中要修改的菜单节点");
	}else{
		toUrl('${ctx}/sys/sysMenu/toUpdateSysMenu.htm?id='+selectedNode.id);
	    
	}
}

function expandNode(type) {
	var zTree = $.fn.zTree.getZTreeObj("menuTree"),
	nodes = zTree.getSelectedNodes();
	if (type.indexOf("All")<0 && nodes.length == 0) {
		alert("请先选择一个父节点");
	}

	if (type == "expandAll") {
		zTree.expandAll(true);
	} else if (type == "collapseAll") {
		zTree.expandAll(false);
	} else {
		var callbackFlag = $("#callbackTrigger").attr("checked");
		for (var i=0, l=nodes.length; i<l; i++) {
			zTree.setting.view.fontCss = {};
			if (type == "expand") {
				zTree.expandNode(nodes[i], true, null, null, callbackFlag);
			} else if (type == "collapse") {
				zTree.expandNode(nodes[i], false, null, null, callbackFlag);
			} else if (type == "toggle") {
				zTree.expandNode(nodes[i], null, null, null, callbackFlag);
			} else if (type == "expandSon") {
				zTree.expandNode(nodes[i], true, true, null, callbackFlag);
			} else if (type == "collapseSon") {
				zTree.expandNode(nodes[i], false, true, null, callbackFlag);
			}
		}
	}
}

</script>
</html>
