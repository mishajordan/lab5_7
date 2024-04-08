<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
            <div class="col-md-4">
                <section>
                    <form:form method="post" modelAttribute="userForm">
                        <h2>Регистрация</h2>
                        <hr />
                        <div class="form-floating mb-3">
                            <form:input class="form-control-lg" type="text" path="username" placeholder="Логин"/><br>
                            <form:errors path="username"/>
                                ${usernameError}
                        </div>
                        <div class="form-floating mb-3">
                            <form:input class="form-control-lg" type="password" path="password" placeholder="Пароль"/>
                        </div>
                        <div class="form-floating mb-3">
                            <form:input class="form-control-lg" type="password" path="passwordConfirm" placeholder="Подтвердите пароль"/><br>
                            <form:errors path="password"/>
                                ${passwordError}
                        </div>
                        <div>
                            <button type="submit" class="btn btn-lg btn-primary">Зарегистрироваться</button>
                        </div>
                    </form:form>
                </section>
            </div>
        </div>
    </div>
</body>
</html>
