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
    <title>Title</title>
</head>
<body>
<form:form action="${f:h(pageContext.request.contextPath)}/admin/food">
    <lable>Tên : </lable>
    <input type="text" name="name" required/>
    <lable>Giá : </lable>
    <input type="text" name="amount" pattern="[0-9]+">
    <lable>Category :</lable>
    <select name="category" id="category">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.categoryName}</option>
        </c:forEach>
    </select>
    <input type="submit" name="add" value="Add">
</form:form>
</body>
</html>
