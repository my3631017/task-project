<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="date1" uri="http://vmaxtam.com/mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<html>
<head>
    <title>Spring MVC表单处理</title>
</head>
<body>
<h2>您拥有以下这些咸鱼：</h2>

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
                    <%--未转换的Long类型时间--%>
                <td>${user.create_at}</td>
                    <%--<td>${user.update_at}</td>--%>
                    <%--tag标签的时间类型转换--%>
                    <%--<jsp:useBean id="create_at" class="java.util.Date"/>--%>
                    <%--<jsp:setProperty name="create_at" property="time" value="${user.create_at}"/>--%>
                    <%--<td><fmt:formatDate value="${create_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                    <%--<jsp:useBean id="update_at" class="java.util.Date"/>--%>
                    <%--<jsp:setProperty name="update_at" property="time" value="${user.update_at}"/>--%>
                    <%--<td><fmt:formatDate value="${update_at}" pattern="yyyy-MM-dd HH:mm:ss"/></td>--%>
                    <%--自定义tag的时间类型转换--%>
                    <%--<td><date1:dateFormat pattern="yyyy-MM-dd HH:mm:ss" value="${user.create_at}"/></td>--%>
                <td><date1:dateFormat pattern="yyyy-MM-dd HH:mm:ss" value="${user.update_at}"/></td>
            </tr>
        </c:forEach>
    </c:if>
</table>
<table>
    <tr items="${page}">
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="1"></td>
            <td><input type="submit" value="首页"></td>
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.prefPage}"></td>
            <td><input type="submit" value="上一页"></td>
        </form>
        <td>当前：第${page.currentPage}页<--></td>
        <td>共：${page.totalPages}页</td>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.nextPage}"></td>
            <td><input type="submit" value="下一页"></td>
        </form>
        <form method="GET" action="${pageContext.request.contextPath}/user/page">
            <td><input type="hidden" name="page" value="${page.totalPages}"></td>
            <td><input type="submit" value="尾页"></td>
        </form>
    </tr>
</table>
<form method="GET" action="${pageContext.request.contextPath}/user/page">
    <table>
        <tr>
            <td>跳转到第:<input type="text" name="page" size="5"/>页</td>
            <td><input type="submit" value="确定"></td>
        </tr>
    </table>
</form>

<json:object>
    <json:property name="page" value="${page.currentPage}"/>
    <json:array name="students" items="${list}" var="user">
        <json:object>
            <json:property name="id" value="${user.id}"/>
            <json:property name="name" value="${user.name}"/>
            <json:property name="number" value="${user.number}"/>
            <json:property name="create_at" value="${user.create_at}"/>
            <json:property name="update_at" value="${user.update_at}"/>
        </json:object>
    </json:array>
</json:object>

</body>
</html>