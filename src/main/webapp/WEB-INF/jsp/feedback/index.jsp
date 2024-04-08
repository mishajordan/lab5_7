<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Обратная связь</title>
</head>
<body>
<jsp:include page="../header.jsp"/>
<div class="container">
  <div class="row">
    <div class="col-md-4">
      <section>
        <form:form method="post" modelAttribute="feedbackForm">
          <h2>Обратная связь</h2>
          <hr />
          <div class="form-floating mb-3">
            <form:select class="form-control-lg" path="branchId">
              <option value="" disabled selected>---Выберите филиал---</option>
              <c:forEach var="branch" items="${branches}">
                <form:option value="${branch.id}">${branch.name}, ${branch.address}</form:option>
              </c:forEach>
            </form:select>
          </div>
          <div class="form-floating mb-3">
            <form:input class="form-control-lg" type="text" path="name" placeholder="Ваше имя"/>
          </div>
          <div class="form-floating mb-3">
            <form:input class="form-control-lg" type="text" path="phone" placeholder="Ваш номер телефона"/><br>
          </div>
          <div class="form-floating mb-3">
            <form:input class="form-control-lg" type="email" path="email" placeholder="Ваш email"/><br>
          </div>
          <div class="form-floating mb-3">
            <form:textarea class="form-control-lg" path="body" placeholder="Ваше сообщение"/><br>
          </div>
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
