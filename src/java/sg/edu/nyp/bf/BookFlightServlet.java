/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.bf;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
@WebServlet("/book")
public class BookFlightServlet extends HttpServlet{
    @EJB
    private FlightBean flightBean;
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Retrieve parameters
        String nricNo =  request.getParameter("nricNo");
        int flightCode = Integer.parseInt(request.getParameter("flightCode"));
        int seatId = Integer.parseInt(request.getParameter("seatId"));;
        String employeeId = null;
        java.sql.Date timestamp = new java.sql.Date(System.currentTimeMillis());
        Boolean bool;
        
        bool = flightBean.addBooking(nricNo, flightCode, seatId, employeeId, timestamp);
        
        if(bool == true){
            response.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
        }
        else{
            response.sendRedirect(this.getServletContext().getContextPath() + "/searchFlight.jsp");
        }

    }
}
