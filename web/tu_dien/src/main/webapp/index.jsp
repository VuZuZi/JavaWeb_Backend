<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Vietnamese Ditionary
</h1>
<br>
<form action="/translate" method="post">
    <input type="text" name="text">
    <button type="submit">Search</button>
</form>
<br>
<h2>Result: ${re}</h2>

</body>
</html>