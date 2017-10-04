<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Categories Page</title>
</head>
<body>
    <div align="center">
        <c:forEach var="category" items="#{categoryAtt}">
            <tr>
                <td>${category.id}</td>
                <td>${category.category_name}</td>
                <td>${category.description}</td>
                <br>
            </tr>
        </c:forEach>
    </div>
</body>
</html>
