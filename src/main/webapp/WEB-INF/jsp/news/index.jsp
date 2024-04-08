<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Новостная лента</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <h3>Новости</h3>
    <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
        <h5><a href="/news/add">Добавить новость</a></h5>
    </sec:authorize>
    <br/>
    <c:forEach var="article" items="${news}">
        <div>
            <h3><a href="news/${article.id}">${article.title}</a></h3>
            <c:if test="${article.photo != null}">
                <div>
                    <img class="photo" alt="img" src="data:image/jpeg;base64,${article.base64image}"/>
                </div>
            </c:if>
            <div>${article.body}</div>
            <br/>
            <div><small style="color: #6e6e6e">${article.formattedDate}</small></div>
            <sec:authorize access="hasRole('ADMIN') or hasRole('MODERATOR')">
                <small><a href="/news/edit/${article.id}">Редактировать</a></small>
                <small><a href="/news/delete/${article.id}">Удалить</a></small>
            </sec:authorize>
            <hr>
        </div>
    </c:forEach>
</div>
</body>
</html>
