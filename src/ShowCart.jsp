<%@page import="dao.ComDao"%>
<%@page import="entity.Com"%>
<%@page import="entity.Image"%>
<%@page import="operation.UserImage"%>
<%@page import="dao.CartDao"%>
<%@page import="entity.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车</title>
</head>
<body>
 <h1 ><a href="Home.jsp">主页</a></h1>
<%
 	int count=0;
	int total=0;
	String a = (String) application.getAttribute("email");
	application.setAttribute("email", a);
	ArrayList<Cart> cartlist=CartDao.selectByEmail(a);
	application.setAttribute("cartlist", cartlist);
	
	%>
	 <h3><span >[<%=a%>]</span></h3>
<p><a href="Login.jsp" >登录</a>  <a href="Register.jsp" >注册</a>  <a href="PCenter.jsp" >个人中心</a> <a href="./ShowCart" >购物车</a></p>

<h1>全部商品</h1>
<table border="1">
<tr>
<th>品牌</th>
<th>名称</th>
<th>价格</th>
<th>查看</th>
<th>删除</th>

</tr>
<c:forEach var="i" items="${cartlist}">
<tr>
<%
count += 1;
%>
<td>${i.combrand}</td>									
<td>${i.comname}</td>
<td>${i.comprice}</td>
<td><a href="./ComDet?id=${i.comid}">详细介绍</a> 
<td><a href="./DeleteCart?id=${i.id}">删除</a></td>
</tr>
</c:forEach>
</table>
共条<%=count%>记录

<%
for (Cart i : cartlist) {
total += Integer.parseInt(i.getComprice());
}
%>
<p></p>
<form action="./BuyCart" method="post">
<input  name="sub" value="购买全部"type="submit">
</form>
<h3>总价：<%=total%></h3>
<form action="./DeleteAllCart" method="post">
<input  name="sub" value="删除全部"type="submit">
</form>
<hr>
<h2>推荐商品</h2>
<%
Image image=new Image();
ArrayList<Image> images=UserImage.getUserImage();
for(Image i:images){
	if(i.getObj1().equals(a)){
		image.setObj1(i.getObj1());
		image.setObj2(i.getObj2());
	}
}
ArrayList<Com> comlistRec=ComDao.selectByBrandRecommend(image.getObj2());
application.setAttribute("comlistRec", comlistRec);
%>
<table border="1">
<tr>
<th>品牌</th>
<th>名称</th>
<th>价格</th>
<th>剩余</th>
<th>查看</th>
<th>购物车</th>
</tr>
<c:forEach var="i" items="${comlistRec}" >
<tr>
<%
count += 1;
%>
<td>${i.brand}</td>									
<td>${i.name}</td>
<td>${i.price}</td>
<td>${i.stock}</td>
<td><a href="./ComDet?id=${i.id}">详细介绍</a> 
<td><a href="./AddCartOne?id=${i.id}">添加购物车</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>