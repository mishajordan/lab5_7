<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Список пользователей</h3>
    <table class="table">
        <thead>
        <tr>
            <th>
                <a>id</a>
            </th>
            <th>
                <a>Имя пользователя</a>
            </th>
            <th>
                <a>Роли</a>
            </th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                        ${user.id}
                </td>
                <td>
                        ${user.username}
                </td>
                <td>
                        ${user.rolesView}
                </td>
                <td>
                    <a href="/admin/users/${user.id}/edit">Изменить</a>
                    <a href="/admin/users/${user.id}/roles">Назначить роли</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
