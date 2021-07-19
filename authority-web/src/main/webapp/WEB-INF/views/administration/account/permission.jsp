<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin permission</title>
    <style>
        table, td, th {
            border: 1px solid black;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        li {
            list-style-type: none;
        }
    </style>
</head>
<body>
<div>
    <h4>Trang permission</h4>
    <form:form action="${f:h(pageContext.request.contextPath)}/admin/permission" >
        <input type="submit" name="addPermission" value="Thêm quyền và đường dẫn">
    </form:form>
    <table>
        <tr>
            <th>username</th>
            <th>Roles</th>
            <th>Link</th>
            <th>Description</th>
            <th>Action</th>
        </tr>
        <c:forEach var="user" items="${userList}">
            <tr>
                <td>${user.username}</td>
                <td>
                    <c:forEach var="userRole" items="${user.userRoles}">
                        ${userRole.role.roleName}
                    </c:forEach>
                </td>

                <td>
                    <ul>
                        <c:forEach var="userRole" items="${user.userRoles}">
                            <c:forEach var="userRoles" items="${userRole.role.roleActions}">
                                <li>
                                    <a href="${f:h(pageContext.request.contextPath)}${userRoles.action.name}">${userRoles.action.name}</a>
                                </li>
                            </c:forEach>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <ul>
                        <c:forEach var="userRole" items="${user.userRoles}">
                            <c:forEach var="userRoles" items="${userRole.role.roleActions}">
                                <li>
                                        ${userRoles.action.description}
                                </li>
                            </c:forEach>
                        </c:forEach>
                    </ul>
                </td>
                <td>
                    <form:form action="${f:h(pageContext.request.contextPath)}/admin/permission">
                        <button type="submit" name="user_id" value="${user.id}">Thêm quyền</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
