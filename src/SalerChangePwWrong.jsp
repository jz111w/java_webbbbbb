<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码错误</title>
</head>
<body>
	<%
	String idsaler = (String) application.getAttribute("idsaler");
	%>
<div align="center"><h1>请重新输入密码</h1>
<a href="SalerChangePw.jsp">返回</a> </div>
</body>
</html>