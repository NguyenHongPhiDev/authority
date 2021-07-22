<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Permission</title>
    <style>
        li {
            list-style-type: none;
        }
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script type="text/javascript">
        var listCheck = [];
        $(document).ready(function () {
            $("input[name='description1']:checked").each(function () {
                listCheck.push($(this).val());
            });
            $("input[name='description']").each(function () {
                for (var i = 0; i < listCheck.length; i++) {
                    if ($(this).val() === listCheck[i]) {
                        $(this).prop("checked", true);
                    }
                }
            });
        })
        $(document).ready(function () {
            $('#update').click(function () {
                var listChecked = [];
                var listUncheck = [];
                $("input:checkbox[name='description']").not(':checked').each(function (){
                    var fUncheck = true;
                    for(var i=0;i<listCheck.length;i++){
                                if(listCheck[i]===$(this).val()){
                                    fUncheck=false;
                                    listUncheck.push($(this).val())
                                }
                            }
                });
                $("input[name='description']:checked").each(function () {
                    var f = true;
                    for(var i=0;i<listCheck.length;i++){
                        if(listCheck[i]===$(this).val()){
                            f=false;
                        }
                    }
                    if(f===true){
                        listChecked.push($(this).val())
                    }
                });
                listUncheck =(listUncheck.length>0) ? listUncheck : null;
                listChecked =(listChecked.length>0) ? listChecked : null;
                const formData = {
                    'listUncheck': listUncheck,
                    'listChecked': listChecked,
                    'user_id': ${User.id}
                };
                console.log(formData);
                $.ajax({
                    type: "POST",
                    url: "/authority-web/admin/permission/update",
                    data: formData,
                    dataType: "text",
                    success: function(){
                        window.location.replace("http://localhost:8080/authority-web/admin/permission");
                    }
                });
            });
        });
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
                           value="${action.action.id}">${action.action.description }
                </li>
            </c:forEach>
        </c:forEach>
    </ul>
    <h2>Các quyền</h2>
    <ul id="c_b">
        <c:forEach var="description" items="${actions}">
            <li>
                <input id="description" name="description" type="checkbox"
                       value="${description.id}">${description.description}
            </li>
        </c:forEach>
    </ul>
    <button id="update" name="update" value="${User.id}">
        Cập nhật
    </button>
</div>
</body>
</html>

