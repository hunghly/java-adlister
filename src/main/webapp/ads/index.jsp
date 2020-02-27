<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/navbar.jsp" />
<div class="container">
    <h1>Here are the ads:</h1>
    <c:forEach var="ad" items="${ads}">
        <div class="ad">
            <h2>Title: ${ad.title}</h2>
            <h3>Ad id: ${ad.id}</h3>
            <h3>User id: ${ad.userId}</h3>
            <h3>Description: ${ad.description}</h3>
        </div>
        <hr>
    </c:forEach>

</div>
</body>
</html>