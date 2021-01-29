package sg.edu.nyp.am;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nyp.entities.Customer;

@WebServlet("/changepassword")
public class ChangePasswordServlet extends HttpServlet {
    
    @EJB
    private PasswordBean passwordBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        // get name parameter and init 
        String oldpass = request.getParameter("oldpassword");
        String newpass = request.getParameter("newpassword");
//        String cmfnewpass = request.getParameter("cfmnewpassword");
        String nric = request.getSession().getAttribute("NRIC").toString();
        
            
            // if newpass and cmfnewpass is same
            Boolean passwordChanged;
            
            // call EJB to connect with DB
            passwordChanged = passwordBean.changePass(nric, oldpass, newpass);
        
            if (passwordChanged.equals(true)) {
                // if password successfully updated
                response.setContentType("text/html");
                PrintWriter pw=response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Your password has been changed!');");
                pw.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("index.html");
                rd.include(request, response);
            } 
            else {
                // if password failed to change
                response.setContentType("text/html");
                PrintWriter pw=response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Error occurred, password failed to change!');");
                pw.println("</script>");
                RequestDispatcher rd=request.getRequestDispatcher("changePassword.jsp");
                rd.include(request, response);
            }
        
    }
}
