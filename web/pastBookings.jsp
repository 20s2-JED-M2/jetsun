<%@page import="java.util.List"%>
<%@page import="sg.edu.nyp.entities.Customer"%>
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
            <table name="FlightDetails" border="1">
                <tr>
                    <td>NRIC No</td>
                    <td>Name</td>
                    <td>Passport No</td>
                    <td>Flight Code</td>
                    <td>Timestamp</td>
                    <td>Departure</td>
                    <td>Destination</td>
                    <td>Departure Date</td>
                    <td>Seat No</td>
                </tr>
            </table>
        </div>
        <br><hr><br>
        <a href="index.html">Back to index</a>
    </body>
</html>