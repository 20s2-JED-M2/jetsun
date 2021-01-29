/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.cr;

import java.security.MessageDigest;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sg.edu.nyp.entities.Customer;

/**
 *
 * @author 181910H
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    @EJB
    private CustomerBean customerBean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException {

        String nricNo = request.getParameter("nricNo");
        String title = request.getParameter("title");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String homeAdd = request.getParameter("homeAdd");
        String passportNo = request.getParameter("passportNo");
        String passportExpiry = request.getParameter("passportExpiry");
        String mobilePhone = request.getParameter("mobilePhone");
        String billingAdd = request.getParameter("billingAdd");
        String dob = request.getParameter("dob");
        String officePhone = request.getParameter("officePhone");
        String homePhone = request.getParameter("homePhone");
        String krisFlyer = request.getParameter("krisFlyer");
        String password = request.getParameter("password");
        
        
        Customer customer = customerBean.register(nricNo, title, name, email, homeAdd, passportNo, passportExpiry, mobilePhone, billingAdd, dob, officePhone, homePhone, krisFlyer, password);
        response.sendRedirect(this.getServletContext().getContextPath() + "/login.jsp");
    }

}
