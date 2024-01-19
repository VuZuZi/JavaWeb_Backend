<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="/users?action=create">Add New User</a>
    </h2>
    <h2>

            <table>
                <form action="/user">
                <tr>
                    <td>
                        <label for="nameSearch">Search by name</label>
                    </td>
                    <td>
                        <input id="nameSearch" name="nameSearch">
                    </td>
                    <td>
                        <input type="hidden" name="action" value="searchByName">
                        <button type="submit">Search</button>
                    </td>
                </tr>
                </form>
                <form action="/user">
                <tr>
                    <td>
                        <label for="countrySearch">Search by country</label>
                    </td>
                    <td>
                        <input id="countrySearch" name="countrySearch">
                    </td>
                    <td>
                        <input type="hidden" name="action" value="searchByCountry">
                        <button type="submit">Search</button>
                    </td>
                </tr>
            </table>
        </form>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Country</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td><c:out value="${user.country}"/></td>
                <td>
                    <a href="/users?action=edit&id=${user.id}">Edit</a>
                    <a href="/users?action=delete&id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
