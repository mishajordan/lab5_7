<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <div class="container">
        <img src="img/station.jpg">
        <div>Количество посещений: ${counter}</div>
        <div>Текущее время: ${time}</div>
    </div>
</body>
</html>
