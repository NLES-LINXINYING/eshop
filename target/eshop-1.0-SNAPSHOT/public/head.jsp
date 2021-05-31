<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 赋值给变量shop，方便书写 -->
<c:set var="shop" value="${pageContext.request.contextPath}"/>
<title>eshop商城</title>

<!-- 前端页面的样式 -->
<link rel="stylesheet" href="${shop}/css/public.css" type="text/css"/>
<link rel="stylesheet" href="${shop}/css/style.css" type="text/css"/>

<!-- easyui的环境 -->
<link rel="stylesheet" href="${shop}/static/jquery-easyui-1.7.0/themes/icon.css" type="text/css"></link>
<link rel="stylesheet" href="${shop}/static/jquery-easyui-1.7.0/themes/default/easyui.css" type="text/css"></link>
<script type="text/javascript" src="${shop}/static/jquery-easyui-1.7.0/jquery.min.js"></script>
<script type="text/javascript" src="${shop}/static/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${shop}/static/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
