<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加销售</title>
</head>
<body>
<h1><a href="ManagerHome.jsp">管理员首页</a></h1>
<form action="./ManagerAddSaler" method="post">
<h2>添加销售</h2>
<p>销售编号：<input type="text" name="salerid"  placeholder="请输入商品编号"></p>
<p>销售密码：<input type="text" name="salerpw"  value="123456"></p>
<p>管理品牌：<input type="text" name="salerbrand"  placeholder="请输入商品价格"></p>
<p><input type="submit" name="" value="添加"></p>
</form>
<h2><a href="ManagerHome.jsp">管理员首页</a></h2>
</body>
</html>