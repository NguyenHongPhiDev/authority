<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 13/7/2021
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Permission</title>
</head>
<body>
<div>
    <h4>${User.id}</h4>
    <h4>${User.username}</h4>
    <ul>
            <c:forEach var="roleaction" items="${User.userRoles}">
                <c:forEach items="${roleaction.role.roleActions}" var="action">
                    <li>
                        <h4>${action.action.description }</h4>
                    </li>
                </c:forEach>
            </c:forEach>
    </ul>
</div>
</body>
</html>
