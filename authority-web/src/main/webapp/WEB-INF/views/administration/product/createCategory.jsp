<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/7/2021
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add category</title>
</head>
<body>
<form:form action="${f:h(pageContext.request.contextPath)}/admin/category">
    <lable>Tên : </lable>
    <input type="text" name="name" required />
    <input type="submit" name="addCate" value="Add">
</form:form>
</body>
</html>
