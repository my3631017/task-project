<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<%
    //获取请求数据
    String name = request.getParameter("user");
    String pwd = request.getParameter("pwd");
    System.out.println(name + "," + pwd);

    if (name.equals("123456") && pwd.equals("666666")) {
        out.println("登陆成功");
    } else {
        out.println("errors");
    }
%>
</body>
</html>