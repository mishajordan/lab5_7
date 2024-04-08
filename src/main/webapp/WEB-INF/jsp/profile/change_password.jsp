<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование профиля</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <section>
                <h2>Редактирование пароля</h2>
                <h5>Потребуется повторная авторизация</h5>
                <form method="POST">
                    <input class="form-control-lg" type="password" name="password" placeholder="Новый пароль"/><br>
                    <input type="submit" class="btn btn-lg btn-primary" value="Обновить">
                </form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
