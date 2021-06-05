<%@page import="dao.ManagerLogODao"%>
<%@page import="entity.ManagerLogO"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员操作日志</title>
</head>
<body>
<%
int count=0;
ArrayList<ManagerLogO> mlol=ManagerLogODao.showAll();
application.setAttribute("mlol", mlol);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>管理员操作日志</h4>
<p></p>

 <table border="1">
<tr>
<th>编号</th>
<th>操作时间</th>
<th>销售IP</th>
<th>操作名称</th>
</tr>
<c:forEach var="i" items="${mlol}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>
<td>${i.time}</td>
<td>${i.ip}</td>	
<td>${i.action}</td>									
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>