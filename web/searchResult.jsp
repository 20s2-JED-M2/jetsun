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
        <title>Jetsun - Search Result</title>
    </head>
    <body>
        <p>
            <!--A reminder note to the user on the search term he used-->
            Search results for flight from <b>"<%=session.getAttribute("dep")%>"</b> to <b>"<%=session.getAttribute("des")%>"</b>
        </p>
        <hr/>
        <p>
            <table>
                <tr><th>Flight No.</th><th>Departure</th><th>Departure Date(s)</th><th>Destination</th><th>Seat Vacancy</th></tr>
                <%
                    List<Flight> searchResult = (List<Flight>) session.getAttribute("flightList");
                    if(searchResult == null || searchResult.size() <= 0) {
                %>
            <tr><td colspan="6">(No result is found)</td></tr>
                <%
                    } else {
                        for(Flight flight : searchResult) {
                %>
                <form name="searchflightresult" action="searchresult" method="post">
                <tr>
                    <td><%=flight.getFlightCode()%></td>
                    <input type = "hidden" name="flightCode" value="<%=flight.getFlightCode()%>"> 
                    <td><%=flight.getDeparture()%></td>
                    <input type = "hidden" name="departure" value="<%=flight.getDeparture()%>"> 
                    <td><%=flight.getDepartureDate()%></td>
                    <input type = "hidden" name="departureDate" value="<%=flight.getDepartureDate()%>"> 
                    <td><%=flight.getDestination()%></td>
                    <input type = "hidden" name="destination" value="<%=flight.getDestination()%>"> 
                    <td><%=flight.getFlightVacancy()%></td>
                    <input type = "hidden" name="flightVacancy" value="<%=flight.getFlightVacancy()%>"> 
                    <td><input type="submit" value="Book Flight"></td>
                </tr>
                </form>
                <%
                        }
                    }
                %>
            </table>
        </p>
        <hr/>
        <a href="searchFlight.jsp">Do another search</a><br/>
        
        <a href="menu.jsp">Go back to menu</a>
    </body>
</html> 

