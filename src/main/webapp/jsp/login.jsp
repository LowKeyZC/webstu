<%--
  Created by IntelliJ IDEA.
  User: ZC
  Date: 2019/1/9
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
    <div align="center" >
        <form action="/user/login" method="post">
            <p>用户名: <input type="text" name="userId" /></p>
            <p>密码: <input type="password" name="userPwd" /></p>
            <input type="submit" value="Submit" />
        </form>
    </div>
</body>
</html>