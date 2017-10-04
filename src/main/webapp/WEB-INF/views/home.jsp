<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <div align="center">
        <h1>Welcome to the home page </h1>
        <a href="<c:url value="/categories"/> "> Categories page</a> <br>
        <a href="<c:url value="/registration"/> "> Registration page</a> <br>
    </div>
</body>
</html>
