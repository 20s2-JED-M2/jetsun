<%-- 
    Document   : bookFlight
    Created on : 22 Jan, 2021, 10:30:44 AM
    Author     : 181361M
--%>
<%@page import="sg.edu.nyp.bf.Book"%>
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
                List<Book> searchResult = (List<Book>) session.getAttribute("searchresult");
                if(searchResult == null || searchResult.size() <= 0) {
            %>
        <form action="flightList" method="post">
            <p>
                Selected Flight No.: <%=booking.getFlightCode()%>
                Selected Departure: <%=booking.getDepature()%>
                Selected Departure Date: <%=booking.getDepatureDate()%>
                Selected Destination: <%=booking.getDestination()%>
                Select a seat: <select name="seat">
                    <c:forEach items="${listSeat}" var="seat">
                        <option value="${seat.id}">${seat.seatNum}></option>
                    </c:forEach>
                </select>
                    <%
                        }
                    }
                %>
            </p>
            <input type="submit" value="Confirm Flight">
        </form>
    </body>
</html>
