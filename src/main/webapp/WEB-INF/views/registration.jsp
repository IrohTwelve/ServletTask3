<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>

    <div align="center">
        <form method="post" action="/registration">
            User Name:<input type="text" name="userName" /><br/>
            Password:<input type="text" name="password" /><br/>
            Email :<input type="text" name="email" /><br/>
            <input type="submit" value="register" />
        </form>
    </div>

</body>
</html>
