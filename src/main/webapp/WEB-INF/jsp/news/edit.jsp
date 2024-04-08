<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактировать</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <section>
                <form:form method="post" modelAttribute="articleForm" enctype="multipart/form-data">
                    <h2>Редактировать новость</h2>
                    <hr />
                    <div class="form-floating mb-3">
                        <a>Заголовок</a><br>
                        <form:input class="form-control-lg" type="text" path="title" value="${article.title}"/>
                    </div>
                    <div class="form-floating mb-3">
                        <a>Текст</a><br>
                        <form:input class="form-control-lg" path="body" value="${article.body}"/><br>
                    </div>
                    Новая фотография: <form:input path="photo" type="file" accept="image/jpeg"/>
                    <div>
                        <button type="submit" class="btn btn-lg btn-primary">Отправить</button>
                    </div>
                </form:form>
            </section>
        </div>
    </div>
</div>
</body>
</html>
