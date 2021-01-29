<%-- 
    Document   : bookFlight
    Created on : 22 Jan, 2021, 10:30:44 AM
    Author     : 181361M
--%>

<%@page import="sg.edu.nyp.entities.Seat"%>
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
                List<Seat> listSeat = (List<Seat>) session.getAttribute("seatlist");  
            %>
        <form action="addseat" method="post">
                <input type="hidden" name="nric" value="<%=session.getAttribute("nricno")%>">
            <p>
                Selected Flight No.: <%=flight.getFlightCode()%><br>
                Selected Departure: <%=flight.getDeparture()%><br>
                Selected Departure Date: <%=flight.getDepartureDate()%><br>
                Selected Destination: <%=flight.getDestination()%><br>
                Select a seat: <select name="seat" required>
                    <%
                     for(Seat seat : listSeat) {
                    %>
                    <option value="<%=seat.getId()%>"><%=seat.getSeatNum()%></option>
                    <%
                        }
                %>
                    
                </select><br>
                   <input type = "hidden" name="Fcode" value="<%=flight.getFlightCode()%>">                 
            </p>
            <input type="submit" value="Confirm Flight">
        </form>
            <a href="index.html">Go back to menu</a>
    </body>
</html>
