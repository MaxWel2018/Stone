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
    <title>Catalog</title>
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
    <a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/logOut"> <fmt:message
            key="menu.button.logOut"/>
    </a>
</form>

<div class="wrapper">
    <p style="color: white; font-size: 30px; text-align: center;"> <fmt:message key="catalog.textChose"/></p>
    <form action="${pageContext.servletContext.contextPath}/catalog" method="post">
        <div class="flex" STYLE="flex-wrap: wrap;">

            <c:forEach items="${stones}" var="stone">
                <label class="element">
                    <p><fmt:message key="catalog.text.type"/> ${stone.value.getType()}</p>
                    <p><fmt:message key="catalog.text.color"/>${stone.value.getColor()}</p>
                    <p><fmt:message key="catalog.text.weight"/> ${stone.value.getWeight()}</p>
                    <p><fmt:message key="catalog.text.transparency"/>${stone.value.getTransparency()}</p>
                    <p><fmt:message key="catalog.text.price"/> ${stone.value.getPrice()}$</p>
                    <img style="width: 200px; height: 200px;" src="${stone.value.getImg()}" alt="img"/>
                    <input style="color:white; width: 50px; height: 50px;" type="checkbox" name="selected"
                           value=${stone.value.getId()}>
                </label>

            </c:forEach>
        </div>
        <input class=" mybtn btn btn-block btn-success" type="submit" value= <fmt:message key="reg.button.submite"/>>
    </form>
</div>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

</body>
</html>
