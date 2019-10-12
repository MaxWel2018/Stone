<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" errorPage="error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/views/style/styleRegistration.css">
    <link rel="stylesheet" href="/views/style/styleCatalog.css">
    <link rel="stylesheet" href="views/bootstrap-4.3.1-dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/style/StyleButton.css">


</head>
<body>
<form action="">
    <select class="custom-select  select-size" id="language" name="language"
            onchange="submit()" style="width: 150px; margin-right: 80%; margin-top: 10px;">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
    </select>
</form>
<p style="color:red; font-size: 35px"><fmt:message
        key="reg.registration"/></p>

<form class="form" style="display:flex; flex-direction: column; color: white;" action="${pageContext.servletContext.contextPath}/register" method="POST">
    <label for="email">
        <fmt:message
                key="reg.email"/> </label>
    <input class="inputForm" type="email" id="email" name="email"
           placeholder=
           <fmt:message key="reg.email"/>   pattern=${REGEX_FOR_EMAIL} autocomplete="off" required>

    <label for="password"> <fmt:message key="reg.password"/> </label>
    <input class="inputForm" type="password" id="password" name="password"
           pattern=${REGEX_FOR_PASSWORD} placeholder=
    <fmt:message key="reg.password"/> autocomplete="off" required>

    <label for="ConfirmPassword">
        <fmt:message key="reg.confPass"/>
    </label>
    <input class="inputForm" type="password" id="ConfirmPassword" name="ConfirmPassword"
           pattern=${REGEX_FOR_PASSWORD} placeholder=
    <fmt:message key="reg.confPass"/> autocomplete="off" required>
    <label for="name">
        <fmt:message key="reg.name"/>
    </label>
    <input class="inputForm" type="text" id="Name" name="Name"
           pattern=${REGEX_FOR_NAME}   placeholder=
    <fmt:message key="reg.name"/> autocomplete="off" required>
    <label for="SecondName">
        <fmt:message key="reg.secontName"/>
    </label>
    <input class="inputForm" type="text" id="SecondName" name="SecondName"
           pattern=${REGEX_FOR_NAME}     placeholder=
    <fmt:message key="reg.secontName"/> autocomplete="off" required>
    <label for="Phone">
        <fmt:message key="reg.phone"/>
    </label>
    <input class="inputForm" type="text" id="Phone" name="Phone" pattern=${REGEX_FOR_PHONE_NUMBER}
            placeholder=
    <fmt:message key="reg.phone"/>
           maxlength="13" minlength="10" autocomplete="off" required>

    <input class="btn-success my-btn" type="submit" value= <fmt:message key="reg.button.submite"/>>

    <a class=" btn btn-primary my-btn" href="${pageContext.servletContext.contextPath}/menu"><fmt:message key="reg.button.backToMenu"/></a>
    </div>

</form>


<!-- подключение popper.js, необходимого для корректной работы некоторых плагинов Bootstrap 4 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
