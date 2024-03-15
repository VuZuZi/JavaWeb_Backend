<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 31/01/2024
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><html>
<head>
    <title>

    </title>
</head>
<body>
${a}
<table>

<c:forEach var="p" items="${list}">
    <tr>
        <td>${p.stt}</td>
        <td>${p.ten}</td>
        <td><c:out value="${p.stt}"/></td>
        <td></td>
        <td></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
