<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>浏览器版本过低</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}"></c:set>
    <link rel="stylesheet" type="text/css" href="${ctx}/source/css/bn-browser.css">
</head>
<body id="banana">
<div id="banana-h" class="browser">
    <div class="b-ku">
        <div class="b-ku-img"></div>
    </div>
    <div class="b-word">
       您的浏览器版本过低，建议您对浏览器进行升级！
    </div>
    <div class="b-down">
         <div class="b-down-img"></div>
    </div>
    <div class="b-browser">
        <div class="browser-div">
          <div class="br-div">
              <a target="_blank" href="http://windows.microsoft.com/zh-cn/internet-explorer/download-ie" class="browser-ie"></a>
              <div class="br-word">Internet Explorer 8+</div>
          </div>
            <div class="br-div">
                <a target="_blank" href="http://www.google.cn/intl/zh-CN/chrome/browser/" class="browser-chrome"></a>
                <div class="br-word">谷歌浏览器</div>
            </div>
            <div class="br-div">
                <a target="_blank" href="http://www.firefox.com.cn/download/" class="browser-fireFox"></a>
                <div class="br-word">FireFox</div>
            </div>
        </div>
    </div>
</div>
</body></html>