<%--
  Created by IntelliJ IDEA.
  User: dgorb
  Date: 24.08.2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>


<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prj1</title>

</head>

<body>
<a href="/">Home</a>
<h1 align="center">Users</h1>
<table id="users">
    <tr>
        <td>id</td>
        <td>Username</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Age</td>
        <td>Register date</td>
        <td>Interested in</td>
    </tr>
    <tr>
        <td>${user.userId}</td>
        <td>${user.username}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>${user.age}</td>
        <td>${user.registerDate}</td>
        <td>${user.activity}</td>
    </tr>
</table>
</div>

</body>
</html>
