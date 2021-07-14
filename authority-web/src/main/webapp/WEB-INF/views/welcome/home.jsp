<div id="wrapper">
    <h4>Đây là trang Home</h4>
    <sec:authorize access="!isAuthenticated()">
        <h2>Username :${username}</h2>
    </sec:authorize>

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
