<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculate">
    <input type="text" name="number1" placeholder="Enter Number" value="${input1}">
    <input type="text" name="number2" placeholder="Enter Number" value="${input2}">
    <button name="formula" value="+">Addition(+)</button>
    <button name="formula" value="-">Subtraction(-)</button >
    <button name="formula" value="*">Multiplication(*)</button>
    <button name="formula" value="/">Division(/)</button>
</form>
<h3>The result is: <span style="color: indianred">${result}</span></h3>

</body>
</html>