<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
</head>
<body>
	<%
		String id = (String) application.getAttribute("email");
		application.setAttribute("email", id);
	String name=id;
	if(id.equals("")){name="tourist";}
	
	%>
	<h1><a href="Home.jsp">首页</a></h1>

            <h3><span >[<%=name%>]</span><span><a href="./Quit">[退出登录]</a></span></h3>
            <h4>我的交易</h4>
                <ul>
                    <li><a href="./ShowCart">我的购物车</a></li>
                    <li><a href="./ShowOrdOne">我的订单</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="./ChangePwOne">修改密码</a></li>
                </ul>

</body>
</html>