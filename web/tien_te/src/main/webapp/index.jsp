<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency Converter</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
<h2>Currency Converter</h2>
<form method="post" action="/caculator">
    <label>Rate: </label><br/>
    <input type="number" name="rate" placeholder="RATE" value="0"/><br/>
    <label>USD: </label><br/>
    <input type="number" name="usd" placeholder="USD" value="${usa}"/><br/>
    <input type = "submit" id = "submit" value = "Converter"/>
</form>
</body>
</html>