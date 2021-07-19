<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/7/2021
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD permission</title>
</head>
<body>
    <form:form action="${f:h(pageContext.request.contextPath)}/admin/permissưon">
        <lable>Đường dẫn : </lable>
        <input type="text" name="action" required/>
        <lable>Chi tiết : </lable>
        <input type="text" name="description" pattern="[A-Z]{4-9}[_]?[A-Z]{4-9}">
        <input type="submit" name="add" value="Add">
    </form:form>
</body>
</html>
