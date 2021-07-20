<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 16/7/2021
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${f:h(pageContext.request.contextPath)}/admin/food/">
    <input type="hidden" name="id" value="${food.id}">
    <lable>Tên : </lable>
    <input type="text" name="name" required value="${food.foodName}"/>
    <lable>Giá : </lable>
    <input type="text" name="amount" pattern="[0-9]+" value="${food.amount}">
    <lable>Category :</lable>
    <select name="category" id="category">
        <option value="${food.categorySet.id}">${food.categorySet.categoryName}</option>
        <c:forEach var="category" items="${categories}">
            <c:if test="${category.id != food.categorySet.id}">
                <option value="${category.id}">${category.categoryName}</option>
            </c:if>
        </c:forEach>
    </select>
    <input type="submit" name="update" value="Update">
</form:form>
</body>
</html>
