<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet" href="${f:h(pageContext.request.contextPath)}/resources/app/css/styles.css"/>
</head>
<body>
<div id="wrapper">
    <c:if test="${param.containsKey('error')}">
            <span id="loginError">
            <t:messagesPanel messagesType="error"
                             messagesAttributeName="SPRING_SECURITY_LAST_EXCEPTION"/>
            </span>
    </c:if>
    <form:form action="${f:h(pageContext.request.contextPath)}/login">
        <table style="margin-left: 30%">
            <tr>
                <td width="100px"><label for="username">User:</label></td>
                <td><input type="text" id="username" name="username" value='admin'>(admin)</td>
            </tr>
            <tr>
                <td><label for="password">Password:</label></td>
                <td><input type="password" id="password" name="password" value='demo'>(demo)</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input id="login" name="submit" type="submit" value="login"/></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td>
                    <a id="loginFB"
                       href="https://www.facebook.com/dialog/oauth?client_id=182502713859613&redirect_uri=http://localhost:8080/authority-web/login-facebook">
                        Login with facebook
                    </a>
                </td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><a id="create" href="${f:h(pageContext.request.contextPath)}/accounts/create?form">Create new
                    account</a></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><a id="forgotten" href="${f:h(pageContext.request.contextPath)}/reissue/create?form">I've forgotten
                    my password</a></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>