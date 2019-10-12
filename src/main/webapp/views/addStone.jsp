<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 10/8/2019
  Time: 11:31 AM
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
    <title>Add stone</title>
    <link rel="stylesheet" href="/views/style/styleCatalog.css">
    <link rel="stylesheet" href="/views/style/addStone.css">
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
<form style="display: flex;flex-direction: column;" class="white-text"
      action="${pageContext.servletContext.contextPath}/addStone" method="POST">

    <fmt:message
            key="catalog.text.color"/>
    <label class="white-text">
        <select name="color">
            <c:forEach items="${color}" var="item">
                <option value=${item}>${item}</option>
            </c:forEach>
        </select>
    </label>
    <fmt:message
            key="catalog.text.price"/>
    <label for="price">
        <input type="text" id="price" name="price" placeholder= <fmt:message key="catalog.text.price"/>>
    </label>
    <fmt:message
            key="catalog.text.weight"/>
    <label for="weight">
        <input type="text" id="weight" name="weight" placeholder= <fmt:message key="catalog.text.weight"/>>
    </label>
    <fmt:message
            key="catalog.text.type"/>
    <label>
        <select name="type">
            <c:forEach items="${typeGem}" var="item">
                <option value=${item}>${item}</option>
            </c:forEach>
            <c:forEach items="${typeSem}" var="item">
                <option value=${item}>${item}</option>
            </c:forEach>
        </select>
    </label>
    <fmt:message
            key="catalog.text.transparency"/>
    <label>
        <select name="transparency">
            <c:forEach items="${transparency}" var="item">
                <option value=${item}>${item}</option>
            </c:forEach>
        </select>
    </label>
    <input type="submit" value= <fmt:message key="reg.button.submite"/>>

    <a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/menu"><fmt:message
            key="reg.button.backToMenu"/></a>

</form>


<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

</body>
</html>
