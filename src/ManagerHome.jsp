<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>个人中心</title>
</head>
<body>

	<h1><a href="ManagerHome.jsp">管理员首页</a></h1>

            <h3><span >[admin]</span><span><a href="./ManagerQuit">[退出登录]</a></span></h3>
            	<h4>客户管理</h4>
                <ul>
               		<li><a href="ManagerUser.jsp">用户列表</a></li>
                    <li><a href="ManagerLogL.jsp">用户登录日志</a></li>
                    <li><a href="ManagerLogB.jsp">用户浏览日志</a></li>
                    <li><a href="ManagerLogP.jsp">用户购买日志</a></li>
                    <li><a href="ManagerUserImage.jsp">用户偏好</a></li>
                </ul>
                <h4>销售管理</h4>
                <ul>
                    <li><a href="ManagerSaler.jsp">销售账号管理</a></li>
                    <li><a href="ManagerSalerLogO.jsp">销售操作日志</a></li>
                </ul>
                <h4>管理员管理</h4>
                <ul>
                    <li><a href="ManagerLogO.jsp">管理员操作日志</a></li>
                </ul>
                <h4>商品管理</h4>
                <ul>
                	<li><a href="ManagerCom.jsp">商品销售记录</a></li>
                    <li><a href="ManagerComName.jsp">商品销售统计</a></li>
                    <li><a href="ManagerComBrand.jsp">品牌销售统计</a></li>
                    <li><a href="ManagerComWarning.jsp">商品销售预警</a></li>
                </ul>

</body>
</html>