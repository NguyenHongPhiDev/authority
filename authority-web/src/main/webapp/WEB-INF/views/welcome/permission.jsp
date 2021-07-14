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
        li {
            list-style-type: none;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // $("input[name='description']").prop("checked", true);
            var listCheck = [];
            $("input[name='description1']:checked").each(function () {
                listCheck.push($(this).val());
                console.log($(this).val())
            });
            $("input[name='description']").each(function () {
                for (var i = 0; i < listCheck.length; i++) {
                    if ($(this).val() === listCheck[i]) {
                        $(this).prop("checked", true);
                    }
                }
            });
            $("#update").onclick(function () {
                alert("abc");
            });
        })
        var listChecked = [];
        $("#update").onclick(function () {
            alert("abc");
            // $("input[name='description']:checked").each(function () {
            //     if ($(this).val() !== listCheck[i]) {
            //         listChecked.push($(this).val());
            //     }
            // });
        });
        alert(listChecked);
    </script>
</head>
<body>
<div>
    <h4>${User.username}</h4>
    <ul style="display: none">
        <c:forEach var="roleaction" items="${User.userRoles}">
            <c:forEach items="${roleaction.role.roleActions}" var="action">
                <li>
                    <input id="description1" checked name="description1" type="checkbox"
                           value="${action.action.name}">${action.action.description }
                </li>
            </c:forEach>
        </c:forEach>
    </ul>
    <h2>Các quyền</h2>
    <ul id="c_b">
        <c:forEach var="description" items="${actions}">
            <li>
                <input id="description" name="description" type="checkbox"
                       value="${description.name}">${description.description}
            </li>
        </c:forEach>
    </ul>
    <button id="update" name="update" value="${User.id}">
        Cập nhật
    </button>
</div>
</body>
</html>

