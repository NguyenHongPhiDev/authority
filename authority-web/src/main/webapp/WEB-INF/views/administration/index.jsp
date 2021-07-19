<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adminstration</title>

</head>
<body>
<div>
    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <ul>
            <li>
                <a href="${f:h(pageContext.request.contextPath)}/admin/food">Thêm món</a>
            </li>
            <li>
                <a href="${f:h(pageContext.request.contextPath)}/admin/category">Thêm category</a>
            </li>
            <li>
                <a href="${f:h(pageContext.request.contextPath)}/admin/permission">Sửa quyền</a>
            </li>
        </ul>
    </sec:authorize>
</div>
</body>
</html>
