<%@page import="dao.UserDao"%>
<%@page import="entity.User"%>
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
<title>用户列表</title>
</head>
<body>
<%
int count=0;
ArrayList<User> userlist=UserDao.showAll();
application.setAttribute("userlist", userlist);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>用户列表</h4>
<p></p>

 <table border="1">
<tr>
<th>用户邮箱</th>
<th>用户口令</th>
<th>用户类型</th>
</tr>
<c:forEach var="i" items="${userlist}" >
<tr>
<%
count += 1;
%>
<td>${i.email}</td>
<td>${i.pw}</td>	
<td>
<c:choose>
<c:when test="${i.type=='1' }">普通用户</c:when>
<c:when test="${i.type=='2' }">游客</c:when>
</c:choose>
</td>							
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>