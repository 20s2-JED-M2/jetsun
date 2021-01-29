<%-- 
    Document   : login
    Created on : 29 Jan, 2021, 9:41:55 AM
    Author     : 181546Z
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form name="login" method="post" action="login">
            Email Address: <input type="email" name="email"><br/>
            Password: <input type="password" name="password"><br/>
            <input type="submit" value="Login"><br/>
        </form>
        <a href="registration.jsp">Don't have an account? Register here!</a>
    </body>
</html>
