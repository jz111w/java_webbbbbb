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
<title>商品销售监控</title>
</head>
<body>
<%
int count=0;
ArrayList<Com> warningList=ComDao.showAll();
ArrayList<Com> warningList2=new ArrayList<Com>();
for(Com i:warningList){
	if(Integer.parseInt(i.getStock())<=20){
		warningList2.add(i);
	}
}
application.setAttribute("warningList2", warningList2);
%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>商品销售监控</h4>
<p></p>

 <table border="1">
<tr>
<th>编号</th>
<th>品牌</th>
<th>名称</th>
<th>库存</th>
</tr>
<c:forEach var="i" items="${warningList2}" >
<tr>
<%
count += 1;
%>
<td>${i.id}</td>	
<td>${i.brand}</td>							
<td>${i.name}</td>
<td>${i.stock}</td>							
</tr>
</c:forEach>
</table>
<p></p>
 共条<%=count%>记录              
</body>
</html>