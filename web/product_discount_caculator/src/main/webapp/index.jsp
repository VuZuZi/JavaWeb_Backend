<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/caculator" method="post">
    <table>
        <tr>
            <td><label for="pro">Product Description</label></td>
            <td><input id="pro" type="text" name="pro"></td>
        </tr>
        <tr>
            <td><label for="pri">List Price</label></td>
            <td><input type="number" id="pri" name="price"></td>
        </tr>
        <tr>
            <td><label for="dis">Discount Percent(%)</label></td>
            <td>
                <input id="dis" type="number" name="dis">
            </td>
        </tr>
        <tr>
            <td><button type="submit">Send</button></td>
        </tr>
    </table>
</form>
</body>
</html>