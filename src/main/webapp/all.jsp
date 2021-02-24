<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21.02.2021
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="list" items="${list}">
    <p>В валюте -${list.currency.name} доступно ${list.currency.value*list.balance} грн</p>
</c:forEach>
</body>
</html>
