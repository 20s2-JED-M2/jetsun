/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.bf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 182281M
 */
@WebServlet("/search")
public class SearchFlightServlet extends HttpServlet{
    @EJB
    private FlightBean flightBean;
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Retrieve parameters
        String departure = request.getParameter("dep");
        String destination = request.getParameter("des");
        
        List<Flight> flightList = new ArrayList<Flight>();
        flightList = flightBean.searchFlight(departure, destination);
        
        //Set the search term and the search results in the session
        HttpSession session = request.getSession();
        session.setAttribute("flightList", (Object) flightList);
        session.setAttribute("dep", departure);
        session.setAttribute("des", destination);
         
        //Make a client side redirect to the search result page
        response.sendRedirect(this.getServletContext().getContextPath() + "/searchResult.jsp");

    }
}
