<%@page import="entity.LogP"%>
<%@page import="dao.LogPDao"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户购买日志</title>
</head>
<body>
<%
int count=0;
ArrayList<LogP> logpList=LogPDao.showAll();
application.setAttribute("logpList", logpList);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>用户购买日志</h4>
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
<c:forEach var="i" items="${logpList}" >
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