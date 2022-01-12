<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Customer Edit</h1>
<form action="/customer/edit" method="post">
<label>ID</label>
<input type="text" value="${customer.id}" name="id" placeholder="ID" readonly>
<label>ID</label>
<input type="text" value="${customer.name}" name="name" placeholder="Enter Name">
<label>ID</label>
<input type="text" value="${customer.email}" name="email" placeholder="Enter Email">
<label>ID</label>
<input type="text" value="${customer.address}" name="address" placeholder="Enter Address">
<input type="submit" value="Save Changes">
</form>
</body>
</html>
