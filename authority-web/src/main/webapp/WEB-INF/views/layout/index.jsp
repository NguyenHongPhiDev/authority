<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="!isAuthenticated()">
    <ul>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/login">Login</a>
        </li>
    </ul>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
    <ul>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/logout">logout</a>
        </li>
    </ul>
</sec:authorize>
<sec:authorize access="hasRole('ROLE_ADMIN')">
    <ul>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/admin">Đến trang admin</a>
        </li>
    </ul>
</sec:authorize>
<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_MANAGER','ROLE_STAFF')">
    <ul>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/profile">Profile</a>
        </li>
    </ul>
</sec:authorize>

</body>
</html>
