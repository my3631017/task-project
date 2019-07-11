<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
</head>
<body>
<%--${ip}--%>
<%--<% int a=5;%>--%>
<%--<% int b=a*5;%>--%>
<%--<% out.println(b);%>--%>
<%--<% out.print("Hello everyone！");%><br>--%>
<%--<% out.write("Hello everyone！");%><br>--%>
<%--<% out.println(request.getRemoteAddr());%>--%>
<%--<% System.out.println("Hello everyone！");%><br>--%>
<%--<% out.close();%>--%>
<%--<% out.println("Hello everyone！");%><br>--%>
<%--<% out.print("你的IP是：" + request.getRemoteAddr());%><br>--%>

<%--<form action="/response">--%>
    <%--username:<input type="text" name="user"/><br/>--%>
    <%--password:<input type="password" name="pwd"/><br/>--%>
    <%--<input type="submit" name="登陆"/>--%>
<%--</form>--%>

<%--out方法，输出value的值--%>
<c:out value="java是一门神奇的语言"/><br>

<%--set方法，存储变量的值--%>
<c:set var="laoda" value="老大最帅"/>
<c:out value="${laoda}"/><br>

<%--&lt;%&ndash;set方法，修改变量的值&ndash;%&gt;--%>
<%--<c:set var="laoda" value="老大没我帅"/>--%>
<%--<c:out value="${laoda}"/><br>--%>

<%--&lt;%&ndash;remove方法，删除变量的值&ndash;%&gt;--%>
<%--<c:remove var="laoda"/>--%>
<%--&lt;%&ndash;laoda被删除之后，输出结果只会出现233&ndash;%&gt;--%>
<%--<c:out value="${laoda}233"/><br>--%>

<%--&lt;%&ndash;catch方法，用在可能出现异常的地方，捕获出现的异常&ndash;%&gt;--%>
<%--<c:catch var="exception">--%>
<%--<% int x = 5 / 0;%>--%>
<%--</c:catch>--%>
<%--<c:out value="${exception}"/><br>--%>

<%--&lt;%&ndash;if方法，跟平时的一样，test为真则只需if里的语句，为假则不执行&ndash;%&gt;--%>
<%--<c:if test="${2>3}">--%>
<%--<c:out value="2>3"/><br>--%>
<%--</c:if>--%>
<%--<c:if test="${2<3}">--%>
<%--<c:out value="2<3"/><br>--%>
<%--</c:if>--%>

<%--&lt;%&ndash;choose方法和when，otherwise连用。做选择，执行test为真的语句&ndash;%&gt;--%>
<%--<c:set var="salary" value="2000"/>--%>
<%--<c:choose>--%>
<%--<c:when test="${salary <= 3000}">--%>
<%--<c:out value="太惨了。"/><br>--%>
<%--</c:when>--%>
<%--<c:when test="${salary > 8000}">--%>
<%--<c:out value="可以多养条狗。"/><br>--%>
<%--</c:when>--%>
<%--<c:otherwise>--%>
<%--<c:out value="只能养活自己。"/><br>--%>
<%--</c:otherwise>--%>
<%--</c:choose>--%>

<%--&lt;%&ndash;import方法,暴露一个url的代码给jsp页面,用var存储页面代码&ndash;%&gt;--%>
<%--<c:import var="data" url="http://www.baidu.com"/>--%>
<%--<c:out value="${data}"/><br>--%>

<%--&lt;%&ndash;foreach方法,遍历集合,items是集合,var是集合里的元素,begin是遍历起始位置,end结束位置&ndash;%&gt;--%>
<%--<c:forEach items="${list}" var="message" begin="0" end="1">--%>
<%--<c:out value="${message}"/><br>--%>
<%--</c:forEach>--%>

<%--&lt;%&ndash;fortokens方法,根据指定的分隔符delims将字符串分割,分割片段保存在var里,然后遍历&ndash;%&gt;--%>
<%--<c:forTokens items="google,runoob,taobao" delims="o" var="name">--%>
<%--<c:out value="${name}"/><br>--%>
<%--</c:forTokens>--%>

<%--&lt;%&ndash;url方法,创造一个url,存储在var里面&ndash;%&gt;--%>
<%--<c:url var="my" value="http://localhost:8080/test"/>--%>
<%--<a href="${my}">image</a><br>--%>

<%--&lt;%&ndash;param方法,结合url使用,把参数绑定到url上,然后存储在var里&ndash;%&gt;--%>
<%--<c:url var="myURL" value="http://localhost:8080/test">--%>
<%--<c:param name="name" value="taobao"/>--%>
<%--</c:url>--%>
<%--&lt;%&ndash;输出绑定后的url&ndash;%&gt;--%>
<%--<c:out value="${myURL}"/><br>--%>
<%--<a href="${myURL}">淘宝</a>--%>

<%--redirect方法,将页面重定向到指定的url--%>
<%--<c:redirect url="http://www.baidu.com"/>--%>

</body>
</html>
