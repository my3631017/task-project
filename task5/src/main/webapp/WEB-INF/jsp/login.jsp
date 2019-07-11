<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC</title>
</head>
<body>
${message}<br>
<form action="${pageContext.request.contextPath}/loginResult" method="POST">
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
            <td><input type="submit" value="确定"/></td>
            <td><input type="reset" value="重置"/></td>
        </tr>
    </table>
</form>
<a href="${pageContext.request.contextPath}/register">注册</a>
<br>
<% for (Cookie cookie : request.getCookies()) {
    out.println(cookie.getName());
    out.println(cookie.getValue());
}%>
<br>
<a href="${pageContext.request.contextPath}/cancellation">注销</a>
<form action="${pageContext.request.contextPath}/toMessage">
    <input type="submit" value="拦截器测试">
</form>
</body>
</html>