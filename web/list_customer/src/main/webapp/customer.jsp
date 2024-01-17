<!doctype html>
<html lang="en">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h2>Danh sách khách hàng</h2>
<%--<a href="/customer">s</a>--%>
<table>
    <tr>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>Địa chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach var="item" items="${list}">
        <tr>
            <td>${item.name}</td>
            <td>${item.date}</td>
            <td>${item.address}</td>
            <td><img src="${item.image}" width="60px"></td>
        </tr>
    </c:forEach>
<%--    <img style="width: 600px" src="img.png">--%>


</table>


</body>
</html>