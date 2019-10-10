<%--
  Created by IntelliJ IDEA.
  User: krugo
  Date: 25.09.2019
  Time: 2:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language"
       value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}"
       scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages"/>
<html lang="${param.lang}">
<head>
    <title>Backet</title>
    <link rel="stylesheet" href="/views/style/styleOrder.css">
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
<a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/catalog"><fmt:message
        key="backet.backToCatalog"/> </a>


<p style=" font-size:24px; text-align: center; color: white"><fmt:message key="backet.dr"/>
    <i> ${userName} ${userSurName}</i> <fmt:message key="backet.textPrice"/> ${cost}$ <fmt:message
            key="catalog.text.weight"/> <fmt:formatNumber type="number" maxFractionDigits="2" value="${weight}"/><fmt:message
            key="backet.carat"/>
</p>
<a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/filter"><fmt:message key="backet.filter"/> </a>
<a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/sort"><fmt:message key="backet.sort"/> </a>

<div class="flex">

    <div class="flex" style="flex-wrap: wrap;">
        <c:forEach items="${stones}" var="stone">
            <div class="element">
                <p><fmt:message key="catalog.text.type"/> ${stone.getType()}</p>
                <p><fmt:message key="catalog.text.color"/> ${stone.getColor()}</p>
                <p><fmt:message key="catalog.text.weight"/>${stone.getWeight()}</p>
                <p><fmt:message key="catalog.text.transparency"/> ${stone.getTransparency()}</p>
                <p style="color: #00ff73; font-weight: bold"><fmt:message key="catalog.text.price"/> ${stone.getPrice()}$</p>
                <img style="width: 200px; height: 200px;" src="${stone.getImg()}" alt="img"/>
            </div>
        </c:forEach>
    </div>
</div>

<a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/orderBasket"> <fmt:message
        key="backet.confirmOrder"/> </a>

<!-- подключение popper.js, необходимого для корректной работы некоторых плагинов Bootstrap 4 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>