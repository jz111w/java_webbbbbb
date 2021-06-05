<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<%
String a="";
application.setAttribute("email", a);
%>
<form action="./Login" method="post"><h1><a href="Home.jsp">首页</a></h1>
        <p>用户登录</p>
        <p><input type="text" name="email"  placeholder="请输入邮箱"></p>
        <p><input type="text" name="pw"  placeholder="请输入密码"></p>
        <p><input type="submit" name="" value="登录"></p>
        <p><a href="Home.jsp"><span></span>游客登录</a></p>
        <p><a href="ManagerLogin.jsp"><span></span>管理员登录</a></p>
        <p><a href="SalerLogin.jsp"><span></span>销售登录</a></p>
        <p ><a href="Register.jsp"><span></span>注册</a></p>
       </form>
</body>
</html>