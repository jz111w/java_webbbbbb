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
<%
Com com = (Com) application.getAttribute("salerstockcom");
application.setAttribute("stockid", com.getId());
String id=com.getId();
String name=com.getName();
String stock=com.getStock();
%>
<h3>商品编号</h3>
<p><%=id %></p>
<h3>商品名称</h3><p><%=name %></p>
<h3>商品库存</h3><p><%=stock %></p>
<h2>进货数量：</h2>
<form action="./SalerAddStockTwo" method="post">
<p><input type="text" name="num"  placeholder="请输入进货数量"></p>
<p><input type="submit" name="" value="进货"></p>
</form>

</body>
</html>