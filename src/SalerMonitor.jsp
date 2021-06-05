<%@page import="dao.ComDao"%>
<%@page import="entity.Com"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
</head>
<body>
	<%
		int count=0;
		String idsaler = (String) application.getAttribute("idsaler");
		String charge = (String) application.getAttribute("charge");
		ArrayList<Com> salercomlist=ComDao.selectByBrand(charge);
		application.setAttribute("salercomlist", salercomlist);
		%>
	<h1><a href="SalerHome.jsp">销售首页</a></h1>

            <h3><span >[<%=idsaler%>]</span><span><a href="./SalerQuit">[退出登录]</a></span></h3>
            <h3>负责的品牌：<span >[<%=charge%>]</span></h3>
            <h4>商品监控</h4>
<p></p>
 <table border="1">
<tr>
<th>编号</th>
<th>名称</th>
<th>库存</th>
<th>进货</th>
</tr>
<c:forEach var="i" items="${salercomlist}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>									
<td>${i.name}</td>
<td>${i.stock}</td>
<td><a href="./SalerAddStock?salercomid=${i.id}">进货</a> 
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>