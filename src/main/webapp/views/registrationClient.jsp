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
    <title>Registration</title>
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
<p>Registration:</p>

<form action="${pageContext.servletContext.contextPath}/register" method="POST">
    <label for="email">
        Email:
    </label>
    <input class="inputForm" type="email" id="email" name="email"
           placeholder="Email" pattern=${REGEX_FOR_EMAIL}  autocomplete="off" required>

    <label for="password">
        Password:
    </label>
    <input class="inputForm" type="password" id="password" name="password"
         pattern=${REGEX_FOR_PASSWORD} placeholder="Password"  autocomplete="off" required>

    <label for="ConfirmPassword">
        Confirm Password:
    </label>
    <input class="inputForm" type="password" id="ConfirmPassword" name="ConfirmPassword"
         pattern=${REGEX_FOR_PASSWORD} placeholder="ConfirmPassword"  autocomplete="off" required>
    <label for="name">
        Name:
    </label>
    <input class="inputForm" type="text" id="Name" name="Name"
        pattern=${REGEX_FOR_NAME}   placeholder="Name"  autocomplete="off" required>
   <label for="SecondName">
       SecondName:
    </label>
    <input class="inputForm" type="text" id="SecondName" name="SecondName"
           pattern=${REGEX_FOR_NAME}     placeholder="SecondName"  autocomplete="off" required>
    <label for="Phone">
        Phone:
    </label>
    <input class="inputForm" type="text" id="Phone" name="Phone" pattern=${REGEX_FOR_PHONE_NUMBER}
           placeholder="Phone" maxlength="13" minlength="10" autocomplete="off" required>

    <input type="submit" value="Submit">

    <a class=" btn btn-primary " href="${pageContext.servletContext.contextPath}/menu">Back to Menu </a>
    </div>

</form>




<!-- подключение popper.js, необходимого для корректной работы некоторых плагинов Bootstrap 4 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous">
</script>
<script src="views/bootstrap-4.3.1-dist/js/bootstrap.min.js"></script>
</body>
</html>
