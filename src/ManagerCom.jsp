<%@page import="dao.OrdDao"%>
<%@page import="entity.Ord"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品销售记录</title>
</head>
<body>
<%
int count=0;
ArrayList<Ord> ordli=OrdDao.showAll();
application.setAttribute("ordli", ordli);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>商品销售记录</h4>
<p></p>

 <table border="1">
<tr>
<th>编号</th>
<th>操作时间</th>
<th>用户邮箱</th>
<th>商品编号</th>
<th>商品品牌</th>
<th>商品名称</th>
<th>商品价格</th>
</tr>
<c:forEach var="i" items="${ordli}" >
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
<td>${i.price}</td>								
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>