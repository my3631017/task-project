<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>login</title>
</head>
<body>
<center>
    <form action="/login" method="POST">
        <table>
            <caption>用户登录</caption>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="username" size="20"/></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type="password" name="password" size="20"/></td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>
        </table>
    </form>
    如果您还没有注册，请单击<a href="/register">这里</a>注册！
</center>
</body>
</html>