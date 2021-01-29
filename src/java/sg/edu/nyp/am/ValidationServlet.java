/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sg.edu.nyp.am;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author 182061K
 */
@WebServlet("/validatepassword")
public class ValidationServlet extends HttpServlet {

    @EJB
    private PasswordBean passwordBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String oldpass = request.getParameter("oldpassword");
        String newpass = request.getParameter("newpassword");
        String cmfnewpass = request.getParameter("cfmnewpassword");
        String nric = request.getSession().getAttribute("NRIC").toString();

            // if newpass and cmfnewpass is same
        Boolean passwordValidateOldPass;
        Boolean passwordValidateNewPass;

        System.out.println("Comparing user input old pass hash with old pass hash from db");
        // call EJB to connect with DB and use if statement to comapre
        passwordValidateOldPass = passwordBean.compareoldPass(nric, oldpass);

        // if old pass from db matches with user input old pass
        if (passwordValidateOldPass.equals(true)) 
        {
            System.out.println("Comparing new pass with confirm new pass");
            passwordValidateNewPass = passwordBean.compareNewPass(newpass, cmfnewpass);
            
            // if new pass matches with cmf new pass
            if (passwordValidateNewPass.equals(true)) {
                RequestDispatcher rd = request.getRequestDispatcher("/changepassword");
                rd.include(request, response);
            } 
            else {
                // if newpass does NOT match with cmfnewpass
                response.setContentType("text/html");
                PrintWriter pw = response.getWriter();
                pw.println("<script type=\"text/javascript\">");
                pw.println("alert('Error occurred, new password and comfirm password does not match!');");
                pw.println("</script>");
                RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
                rd.include(request, response);
            }
        } 
        else {
            // if old pass from db does NOT match with user input old pass
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Error occured, please type in your old password!');");
            pw.println("</script>");
            RequestDispatcher rd = request.getRequestDispatcher("changePassword.jsp");
            rd.include(request, response);
        }

    }
}
