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
    <title>SignIn</title>
    <link rel="stylesheet" href="/views/styleCatalog.css">
    <link rel="stylesheet" href="views/bootstrap-4.3.1-dist/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="/views/StyleButton.css">
</head>
<body>
<form action="" style="width: 150px;">
    <select class="custom-select  select-size" id="language" name="language"
            onchange="submit()">
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
        <option value="de" ${language == 'de' ? 'selected' : ''}>German</option>
        <option value="fr" ${language == 'fr' ? 'selected' : ''}>France</option>
    </select>
</form>

<div class="wrapper">
    <p style="color: white; font-size: 30px; text-align: center;">Choose stones for a necklace</p>
    <form  action="${pageContext.servletContext.contextPath}/catalog" method="post">
        <div class="flex">

        <c:forEach items="${stones}" var="stone">
        <c:if test="${stone.value.getId()  == 1}">
        <div>
            </c:if>
            <label class="element">
                <p>Type: ${stone.value.getType()}</p>
                <p>Color: ${stone.value.getColor()}</p>
                <p>Weight: ${stone.value.getWeight()}</p>
                <p>Price: ${stone.value.getPrice()}$</p>
                <img style="width: 200px; height: 200px;" src="${stone.value.getImg()}" alt="img"/>
                    <input style="color:white; width: 50px; height: 50px;" type="checkbox" name="selected" value=${stone.value.getId()}>
                </label>

            <c:if test="${stone.value.getId() %3 == 0}">
        </div>
            <script>
                $('.element').click(
                    function(){
                        $(this).find(":checkbox").attr("checked","checked");

                    });
            </script>
        <div>
            </c:if>
            </c:forEach>
        </div>
        </div>
                <input class=" mybtn btn btn-block btn-success" type="submit"  value="submit">
    </form>
</div>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>

</body>
</html>
