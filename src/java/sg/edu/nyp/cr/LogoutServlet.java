/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.cr;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author 181910H
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {   
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //End the session
        HttpSession session = request.getSession();
        session.invalidate();
        //Or Alternatively, request.getSession().invalidate();
        
        //Do a client-side redirect to the index page
        response.sendRedirect(this.getServletContext().getContextPath()+ "/login.jsp");
    }
}