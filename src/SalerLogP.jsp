<%@page import="entity.LogP"%>
<%@page import="dao.LogPDao"%>
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
		ArrayList<LogP> logplist=LogPDao.selectByBrand(charge);
		application.setAttribute("logplist", logplist);
		%>
	<h1><a href="SalerHome.jsp">销售首页</a></h1>

            <h3><span >[<%=idsaler%>]</span><span><a href="./SalerQuit">[退出登录]</a></span></h3>
            <h3>负责的品牌：<span >[<%=charge%>]</span></h3>
            <h4>商品管理——购买商品日志</h4>
<p></p>
 <table border="1">
<tr>
<th>编号</th>
<th>操作时间</th>
<th>用户邮箱</th>
<th>商品编号</th>
<th>商品品牌</th>
<th>商品名称</th>
</tr>
<c:forEach var="i" items="${logplist}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>
<td>${i.time}</td>
<td>${i.email}</td>
<td>${i.comid}</td>	
<td>${i.combrand}</td>									
<td>${i.comname}</td>

</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>