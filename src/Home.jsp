<%@page import="entity.Com"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ComDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>主页</title>
</head>
<body>
<div>
 <h1 ><a href="#">主页</a></h1>
 	<%
 	int count=0;
	String a = (String) application.getAttribute("email");
	String name=a;
	if(a.equals("")){name="tourist";}
	ArrayList<Com> comlist=ComDao.showAll();
	application.setAttribute("comlist", comlist);
	
	%>
	 <h3><span >[<%=name%>]</span><span><a href="./Quit">[退出登录]</a></span></h3>
<p><a href="Login.jsp" >登录</a>  <a href="Register.jsp" >注册</a>  <a href="PCenter.jsp" >个人中心</a> <a href="./ShowCart" >购物车</a></p>
</div>
<div>

<form  action="./QueryCom" method="post">
 <p><input type="text" name="query"  placeholder="请输入查询"></p>
 <p><input type="submit" name="" value="查询商品"></p>
</form>
<h1>全部商品</h1>
<table border="1">
<tr>
<th>品牌</th>
<th>名称</th>
<th>价格</th>
<th>剩余</th>
<th>查看</th>
<th>购物车</th>
</tr>
<c:forEach var="i" items="${comlist}" >
<tr>
<%
count += 1;
%>
<td>${i.brand}</td>									
<td>${i.name}</td>
<td>${i.price}</td>
<td>${i.stock}</td>
<td><a href="./ComDet?id=${i.id}">详细介绍</a> 
<td><a href="./AddCartOne?id=${i.id}">添加购物车</a></td>
</tr>
</c:forEach>
</table>
共条<%=count%>记录
</div>
</body>
</html>