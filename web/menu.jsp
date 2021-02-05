<%-- 
    Document   : menu
    Created on : 29 Jan, 2021, 9:53:43 AM
    Author     : 181546Z
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <h1>Welcome, <%=request.getSession().getAttribute("Name")%></h1>
        <a href="searchFlight.jsp">Search Flight</a>
                <form action="pastbookings" method="POST">
            <input type="submit" value="View Past Bookings">
        </form>
        <!-- Temporary redirecting to Change Password page, to be removed afterwards -->
        <form action="gotochangepassword" method="get">
            <input type="submit" value="Go To Change Password">
        </form>
        <form action="logout" method="post">
	    <input type="submit" value="Log Out"/>
	</form>
    </body>
</html>
