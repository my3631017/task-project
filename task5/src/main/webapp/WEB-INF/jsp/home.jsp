<%@ page import="com.pojo.Customer" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Spring MVC 表单处理</title>
</head>
<body>
<% ServletContext context = session.getServletContext();%>
<% Customer customer = (Customer) context.getAttribute("user");%>
<% out.println(customer.getUsername()+"享年"+customer.getAge()+"岁！");%>

<form action="${pageContext.request.contextPath}/toMessage">
    <input type="submit" value="拦截器测试">
</form>
<a href="${pageContext.request.contextPath}/cancellation">注销</a>
</body>
</html>