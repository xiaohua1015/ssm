<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/userRegister" method="post">
        <table border="2" align="center">
            <tr>
                <th>编号</th>
                <td><input type="text" name="id"></td>
            </tr>
            <tr>
                <th>用户名</th>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="注册"></td>
            </tr>
        </table>
    </form>
</body>
</html>
