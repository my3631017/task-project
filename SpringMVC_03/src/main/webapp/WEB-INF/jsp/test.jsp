<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>用户信息如下：</h2>
如果您未找到您需要的信息，可以点击<a href="/user/findUser">这里</a>进行查询<br>
<%--<form:form id="userForm" method="POST" action="/user/change">--%>
<table frame="box" rules="all">
    <tr>
        <td>序号</td>
        <td>姓名</td>
        <td>学号</td>
        <td>创建时间</td>
        <td>修改时间</td>
    </tr>
    <c:if test="${list!= null || fn:length(list) != 0}">
        <c:forEach items="${list}" var="user" begin="0" end="${fn:length(list) }">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.number}</td>
                <td>${user.create_at}</td>
                <td>${user.update_at}</td>
                <td><a href="/user/change/${user.id}">修改</a><br></td>
                <td><a href="/user/delete/${user.id}">删除</a><br></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<%--</form:form>--%>
<%--<script type="text/javascript">--%>
<%--function del() {--%>
<%--document.forms.userForm.action = "/user/findUser";--%>
<%--document.forms.userForm.submit();--%>
<%--}--%>
<%--</script>--%>
</body>
</html>