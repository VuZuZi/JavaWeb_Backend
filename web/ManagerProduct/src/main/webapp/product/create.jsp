<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 18/01/2024
  Time: 07:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <form action="prodcut" method="post">
    <input type="hidden" name="action" value="create">
    <tr>
        <td>
            <label for="i">ID</label>
        </td>
        <td>
        <input type="number" name="id" id="i">
        </td>
    </tr>
        <tr>
        <td>
            <label for="name">name</label>
        </td>
        <td>
            <input name="nameNew" id="name">
        </td>
        </tr>
        <tr>
        <td>
            <label for="price">Gía</label>
        </td>
        <td>
            <input type="number" name="price" id="price">
        </td>

    </tr>
        <tr>
            <td>
                <button>create</button>
            </td>
        </tr>

    </form>
</table>
</body>
</html>
