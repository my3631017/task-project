<%@page pageEncoding="utf-8" %>
<%@page session="false" %>
<html>
<body>
<%--<% out.print(session.getId());%>--%>
<%--<% response.setHeader("id",session.getId());%>--%>
<%--<% out.print(request.getSession());%><br>--%>
<% HttpSession session=request.getSession(false);%>
<% out.print(session);%><br>
<% HttpSession session1 = request.getSession();%>
<% out.print(session1);%><br>
<% session1.invalidate();%>
<% HttpSession session2=request.getSession(false);%>
<% out.print(session2);%><br>
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
如果您还没有注册，请单击<a href="${pageContext.request.contextPath}/register">这里</a>注册！<br>
<br>
<form action="${pageContext.request.contextPath}/toMessage">
    <input type="submit" value="拦截器测试">
</form>
</body>
</html>
