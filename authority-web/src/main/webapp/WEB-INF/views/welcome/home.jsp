<div id="wrapper">
    <h4>Đây là trang Home</h4>
    <h2>Username :${username}  roles : (${role})</h2>
    <ul>
        <li>
            <sec:authorize access="isAuthenticated()">
            <a href="${f:h(pageContext.request.contextPath)}/logout">Logout</a>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
            <a href="${f:h(pageContext.request.contextPath)}/login">Login</a>
            </sec:authorize>
        </li>
        <li><a href="${f:h(pageContext.request.contextPath)}/admin">Đến trang admin</a></li>
        <li><a href="${f:h(pageContext.request.contextPath)}/user">Đến trang user</a></li>
    </ul>
</div>
