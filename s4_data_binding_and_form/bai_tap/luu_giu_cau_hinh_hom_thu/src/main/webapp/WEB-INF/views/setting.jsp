<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Greeting</title>
</head>
<body>

<table style="width: 500px;">
    <form:form modelAttribute="setting" action="/setting" method="post">
        <tr>
            <th><h1>Settings</h1></th>
        </tr>
        <tr>
            <td style="width: 20%;">Languages:</td>
            <td style="width: 80%;"><form:select path="language" items="${languageList}"></form:select></td>
        </tr>
        <tr>
            <td>Page Sizes:</td>
            <td>Show <form:select path="pageSize" items="${pageList}"></form:select> emails per page</td>
        </tr>
        <tr>
            <td>Spam Filter:</td>
            <td><form:checkbox path="spamFilter"></form:checkbox>Enable spams filter</td>
        </tr>
        <tr>
            <td>Signature:</td>
            <td><form:textarea path="signature"></form:textarea></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Submit"> <input type="reset" value="Cancel"></td>

        </tr>
    </form:form>
</table>
</body>
</html>