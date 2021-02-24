<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<p> Добавить валюту</p>
<p>
<form action="/AddCurServlet">
    <input type="submit" value="update">
</form>
</p>
Добавить нового пользователя:
<form action="/addUser" method="get">
    <p>Username:<input type="text" name="username">
    <p>drfo<input type="text" name="drfo">
        <input type="submit" value="reg new user">
</form>
Перевести другому пользователю
<form action="/addMoneyServlet" method="get">
    <p>drfofrom:<input type="text" name="drfofrom">
    <p>drfoto<input type="text" name="drfoto">
    <p>sum<input type="text" name="sum">
    <p>Валюта<input type="text" name="curname">
    <input type="submit" value="перевести">
</form>




пополнить счет
<form action="/sendMoneyFromServlet">
    <p>сумма:<input type="text" name="sumto">
    <p>На какой кошелек (Валюта):<input type="text" name="cur">
        drfo <input type="text" name="drfo1">
        <input type="submit" value="пополнить счет"></form>




<b>переконв и перевсти деньги</b>
<form action="/convert">
    <p>сумма:<input type="text" name="sumto">
    <p>с какого кошелька:<input type="text" name="curFrom">
    <p>на какой:<input type="text" name="curTo">
        drfo <input type="text" name="drfo1">
        <input type="submit" value="convert">
</form>


<b>Посмотреть баланс в гривне по всем считам</b>
<form action="/allServlet">

    <p>drfo:<input type="text" name="drfoAll">
        <input type="submit" value="просмотреть">
</form>
</body>





</html>