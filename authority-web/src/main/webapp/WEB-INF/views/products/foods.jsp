<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Food</title>
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
    <div style="display: flex;justify-content: space-around">
        <c:forEach var="food" items="${food}">
            <div style="border:  1px solid;width: 180px;padding:15px 10px 10px 50px;">
<%--                <h4>ID : ${food.id} </h4>--%>
                <h4>Tên : ${food.foodName}</h4>
                <h4>Loại : ${food.categorySet.categoryName}</h4>
                <h4>Giá : ${food.amount} đ</h4>
                <button>Mua</button>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
