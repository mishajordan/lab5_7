<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Роли пользователя</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <section>
                <h2>Смена роли</h2>
                <form method="POST">
                    <select name="role">
                        <c:forEach var="role" items="${roles}">
                            <option value="${role.name}">${role.name}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-lg btn-primary">Обновить</button>
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
