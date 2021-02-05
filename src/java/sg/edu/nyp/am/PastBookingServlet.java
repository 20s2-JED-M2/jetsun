package sg.edu.nyp.am;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nyp.entities.Booking;
import sg.edu.nyp.entities.Customer;

@WebServlet("/pastbookings")
public class PastBookingServlet extends HttpServlet {
    
    @EJB
    private BookingBean bookingBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Object> verifyResult;
        
        request.getSession().setAttribute("nricNo", "123213");
        
        verifyResult = bookingBean.retrieveBookings(request.getSession().getAttribute("nricNo").toString());
        
//        for (int i=0; i<verifyResult.size() ; i++) {
//            System.out.println(verifyResult.get(i));
//        }
        System.out.println(verifyResult.get(0));        
        System.out.println(verifyResult.get(1));
        System.out.println(verifyResult.get(2));
        System.out.println(verifyResult.get(3));


        request.getSession().setAttribute("booking", verifyResult.get(0));        
        request.getSession().setAttribute("seat", verifyResult.get(1));
        request.getSession().setAttribute("customer", verifyResult.get(2));
        request.getSession().setAttribute("flight", verifyResult.get(3));
        
        response.sendRedirect(this.getServletContext().getContextPath() + "/pastBookings.jsp");
    }
}
