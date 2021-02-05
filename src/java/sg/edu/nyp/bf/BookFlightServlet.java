/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.bf;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sg.edu.nyp.entities.Customer;

/**
 *
 * @author 182281M
 */
@WebServlet("/addseat")
public class BookFlightServlet extends HttpServlet{
    @EJB
    private FlightBean flightBean;
    
    @Override 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        //Retrieve parameters
        HttpSession session = request.getSession();
        //Customer customer = (Customer)session.getAttribute("customer");
        //customer.getNricNo();
        
        
        String nricNo = "S1234123A";
        int flightCode = Integer.parseInt(request.getParameter("Fcode"));
        //int seatNum = Integer.parseInt(request.getParameter("seatNum"));
        int seatId = Integer.parseInt(request.getParameter("seat"));
        String employeeId = null;
        java.sql.Date timestamp = new java.sql.Date(System.currentTimeMillis());
        Boolean bool;
        
        bool = flightBean.addBooking(nricNo, flightCode, seatId, employeeId, timestamp);
        
        if(bool == true){
            
             response.sendRedirect(this.getServletContext().getContextPath() + "/index.html");
//            HttpSession session = request.getSession();
//            session.setAttribute("flightCode", flightCode);
//             session.setAttribute("seat", seatId);
//            response.sendRedirect(this.getServletContext().getContextPath() + "/checkout.jsp");
            
        }
        else{
            response.sendRedirect(this.getServletContext().getContextPath() + "/searchFlight.jsp");
        }

    }
}
