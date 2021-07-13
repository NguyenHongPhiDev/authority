<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Đây là trang user</h4>
<ul>
    <li><a href="${f:h(pageContext.request.contextPath)}/user/update">Đến trang updateUser</a></li>
    <li><a href="${f:h(pageContext.request.contextPath)}/user/delete">Đến trang deleteUser</a></li>
    <li><a href="${f:h(pageContext.request.contextPath)}/user/create">Đến trang createUser</a></li>
</ul>
</body>
</html>
