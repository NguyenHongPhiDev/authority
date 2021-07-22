<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration Category</title>
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
        Danh sách các loại món ăn
    </h1>
    <form:form action="${f:h(pageContext.request.contextPath)}/admin/category">
        <button type="submit" name="addCategory">Thêm Loại Món Ăn</button>
    </form:form>
    <table>
        <tr>
            <th>Id</th>
            <th>Tên</th>
            <th>Action</th>
        </tr>
        <c:forEach var="cate" items="${categories}">
            <tr>
                <td>${cate.id}</td>
                <td>${cate.categoryName}</td>
                <td>
                    <form:form  action="${f:h(pageContext.request.contextPath)}/admin/category">
                        <button type="submit" name="update_id" value="${cate.id}">Sửa Món</button>
                        <button type="submit" name="delete_id" value="${cate.id}">Xóa Món</button>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
