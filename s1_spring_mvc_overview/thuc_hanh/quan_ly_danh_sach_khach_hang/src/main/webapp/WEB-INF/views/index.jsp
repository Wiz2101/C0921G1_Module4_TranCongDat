<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>
<h1>Customer Management</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${customerList}" var="customerList">
        <tr>
            <td>${customerList.id}</td>
            <td><a href="/customer/edit/${customerList.id}">${customerList.name}</a></td>
            <td>${customerList.email}</td>
            <td>${customerList.address}</td>
            <td><a href="/customer/delete/${customerList.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>