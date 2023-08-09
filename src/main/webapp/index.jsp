<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tabulation</title>
</head>
<body>
<h1>Tabulate function</h1>
<form method="post" action="main">
    <table>
        <tr>
            <td><label for="start">Start:</label></td>
            <td><input id="start" type="number" name="start" step="0.01"></td>
        </tr>
        <tr>
            <td><label for="finish">Finish:</label></td>
            <td><input id="finish" type="number" name="finish" step="0.01"></td>
        </tr>
        <tr>
            <td><label for="step">Step:</label></td>
            <td><input id="step" type="number" name="step" step="0.01"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Tab"></td>
        </tr>
    </table>
</form>
</body>
</html>