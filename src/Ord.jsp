<%@page import="dao.OrdDao"%>
<%@page import="entity.Ord"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的订单</title>
</head>
<body>
<h1 ><a href="Home.jsp">主页</a></h1>
 	<%
 	int count=0;
	String a = (String) application.getAttribute("email");
	String name=a;
	if(a.equals("")){name="tourist";}	
	ArrayList<Ord> ordlList=OrdDao.selectByEmail(a);
	application.setAttribute("ordlList", ordlList);
	%>
	 <h3><span >[<%=name%>]</span><span><a href="./Quit">[退出登录]</a></span></h3>
<p><a href="Login.jsp" >登录</a>  <a href="Register.jsp" >注册</a>  <a href="PCenter.jsp" >个人中心</a> <a href="./ShowCart" >购物车</a></p>

<table border="1">
<tr>
<th>订单编号</th>
<th>时间</th>
<th>品牌</th>
<th>名称</th>
<th>价格</th>

</tr>
<c:forEach var="i" items="${ordlList}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>
<td>${i.time }</td>									
<td>${i.combrand}</td>
<td>${i.comname}</td>
<td>${i.price}</td>
</tr>
</c:forEach>
</table>
共条<%=count%>记录
<h1 ><a href="Home.jsp">主页</a></h1>
</body>
</html>