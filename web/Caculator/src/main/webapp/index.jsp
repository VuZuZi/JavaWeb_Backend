<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<hh1>Simple Calculator</hh1>
<table>
    <form action="/calculator" method="post">
        <tr>
            <td>First operand</td>
            <td><input type="number" name="fNumber" value="0"></td>
        </tr>
        <tr>
            <td>Operator</td>
            <td>
                <select name="op">
                    <option value="+">addition</option>
                    <option value="-">Subtraction</option>
                    <option value="*">Multiplication</option>
                    <option value="/">Division</option>
                </select>

            </td>
        </tr>
        <tr>
            <td>Second operand</td>
            <td><input type="number" name="sNumber" value="0"></td>
        </tr>
        <tr>
            <td>
                <button>Send</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>