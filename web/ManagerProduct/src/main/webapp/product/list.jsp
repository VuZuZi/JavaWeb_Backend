<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 17/01/2024
  Time: 18:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
    <title>
        Danh sách sản phẩm
    </title>
</head>
<body>
<div class="container center-text">
    <table border="1" class="table table-header ">
        <thead>
        <tr>
            <td style="width: 5%"><button onclick="window.location.href='/product?action=create'" class="btn btn-warming">Create</button></td>
            <td>
                <form action="/product" method="get">
                    <input type="hidden" name="action" value="search">
                    <label for="k">Search by name</label>
                    <input id="k" name="key">
                    <button>Search</button>
                </form>
            </td>
        </tr>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th colspan="2" >button</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="o" items="${list}">
        <tr>
            <td>${o.id}</td>
            <td>${o.name}</td>
            <td>${o.price}</td>
            <td style="width: 5%"><button onclick="window.location.href='/product?action=inf&id=${o.id}'" class="btn btn-warming">Infor</button></td>

            <td style="width: 5%"><button onclick="window.location.href='/product?action=update&id=${o.id}'" class="btn btn-warming">Update</button></td>

        <%--            <form action="delete" method="post">--%>
<%--                <input type="hidden" value="${o.id}" name="id">--%>
                <td style="width: 5%"><button onclick="window.location.href='/product?action=delete&id=${o.id}'" class="btn btn-warming">Delete</button></td>
<%--            </form>--%>


        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
