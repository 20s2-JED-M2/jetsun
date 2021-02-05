
<%@page import="sg.edu.nyp.entities.Seat"%>
<%@page import="sg.edu.nyp.entities.Flight"%>
<%@page import="sg.edu.nyp.entities.Booking"%>
<%@page import="sg.edu.nyp.entities.Customer"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Past Bookings</title>
    </head>
    <body>
        <h1>Your Booking</h1><hr><br>
        <div class="bookingtable">
            <table border="1">
                <tr>
                    <td>NRIC No</td>
                    <td>Name</td>
                    <td>Passport No</td>
                    <td>Flight Code</td>
                    <td>Departure</td>
                    <td>Destination</td>
                    <td>Departure Date</td>
                    <td>Seat No</td>
                    <td>Timestamp</td>
                </tr>
                <tr>
                <%
                    List<Booking> retrieveBookings = (List<Booking>) session.getAttribute("booking");                    
                    List<Seat> retrieveSeats = (List<Seat>) session.getAttribute("seat");
                    List<Customer> retrieveCustomers = (List<Customer>) session.getAttribute("customer");
                    List<Flight> retrieveFlights = (List<Flight>) session.getAttribute("flight");
                  
                    for (Customer customer : retrieveCustomers) {
                %>
                    <td><%=customer.getNricNo()%></td>
                    <td><%=customer.getName()%></td>
                    <td><%=customer.getPassportNo()%></td>
                <%
                }
                    for (Flight flight : retrieveFlights) {
                %>
                    <td><%=flight.getFlightcode()%></td>
                    <td><%=flight.getDeparture()%></td>
                    <td><%=flight.getDestination()%></td>
                    <td><%=flight.getDepartureDate()%></td>
                <%
                }
                    for (Seat seat : retrieveSeats) {
                %>
                    <td><%=seat.getSeatNum()%></td>
                <%
                }
                    for (Booking booking : retrieveBookings) {
                %>
                    <td><%=booking.getTimestamp()%></td>
                <%
                } 
                %>
                </tr>
            </table>
        </div>
        <br><hr><br>
        <a href="index.html">Back to index</a>
    </body>
</html>