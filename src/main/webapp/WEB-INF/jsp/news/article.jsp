<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Новость</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div>
        <h3>${article.title}</h3>
        <c:if test="${article.photo != null}">
            <div>
                <img class="photo" alt="img" src="data:image/jpeg;base64,${article.base64image}"/>
            </div>
        </c:if>
        <div>${article.body}</div>
        <br/>
        <div><small style="color: #6e6e6e">${article.formattedDate}</small></div>
        <hr>
        <h5><a href="/news">К новостям</a></h5>
    </div>
</div>
</body>
</html>
