package sg.edu.nyp.am;

import java.io.IOException;
import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gotochangepassword")
public class GoToChangePassword extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // retrieve NRIC from session
        String nric = (String) request.getSession().getAttribute("NRIC");
        
        request.getSession().setAttribute("customerNRIC", nric);
                
        // simple test
        response.sendRedirect(this.getServletContext().getContextPath() + "/changePassword.jsp");
    }
}
