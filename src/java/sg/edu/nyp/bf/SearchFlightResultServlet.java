/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nyp.bf;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sg.edu.nyp.entities.Seat;

/**
 *
 * @author 182281M
 */
@WebServlet("/searchresult")
public class SearchFlightResultServlet extends HttpServlet {

    @EJB
    private FlightBean flightBean;
    private Date departureDate;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Retrieve parameters
        int flightCode = Integer.parseInt(request.getParameter("flightCode"));
        String departure = request.getParameter("departure");
        String destination = request.getParameter("destination");
        int flightVacancy = Integer.parseInt(request.getParameter("flightVacancy"));
        
        Flight flight = new Flight();
        String departureDate = request.getParameter("departureDate");
        java.sql.Date departureDateSQL = java.sql.Date.valueOf(departureDate);

        flight.setFlightCode(flightCode);
        flight.setDeparture(departure);
        flight.setDestination(destination);
        flight.setDepartureDate(departureDateSQL);
        flight.setFlightVacancy(flightVacancy);
        
        List<Seat> flightSeats = flightBean.getSeats();

        //Set the search term and the search results in the session
        HttpSession session = request.getSession();
        session.setAttribute("flight", (Object) flight);
        session.setAttribute("seatlist", (Object) flightSeats);

        //Make a client side redirect to the search result page
        response.sendRedirect(this.getServletContext().getContextPath() + "/bookFlight.jsp");
    }
}
