<%@page import="entity.Statistics"%>
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
<title>品牌销售统计</title>
</head>
<body>
<%
int count=0;

ArrayList<Statistics> ordli3=OrdDao.selectCount();
application.setAttribute("ordli3", ordli3);


%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>品牌销售统计</h4>
<p></p>

 <table border="1">
<tr>
<th>商品品牌</th>
<th>销售数量</th>
</tr>
<c:forEach var="i" items="${ordli3}" >
<tr>
<%
count += 1;
%>
<td>${i.obj}</td>
<td>${i.num}</td>							
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>