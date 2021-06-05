<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码成功</title>
</head>
<%
String id = (String) application.getAttribute("email");
application.setAttribute("email", id);
%>
<body>
<div align="center">
<p>修改成功</p>
<a href="PCenter.jsp">个人中心</a>
</div>
</body>
</html>