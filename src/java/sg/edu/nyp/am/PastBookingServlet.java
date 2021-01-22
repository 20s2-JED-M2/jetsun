package sg.edu.nyp.am;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nyp.entities.Customer;

@WebServlet("/pastbookings")
public class PastBookingServlet extends HttpServlet {
    
    @EJB
    private BookingBean bookingBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nricNo = null;
        String flightCode;
        int seatId;
        
        List<Customer> verifyResult;
        
        verifyResult = bookingBean.verifyNricNo(nricNo);
        //Rusyda and Spelmen Continue from here next week
        
        // simple test
        response.sendRedirect(this.getServletContext().getContextPath() + "/pastBookings.jsp");
    }
}
