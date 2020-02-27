<%--
  Created by IntelliJ IDEA.
  User: hungly
  Date: 2/26/20
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="partials/head.jsp"/>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<c:choose>
    <c:when test="${(param.username eq 'admin') && (param.password eq 'password')}">
        <% response.sendRedirect("/profile.jsp"); %>
    </c:when>
    <c:otherwise>
        <form action="/login.jsp" method="POST" class="login-form">
            <div class="form-example">
                <label for="username">Enter your username: </label>
                <input type="text" name="username" id="username" required>
            </div>
            <div class="form-example">
                <label for="password">Enter your password: </label>
                <input type="password" name="password" id="password" required>
            </div>
            <div class="form-example">
                <input type="submit" value="Login">
            </div>
        </form>
    </c:otherwise>
</c:choose>
</body>
</html>
