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
<a style="margin-bottom: 20px" href="/create">Back to Setting</a>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Date of Birth</th>
        <th>Gender</th>
        <th>Nationality</th>
        <th>ID/Passport</th>
        <th>Transportation</th>
        <th>Vehicle ID</th>
        <th>Seats</th>
        <th>Departure Date</th>
        <th>Arrival Date</th>
        <th>Report</th>
        <th>Province</th>
        <th>District</th>
        <th>Ward</th>
        <th>Address</th>
        <th>Phone Number</th>
        <th>Email</th>
        <th>Fever</th>
        <th>Cough</th>
        <th>Shorten Breath</th>
        <th>Sore Throat</th>
        <th>Vomit</th>
        <th>Diarrhea</th>
        <th>Skin Hemorrhage</th>
        <th>Skin Rash</th>
        <th>Animal Record</th>
        <th>Contact Record</th>
    </tr>
    <c:forEach items="${personList}" var="personList" varStatus="list">
    <tr>
        <td>${list.count}</td>
        <td>${personList.name}</td>
        <td>${personList.dOB}</td>
        <td>${personList.gender}</td>
        <td>${personList.nationality}</td>
        <td>${personList.id}</td>
        <td>${personList.transportation}</td>
        <td>${personList.vehicleId}</td>
        <td>${personList.seats}</td>
        <td>${personList.departure}</td>
        <td>${personList.arrival}</td>
        <td>${personList.report}</td>
        <td>${personList.province}</td>
        <td>${personList.district}</td>
        <td>${personList.ward}</td>
        <td>${personList.address}</td>
        <td>${personList.phoneNumber}</td>
        <td>${personList.email}</td>
        <td>${personList.fever}</td>
        <td>${personList.cough}</td>
        <td>${personList.shortenBreath}</td>
        <td>${personList.soreThroat}</td>
        <td>${personList.vomit}</td>
        <td>${personList.diarrhea}</td>
        <td>${personList.skinHemorrhage}</td>
        <td>${personList.skinRash}</td>
        <td>${personList.animalHistory}</td>
        <td>${personList.contactHistory}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
