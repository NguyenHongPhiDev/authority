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
    <style>
        li{
            list-style-type: none;
        }
    </style>
</head>
<body>
<div>
    <h4>${User.username}</h4>
        <h2>Các quyền đã có</h2>
    <ul>
        <c:forEach var="roleaction" items="${User.userRoles}">
            <c:forEach items="${roleaction.role.roleActions}" var="action">
                <li>
                    <input checked type="checkbox" value="${action.action.name}">${action.action.description }
                </li>
            </c:forEach>
        </c:forEach>
    </ul>
    <h2>Tất cả các quyền</h2>
    <ul>
        <c:forEach var="description" items="${actions}">
            <li>
                <input type="checkbox" value="${description.name}">${description.description}
            </li>
        </c:forEach>
    </ul>
    <button name="update" value="${User.id}">
        Cập nhật
    </button>
</div>
</body>
</html>
