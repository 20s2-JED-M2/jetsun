<%-- 
    Document   : bookFlight
    Created on : 22 Jan, 2021, 10:30:44 AM
    Author     : 181361M
--%>

<%@page import="sg.edu.nyp.bf.Booking"%>
<%@page import="sg.edu.nyp.bf.Flight"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Jetsun - Book Flight</title>
    </head>
    <body>
        <%--from searchflight, press book flight to here. should result available seats in dropdown box
            validation is needed for  seating--%>
        <h3>Your Selection</h3>
            <%
                Flight flight = (Flight)session.getAttribute("flight");      
            %>
        <form action="addseat" method="post">
            <%
                 %>
                <input type="hidden" name="nric" value="<%=session.getAttribute("nricno")%>">
            <p>
                Selected Flight No.: <%=flight.getFlightCode()%>
                Selected Departure: <%=flight.getDeparture()%>
                Selected Departure Date: <%=flight.getDepartureDate()%>
                Selected Destination: <%=flight.getDestination()%>
                Select a seat: <select name="seat" required>
                    <c:forEach items="${listSeat}" var="seat">
                        <option value="${seat.id}">${seat.seatNum}></option>
                    </c:forEach>
                </select>
                   <%
                   %>
                   <input type = "hidden" name="Fcode" value="<%=flight.getFlightCode()%>">                 
                          <%
                        }
                    }
                %>
            </p>
            <input type="submit" value="Confirm Flight">
        </form>
            <a href="index.html">Go back to menu</a>
    </body>
</html>
