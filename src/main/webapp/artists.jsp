<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 09.08.2023
  Time: 18:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Artists</title>
    <link rel="stylesheet" href="styles.css" type="text/css">
</head>
<body>
<jsp:useBean id="ab" class="com.example.web0908.data.ArtistBean" scope="request"/>
<form method="post" action="add_artist">
    <label for="artist">New artist:</label>
    <input id="artist" type="text" name="artist" required>
    <input type="submit" value="Add">
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Artist</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ab.artists}" var="a">
        <tr>
            <td>${a.id}</td>
            <td>${a.name}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
