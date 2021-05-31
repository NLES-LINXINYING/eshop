<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>insert title here</title>
</head>
<body>
<h1>添加新目录</h1>
<form action="/eshop/category/add" method="post">
    类型名字<input type="text" name="type"/><br/>
    是否热门<input type="text" name="hot"/><br/>
    <input type="submit" value="添加">
</form>
</body>
</html>
