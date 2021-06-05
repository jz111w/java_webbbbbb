<%@page import="entity.Saler"%>
<%@page import="dao.SalerDao"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>销售账号管理</title>
</head>
<body>
<%
int count=0;
ArrayList<Saler> sList=SalerDao.showAll();
application.setAttribute("sList", sList);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>销售账号管理</h4>
<p></p>
<form action="ManagerAddSaler.jsp" method="post">
<input  name="sub" value="添加销售"type="submit">
</form>
<p></p>
 <table border="1">
<tr>
<th>编号</th>
<th>销售口令</th>
<th>管理品牌</th>
<th>删除</th>
<th>重置口令</th>
</tr>
<c:forEach var="i" items="${sList}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>
<td>${i.pw}</td>
<td>${i.charge}</td>
<td><a href="./ManagerDelSaler?id=${i.id}">删除</a></td>
<td><a href="./ManagerSalerPw?id=${i.id}">重置口令</a></td>
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>