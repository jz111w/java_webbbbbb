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
		String idsaler = (String) application.getAttribute("idsaler");
		String charge = (String) application.getAttribute("charge");
		application.setAttribute("charge", charge);
		%>
	<h1><a href="SalerHome.jsp">销售首页</a></h1>

            <h3><span >[<%=idsaler%>]</span><span><a href="./SalerQuit">[退出登录]</a></span></h3>
            <h3>负责的品牌：<span >[<%=charge%>]</span></h3>
            <h4>我的商品</h4>
                <ul>
                    <li><a href="SalerCom.jsp">商品管理</a></li>
                    <li><a href="SalerMonitor.jsp">商品监控</a></li>
                </ul>
                <h4>日志记录</h4>
                <ul>
                    <li><a href="SalerLogB.jsp">浏览日志</a></li>
                    <li><a href="SalerLogP.jsp">购买日志</a></li>
                </ul>
                <h4>账户管理</h4>
                <ul>
                    <li><a href="SalerChangePw.jsp">修改密码</a></li>
                </ul>
                

</body>
</html>