<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" name="condiment" value="lettuce">Lecttuce
    <input type="checkbox" name="condiment" value="tomato">Tomato
    <input type="checkbox" name="condiment" value="mustard">Mustard
    <input type="checkbox" name="condiment" value="sprouts">Sprouts
    <input type="submit" value="Save">
</form>
<h3>Condiments add into sandwich are: <span style="color: indianred"><c:forEach items="${condiment}" var="condimentList">${condimentList},</c:forEach></span></h3>

</body>
</html>