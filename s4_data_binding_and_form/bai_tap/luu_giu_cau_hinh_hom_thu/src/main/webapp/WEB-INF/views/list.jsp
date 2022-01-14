<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tranc
  Date: 1/13/2022
  Time: 12:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Settings</h1>
<a style="margin-bottom: 20px" href="/setting">Back to Setting</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Language</th>
        <th>Page Sizes</th>
        <th>Spam Filter</th>
        <th>Signature</th>
        <th>Action</th>
    </tr>
    <c:forEach items="${settingList}" var="settingList" varStatus="list">
    <tr>
        <td>${list.count}</td>
        <td>${settingList.language}</td>
        <td>${settingList.pageSize}</td>
        <td>${settingList.spamFilter}</td>
        <td>${settingList.signature}</td>
        <td><a href="/edit/${list.index}">Edit</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
