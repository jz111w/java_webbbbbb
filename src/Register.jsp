<%@ page language="java" contentType="text/html; charsetUTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>
<body>
<form action="./Register" method="post"><h1><a href="Home.jsp">首页</a></h1>
        <p>用户注册</p>
        <p><input type="text" name="email"  placeholder="请输入邮箱"></p>
        <p><input type="text" name="pw1"  placeholder="请输入密码"></p>
        <p><input type="text" name="pw2"  placeholder="请确认密码"></p>
        <p><input type="submit" name="" value="注册"></p>
        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="Tip.html">
            使用条款和隐私策略
        </a></p>
        <p class="txt"><a href="Login.jsp"><span></span>已有账号登录</a></p>
       </form>
</body>
</html>