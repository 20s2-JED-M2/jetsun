<%-- 
    Document   : searchFlight
    Created on : 22 Jan, 2021, 10:06:21 AM
    Author     : 181361M
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Jetsun - Search Test</title>
    </head>
    <body>
        <h1>Welcome Passenger</h1>
        <form action="search" method="post">
            <p>Please enter your destination: <input type="text" name="des"/><br/></p>
            <p>Please enter your departure: <input type="text" name="dep"/><br/></p>
            <p>Please enter your departure date: <input type="text" name="depdate"/><br/>
            <input type="submit" value="Search"/>
            <br/></p>
        </form>
        <a href="index.html">Back</a>
    </body>
</html>
