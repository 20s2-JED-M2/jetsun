/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.cr;

import java.io.IOException;
import java.util.ArrayList;
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
 * @author 181546Z
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @EJB
    private CustomerBean customerBean;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(session.getAttribute("customer") != null) {
                response.sendRedirect(this.getServletContext().getContextPath() + "/menu.jsp");
        } else {
            String email = (String)request.getParameter("email");
            String password = (String)request.getParameter("password");
            
            Customer customer = customerBean.login(email, password);
            String customerNRIC = customerBean.getNRIC(email);
            String customerName = customerBean.getname(customerNRIC);

            if(customer.getName() != null) {
                session.setAttribute("customer", customer);
                session.setAttribute("NRIC", customerNRIC);
                session.setAttribute("Name", customerName);
                response.sendRedirect(this.getServletContext().getContextPath() + "/menu.jsp");
            } else {
                session.setAttribute("errormessage", "Login fail!");
                response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp?login=fail");
            }
        }
    }
}
