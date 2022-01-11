<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Customer Management</h1>
<form action="/converted">
    <label>USD</label>
    <input type="text" name="usd" placeholder="Enter Amount of USD">
    <label>Rate</label>
    <input type="text" name="rate" placeholder="Enter the rate">
    <input type="submit" value="Convert">

    <h2>The result is: <span style="color: indianred">${result}</span> VND</h2>
</form>
</body>
</html>