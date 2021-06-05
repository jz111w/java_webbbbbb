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
<title>商品销售统计</title>
</head>
<body>
<%
int count=0;
ArrayList<Ord> ordli1=OrdDao.showAll();
ArrayList<String> ordli2=OrdDao.showName();
ArrayList<Statistics> ordli3=new ArrayList<Statistics>();
ArrayList<String> ordli4=new ArrayList<String>();
for(String i:ordli2){
	if(!ordli4.contains(i)){
		ordli3.add( new Statistics(i,0));
		ordli4.add(i);
	}
		
}
for(Ord i: ordli1){
	 for (int k = 0; k < ordli3.size(); k++) {
		 if(i.getComname().equals( ordli3.get(k).getObj())){
			 ordli3.get(k).setNum( ordli3.get(k).getNum()+1);
		 }
     }
}
application.setAttribute("ordli3", ordli3);


%>
	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            <h4>商品销售统计</h4>
<p></p>

 <table border="1">
<tr>
<th>商品名称</th>
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