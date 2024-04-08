<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <div class="row">
        <div class="col-md-4">
            <section>
                <form method="post" action="${pageContext.request.contextPath}/login">
                    <h2>Войти</h2>
                    <hr />
                    <div class="form-floating mb-3">
                        <input class="form-control-lg" type="text" name="username" placeholder="Логин"/>
                    </div>
                    <div class="form-floating mb-3">
                        <input class="form-control-lg" type="password" name="password" placeholder="Пароль"/>
                    </div>
                    <div>
                        <button type="submit" id="login-submit" class="btn btn-lg btn-primary">Войти</button>
                    </div>
                    <div>
                        <p>
                            <a href="${pageContext.request.contextPath}/register">Зарегистрироваться</a>
                        </p>
                    </div>
                </form>
            </section>
        </div>
        </div>
    </div>
</body>
</html>
