<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 09.08.2023
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tab result</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<jsp:useBean id="tb" class="com.example.web0908.logic.TabulationBean" scope="request"/>

<h1>Max = ${tb.maxPoint.y} with x = ${tb.maxPoint.x}</h1>
<table>
    <thead>
    <tr>
        <th>X</th>
        <th>Y</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${tb.points}" var="p">
        <tr>
            <td>${p.x}</td>
            <td>${p.y}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
