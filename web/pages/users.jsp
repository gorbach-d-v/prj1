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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prj1</title>
</head>

<body>
<a href="/">Home</a>
<h1 align="center">Users</h1>
<h2>All users table</h2>
<table id="users" border="1">
    <tr>
        <td>id</td>
        <td>Username</td>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Age</td>
        <td>Register date</td>
        <td>Interested in</td>
        <td>Actions</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.userId}</td>
            <td>${user.username}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.age}</td>
            <td>${user.registerDate}</td>
            <td>${user.activity}</td>
            <td>
                <form action = "pages/updateUser.jsp" method="post">
                    <input type="hidden" name="userId" value="${user.userId}">
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="firstName" value="${user.firstName}">
                    <input type="hidden" name="lastName" value="${user.lastName}">
                    <input type="hidden" name="age" value="${user.age}">
                    <input type="hidden" name="registerDate" value="${user.registerDate}">
                    <input type="hidden" name="activity" value="${user.activity}">
                    <input type="submit" value="Edit">
                </form>
            </td>
            <%--<td>--%>
                <%--<form action="deleteUser.jsp" method="post">--%>
                    <%--<input type="hidden" name="id" value="${user.getId()}">--%>
                    <%--<input type="submit" value="???????" style="float:left">--%>
                <%--</form>--%>
            <%--</td>--%>
        </tr>
    </c:forEach>
</table>

<form action="users" method="post">
    <input type="hidden" name="firstRow" value="${firstRow}">
    <input type="hidden" name="countRow" value="${countRow}">
    <c:choose>
        <c:when test="${firstRow == 0}">
            <input type="submit" name="page" value="previous" disabled>
            Shown: <c:out value="${firstRow+1}"/>-<c:out value="${firstRow+countRow}"/> from <c:out value="${countUser}"/> users
        </c:when>
        <c:otherwise>
            <input type="submit" name="page" value="previous">
            Shown: <c:out value="${firstRow+1}"/>-<c:out value="${countUser}"/> from <c:out value="${countUser}"/> users
        </c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="${firstRow + countRow >= countUser}">
            <input type="submit" name="page" value="next" disabled>
        </c:when>
        <c:otherwise>
            <input type="submit" name="page" value="next">
        </c:otherwise>
    </c:choose>
</form>

<h2>Create new user</h2>

<form action="users" method="post">
    <label>Username</label> <input type="text" name="username" id="username"><br/>
    <label>Password</label> <input type="password" name="password" id="password"><br/>
    <label>First name</label> <input type="text" name="firstName" id="firstName"><br/>
    <label>Last Name</label> <input type="text" name="lastName" id="lastName"><br/>
    <label>Age</label> <input type="text" name="age" id="age"><br/>
    <label>Activity</label> <input type="text" name="activity" id="activity"><br/>
    <input type="submit" name="page" value="create">
</form>

</body>
</html>
