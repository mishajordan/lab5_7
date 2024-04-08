<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обратная связь</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th>
                <a>Филиал</a>
            </th>
            <th>
                <a>Имя</a>
            </th>
            <th>
                <a>Телефон</a>
            </th>
            <th>
                <a>Email</a>
            </th>
            <th>
                <a>Сообщение</a>
            </th>
            <th>
                <a>Дата</a>
            </th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="feedback" items="${feedbacks}">
            <tr>
                <td>
                        ${feedback.branch.name}, ${feedback.branch.address}
                </td>
                <td>
                        ${feedback.name}
                </td>
                <td>
                        ${feedback.phone}
                </td>
                <td>
                        ${feedback.email}
                </td>
                <td>
                        ${feedback.body}
                </td>
                <td>
                        ${feedback.formattedDate}
                </td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
