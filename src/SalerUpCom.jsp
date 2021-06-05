<%@page import="dao.ComDao"%>
<%@page import="entity.Com"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>
</head>
<body>
<h1><a href="SalerHome.jsp">销售首页</a></h1>
<%
String idsaler = (String) application.getAttribute("idsaler");
String charge = (String) application.getAttribute("charge");
application.setAttribute("salerbrand", charge);
String comid=request.getParameter("id");
application.setAttribute("comid", comid);
Com com1=ComDao.selectByid(comid);
application.setAttribute("idsaler", idsaler);
%>
<form action="./SalerUpCom" method="post">
<h2>修改商品</h2>
<p>商品编号：<%=comid %></p>
品  &nbsp; &nbsp; &nbsp;   牌：<%=charge %>
<p>商品名称：<input type="text" name="salername" value="<%= com1.getName() %>" ></p>
<p>商品价格：<input type="text" name="salerprice" value="<%=com1.getPrice() %>"></p>
<p>商品库存：<input type="text" name="salerstock" value="<%=com1.getStock() %>"></p>
<p><input type="submit" name="" value="修改"></p>
</form>
<h2><a href="SalerCom.jsp">商品管理</a></h2>
</body>
</html>