<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 17/01/2024
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update product</title>
</head>
<body>
<form action="/product" method="post">
<table>
    <tr>
        <th>Name</th>
        <td><input type="text" value="${pUpdate.name}" name="name"></td>
    </tr>
    <tr>
        <th>price</th>
        <td><input type="number" value="${pUpdate.price}" name="price"></td>
    </tr>
    <tr>
        <td>
            <input type="hidden" value="${pUpdate.id}" name="id">
            <button onclick="window.location.href='/'">Cancel</button>
        </td>
        <td>
            <input type="hidden" name="action" value="update">
            <button type="submit">Update</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
