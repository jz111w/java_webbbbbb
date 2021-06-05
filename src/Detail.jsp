<%@page import="entity.Com"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品介绍</title>
</head>
<body>
 <h1 ><a href="Home.jsp">主页</a></h1>
<%
String a = (String) application.getAttribute("email");
application.setAttribute("email", a);
Com com = (Com) application.getAttribute("com");
String id=com.getId();
String brand=com.getBrand();
String name=com.getName();
String price=com.getPrice();
String stock=com.getStock();
%>
<h3>商品编号</h3>
<p><%=id %></p>
<h3>商品品牌</h3><p><%=brand %></p>
<h3>商品名称</h3><p><%=name %></p>
<h3>商品价格</h3><p><%=price %></p>
<h3>商品库存</h3><p><%=stock %></p>
<h3>商品介绍</h3>
<h5>****************************</h5>
<h5>****************************</h5>
<h5>****************************</h5>
<h5>****************************</h5>
<p><a href="Home.jsp">主页</a></p>
</body>
</html>