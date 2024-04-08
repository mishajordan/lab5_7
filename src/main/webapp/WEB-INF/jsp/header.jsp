<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <style>
        <%@include file="/WEB-INF/css/bootstrap.min.css"%>
        <%@include file="/WEB-INF/css/site.css"%>
        <%@include file="/WEB-INF/css/styles.css"%>
    </style>
    <title>Header</title>
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Бензоколонка</a>
                <div class="navbar-collapse collapse d-sm-inline-flex justify-content-between">
                    <ul class="navbar-nav flex-grow-1">
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/news">Новостная лента</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-dark" href="${pageContext.request.contextPath}/feedback">Связаться с нами</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav">
                        <sec:authorize access="!isAuthenticated()">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/login">Войти</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/register">Регистрация</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="isAuthenticated()">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/profile">Личный кабинет</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/logout">Выйти</a>
                            </li>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/admin/users">Список пользователей</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link text-dark" href="${pageContext.request.contextPath}/admin/feedback">Обратная связь</a>
                            </li>
                        </sec:authorize>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
</body>
</html>
