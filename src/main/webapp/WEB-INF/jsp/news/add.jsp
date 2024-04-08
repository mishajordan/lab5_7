<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Добавить новость</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <section>
                <form:form method="post" modelAttribute="articleForm" enctype="multipart/form-data">
                    <h2>Добавить новость</h2>
                    <hr />
                    <div class="form-floating mb-3">
                        <form:input class="form-control-lg" type="text" path="title" placeholder="Заголовок"/>
                    </div>
                    <div class="form-floating mb-3">
                        <form:textarea class="form-control-lg" path="body" placeholder="Текст новости"/><br>
                    </div>
                        Фотография: <form:input path="photo" type="file" accept="image/jpeg"/>
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
