<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Customer Management</h1>
<form action="/translated">
    <label>Enter English Keyword: </label>
    <input type="text" name="keyword" placeholder="Enter Keyword">

    <input type="submit" value="Translate">

    <h2>The result is: <span style="color: indianred">${result}</span></h2>
</form>
</body>
</html>