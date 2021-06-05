<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改密码</title>
</head>
<body>
	<%
	String idsaler = (String) application.getAttribute("idsaler");
	%>
<form action="./SalerChangePw"method="post">
<p>销售口令修改</p>
<p><input type="text" name="pw"  placeholder="请输入旧密码"></p>
<p><input type="text" name="pw1"  placeholder="请输入新密码"></p>
<p><input type="text" name="pw2"  placeholder="请确认密码"></p>
<p><input type="submit" name="" value="修改"></p>
</form>
</body>
</html>