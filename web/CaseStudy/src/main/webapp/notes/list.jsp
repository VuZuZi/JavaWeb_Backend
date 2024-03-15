<%--
  Created by IntelliJ IDEA.
  User: markd
  Date: 29/01/2024
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>
        test ok
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="bootstrap-5.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://cdn.datatables.net/1.13.7/css/dataTables.bootstrap5.min.css">

</head>
<body>

<table id="example" class="table table-striped" style="width:100%">
    <thead>
    <tr>
        <th>Stt </th>
        <th>Tiêu đề</th>
        <th>Phân loại</th>
        <th></th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="n" items="${list}">
        <tr>
            <td><c:out value="${n.id}"/></td>
            <td><c:out value="${n.title}"/></td>
            </button>
<%--            <td><c:out value="${n.des}"/></td>--%>
            <td><c:out value="${n.type}"/></td>
            <td>
                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#infModal${user.id}">
                    Inf
                </button>

                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#delModal${user.id}">
                    Delete
                </button>
                <div class="modal" id="delModal${user.id}">
                    <div class="modal-dialog">
                        <div class="modal-content">

                            <!-- Modal Header -->
                            <div class="modal-header">
                                <h4 class="modal-title">Warning</h4>
                                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                            </div>

                            <!-- Modal body -->
                            <div class="modal-body">
                                This action cannot be return
                            </div>

                            <!-- Modal footer -->
                            <div class="modal-footer">
                                <button type="button" class="btn btn-warning" data-bs-dismiss="modal" onclick="window.location.href='/users?action=delete&id=${user.id}'">Delete</button>
                            </div>

                        </div>
                    </div>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<footer class="footer bg-info">
    <div class="container text-center">
        <p>&copy; 2022 Your Company. All rights reserved.</p>
    </div>
</footer>
</body>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script src="https://cdn.datatables.net/1.13.7/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    new DataTable('#example');
</script>
</html>
