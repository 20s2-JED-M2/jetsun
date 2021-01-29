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
        
        request.getSession().setAttribute("NRIC", "123213");
                
        // simple test
        response.sendRedirect(this.getServletContext().getContextPath() + "/changePassword.jsp");
    }
}
