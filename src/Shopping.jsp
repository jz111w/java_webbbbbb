<%@page import="entity.Com"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
	<%
		String id = (String) application.getAttribute("email");
	String name=id;
	if(id.equals("")){name="tourist";}
	
	%>
	<h1><a href="Home.jsp">首页</a></h1>

            <h3><span >[<%=name%>]</span><span><a href="./Quit">[退出登录]</a></span></h3>
            <h4>购物车</h4>
</body>
</html>