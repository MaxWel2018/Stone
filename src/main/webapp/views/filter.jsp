<%--
  Created by IntelliJ IDEA.
  User: Max
  Date: 10/8/2019
  Time: 11:31 AM
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
    <title>Filter</title>
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
<p style="color:white; font-size: 25px; text-align:  center;"><fmt:message key="filter.text.param"/></p>
<form action="${pageContext.servletContext.contextPath}/filter" method="get">
    <label>
        <select name="param1">
            <c:forEach items="${transparency}" var="item">
            <option value=${item.getRankingPosition()}>${item} </option>
            </c:forEach>
        </select>
    </label>
    <label>
        <select name="param2">
            <c:forEach items="${transparency}" var="item">
                <option value=${item.getRankingPosition()}>${item} </option>
            </c:forEach>
        </select>
    </label>
    <input type="submit" value=<fmt:message key="filter.filter"/>>
</form>
<a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/backet"><fmt:message key="filter.backToBacket"/> </a>


<div class="wrapper">
    <form action="${pageContext.servletContext.contextPath}/catalog" method="post">
        <div class="flex" STYLE="flex-wrap: wrap;">

            <c:forEach items="${stonesFilter}" var="stone">
                <label class="element">
                    <p><fmt:message key="catalog.text.type"/> ${stone.getType()}</p>
                    <p><fmt:message key="catalog.text.color"/>  ${stone.getColor()}</p>
                    <p><fmt:message key="catalog.text.weight"/>  ${stone.getWeight()}</p>
                    <p><fmt:message key="catalog.text.transparency"/>  ${stone.getTransparency()}</p>
                    <p><fmt:message key="catalog.text.price"/>  ${stone.getPrice()}$</p>
                    <img style="width: 200px; height: 200px;" src="${stone.getImg()}" alt="img"/>
                </label>
            </c:forEach>
        </div>
    </form>
</div>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

</body>
</html>
