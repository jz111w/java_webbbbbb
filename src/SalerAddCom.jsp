<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加商品</title>
</head>
<body>
<h1><a href="SalerHome.jsp">销售首页</a></h1>
<%
String idsaler = (String) application.getAttribute("idsaler");
String charge = (String) application.getAttribute("charge");
application.setAttribute("salerbrand", charge);
%>
<form action="./SalerAddCom?salerbrand=${charge }" method="post">
<h2>添加商品</h2>
<p>商品编号：<input type="text" name="salerid"  placeholder="请输入商品编号"></p>
品  &nbsp; &nbsp; &nbsp;   牌：<%=charge %>
<p>商品名称：<input type="text" name="salername"  placeholder="请输入商品名称"></p>
<p>商品价格：<input type="text" name="salerprice"  placeholder="请输入商品价格"></p>
<p>商品库存：<input type="text" name="salerstock"  placeholder="请输入商品库存"></p>
<p><input type="submit" name="" value="添加"></p>
</form>
<h2><a href="SalerCom.jsp">商品管理</a></h2>
</body>
</html>