<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>project</title>
<c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="${ctx}/source/css/bootstrap.min.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
.btn-large{
-webkit-animation:bounceInDown 1s .2s ease both;
-moz-animation:bounceInDown 1s .2s ease both;}
@-webkit-keyframes bounceInDown{
0%{opacity:0;
-webkit-transform:translateY(-2000px)}
60%{opacity:1;
-webkit-transform:translateY(30px)}
80%{-webkit-transform:translateY(-10px)}
100%{-webkit-transform:translateY(0)}
}
@-moz-keyframes bounceInDown{
0%{opacity:0;
-moz-transform:translateY(-2000px)}
60%{opacity:1;
-moz-transform:translateY(30px)}
80%{-moz-transform:translateY(-10px)}
100%{-moz-transform:translateY(0)}
}
#main {position: absolute;width:780px;height:200px;left:50%;top:50%; margin-left:-380px;margin-top:-100px;} 
</style>
</head>
<body>
<div id="main">
 <button onclick="javascript:parent.openMenu(1);" class="btn btn-success btn-large" style="height:120px;width:120px" >基础设置</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button onclick="javascript:parent.openMenu(0);" class="btn btn-success btn-large" style="height:120px;width:120px" >系统模块1</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button onclick="javascript:parent.openMenu(0);" class="btn btn-success btn-large" style="height:120px;width:120px" >系统模块2</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button onclick="javascript:parent.openMenu(0);"class="btn btn-success btn-large" style="height:120px;width:120px" >系统模块3</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <button onclick="javascript:parent.openMenu(0);"class="btn btn-success btn-large" style="height:120px;width:120px" >系统模块4</button>
</div>
</body>
</html>
