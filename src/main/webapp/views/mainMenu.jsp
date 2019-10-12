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
    <title>Menu</title>
    <link rel="stylesheet" href="/views/style/styleMainMenu.css">
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
    <a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/logOut"> <fmt:message
            key="menu.button.logOut"/>
    </a>
</form>
<div class="wellcome">
    <p><fmt:message key="menu.text.wellcome"/></p>
    <span> <fmt:message key="menu.text.wellcome2"/></span>
</div>
<section class="my-section">
    <div class="menu-menu">
        <div class="button-menu">
            <a class="button24" href="${pageContext.servletContext.contextPath}/register">
                <fmt:message key="menu.button.registration"/>
            </a>
        </div>
        <div class="w-100"></div>
        <div class="">
            <a class="button24" href="${pageContext.servletContext.contextPath}/authorization">
                <fmt:message key="menu.button.signIn"/>
        </a>
    </div>


    </div>
</section>
<!-- подключение popper.js, необходимого для корректной работы некоторых плагинов Bootstrap 4 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
