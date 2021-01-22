<%-- 
    Document   : searchResult
    Created on : 22 Jan, 2021, 10:07:49 AM
    Author     : 181361M
--%>

<%@page import="sg.edu.nyp.bf.Flight"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Jetsun - Search Result TEST</title>
    </head>
    <body>
        <p>
            <!--A reminder note to the user on the search term he used-->
            Search results for flight to <b>"<%=session.getAttribute("des")%>"</b>
        </p>
        <hr/>
        <p>
            <table>
                <tr><th>Flight No.</th><th>Departure</th><th>Departure Date(s)</th><th>Destination</th><th>Seat Vacancy</th></tr>
                <%
                    List<Flight> searchResult = (List<Flight>) session.getAttribute("searchresult");
                    if(searchResult == null || searchResult.size() <= 0) {
                %>
            <tr><td colspan="6">(No result is found)</td></tr>
                <%
                    } else {
                        for(Flight flight : searchResult) {
                %>
                <tr>
                    <td><%=flight.getFlightCode()%></td>
                    <td><%=flight.getDepature()%></td>
                    <td><%=flight.getDepatureDate()%></td>
                    <td><%=flight.getDestination()%></td>
                    <td><%=flight.getFlightVacancy()%></td>
                    <td><input type="submit" value="Book Flight"></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </p>
        <hr/>
        <a href="searchFlight.jsp">Do another search</a><br/>
        <a href="index.html">Go back to menu</a>
    </body>
</html> 

