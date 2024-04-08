<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Личный кабинет</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>
    <div class="container">
        <c:if test="${user.avatar != null}">
            <div>
                Ваш аватар
            </div>
            <div>
                <img class="avatar" alt="img" src="data:image/jpeg;base64,${user.base64image}"/>
            </div>
        </c:if>

        <div>Имя пользователя: ${user.username} <a href="/profile/edit/username">(Изменить)</a></div>
        <div><a href="/profile/edit/password">Изменить пароль</a></div>
        <div>
            <form method="POST" action="profile/avatar" enctype="multipart/form-data">
                Обновить аватар: <input type="file" name="file" accept="image/jpeg"><br />
                <input type="submit" value="Загрузить">
            </form>
        </div>
    </div>
</body>
</html>
