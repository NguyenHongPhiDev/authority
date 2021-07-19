<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration Food</title>
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
    <ul>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/">Về trang Home</a>
        </li>
        <li>
            <a href="${f:h(pageContext.request.contextPath)}/logout">Logout</a>
        </li>
    </ul>
    <h1>
        Danh sách các món ăn
    </h1>
    <form:form action="${f:h(pageContext.request.contextPath)}/admin/food">
        <button type="submit" name="addFood">Thêm Món</button>
    </form:form>
    <table>
        <tr>
            <th>Id</th>
            <th>Tên</th>
            <th>Loại</th>
            <th>Giá</th>
            <th>Action</th>
        </tr>
        <c:forEach var="food" items="${food}">
            <tr>
                <td>${food.id}</td>
                <td>${food.foodName}</td>
                <td>${food.categorySet.categoryName}</td>
                <td>${food.amount}</td>
                <td>
                    <form:form action="${f:h(pageContext.request.contextPath)}/admin/food">
                        <button type="submit" name="update_id" value="${food.id}">Sửa Món</button>
                        <button type="submit" name="delete_id" value="${food.id}">Xóa Món</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
