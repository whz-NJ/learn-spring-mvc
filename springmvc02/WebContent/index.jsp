<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert Title here</title>
</head>
<body>
<form action="demo7" method="post">
<%-- <form action="demo6" method="post">
        <form action="demo5" method="post">
        <input type="text" name="name" />
        <input type="text" name="age" />
        <input type="checkbox" name="hover" value="学习">
        <input type="checkbox" name="hover" value="写代码">
        <input type="checkbox" name="hover" value="看视频">
        <input type="checkbox" name="hover" value="看笔记">
    <input type="text" name="peo.name" />
    <input type="text" name="peo.age" /> --%>
    <input type="text" name="peo[0].name"  />
    <input type="text"name="peo[0].age"  />
    <input type="text" name="peo[1].name"  />
    <input type="text"name="peo[1].age"  />
    <input type="submit" name="提交" />
</form>

<%--<a href="demo8?age=123&name=abc">跳转</a>--%>
<a href="demo8/123/abc">跳转</a>
<a href="demo9/123/abc">跳转</a>
</body>
</html>