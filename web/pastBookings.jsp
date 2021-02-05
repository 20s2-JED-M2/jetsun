
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
                <%
                    List<Booking> retrieveBookings = (List<Booking>) session.getAttribute("booking");                    
                    List<Seat> retrieveSeats = (List<Seat>) session.getAttribute("seat");
                    List<Customer> retrieveCustomers = (List<Customer>) session.getAttribute("customer");
                    List<Flight> retrieveFlights = (List<Flight>) session.getAttribute("flight");
                  
                    for (int index = 0; index < retrieveCustomers.size(); index++) {
                %>
                <tr>
                    <td><%=retrieveCustomers.get(index).getNricNo()%></td>
                    <td><%=retrieveCustomers.get(index).getName()%></td>
                    <td><%=retrieveCustomers.get(index).getPassportNo()%></td>
                    <td><%=retrieveFlights.get(index).getFlightcode()%></td>
                    <td><%=retrieveFlights.get(index).getDeparture()%></td>
                    <td><%=retrieveFlights.get(index).getDestination()%></td>
                    <td><%=retrieveFlights.get(index).getDepartureDate()%></td>
                    <td><%=retrieveSeats.get(index).getSeatNum()%></td>
                    <td><%=retrieveBookings.get(index).getTimestamp()%></td>
                    </tr>
                <%
                } 
                %>
            </table>
        </div>
        <br><hr><br>
        <a href="menu.jsp">Back to menu</a>
    </body>
</html>