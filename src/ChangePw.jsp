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
		String id = (String) application.getAttribute("email");
	%>
<form action="./ChangePw"method="post">
<p>修改密码</p>
<p><input type="text" name="pw"  placeholder="请输入旧密码"></p>
<p><input type="text" name="pw1"  placeholder="请输入新密码"></p>
<p><input type="text" name="pw2"  placeholder="请确认密码"></p>
<p><input type="submit" name="" value="修改"></p>
</form>
</body>
</html>