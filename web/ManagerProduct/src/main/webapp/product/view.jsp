<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 18/01/2024
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Information
    </title>
</head>
<body>
<table>
    <tr>
        <td>Id: ${p.id}</td>
        <td>name: ${p.name}</td>
        <td>price: ${p.price}</td>
        <td>
            <button onclick="window.location.href='/'">cancel</button>
        </td>
    </tr>
</table>
</body>
</html>
