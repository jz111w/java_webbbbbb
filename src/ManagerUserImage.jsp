<%@page import="operation.UserImage"%>
<%@page import="entity.Userdata"%>
<%@page import="entity.Image"%>
<%@page import="dao.UserdataDao"%>
<%@page import="dao.UserDao"%>
<%@page import="entity.LogP"%>
<%@page import="dao.LogBDao"%>
<%@page import="entity.LogB"%>
<%@page import="entity.Statistics"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户偏好</title>
</head>
<body>
<%
int count=0;
ArrayList<Image> images=UserImage.getUserImage();
application.setAttribute("images", images);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>用户偏好</h4>
<p></p>

 <table border="1">
<tr>
<th>用户邮箱</th>
<th>偏好品牌</th>
</tr>
<c:forEach var="i" items="${images}" >
<tr>
<%
count += 1;
%>
<td>${i.obj1}</td>
<td>${i.obj2}</td>							
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>