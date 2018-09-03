<%--
  Created by IntelliJ IDEA.
  User: dgorb
  Date: 24.08.2018
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html >
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prj1</title>
</head>

<body>
<h1>Edit user <c:out value="${param.username}"/></h1>

<form action="/users/update" method="post">
    <input type="hidden" name = "userId" value="${param.userId}">
    <input type="text" name="username" value="${param.username}" disabled>
    <input type="text" name="firstName"  value="${param.firstName}" placeholder="${param.firstName}">
    <input type="text" name="lastName" value="${param.lastName}" placeholder="${param.lastName}">
    <input type="text" name="age" value="${param.age}" placeholder="${param.age}">
    <input type="text" name="registerDate" value="${param.registerDate}" disabled>
    <input type="text" name="activity" value="${param.activity}" placeholder="${param.activity}">
   <!-- <input type="hidden" name="_method" value="put"> -->
    <input type="submit" value="Save">
</form>

</body>
</html>
