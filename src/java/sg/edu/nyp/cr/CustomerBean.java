/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.cr;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import sg.edu.nyp.entities.Customer;

/**
 *
 * @author 181910H
 */

@Stateless
public class CustomerBean {
    @Resource(name = "jdbc/project")
    private DataSource dsCustomerCatalogue;
    
    public Customer register(String nricNo, String title, String name, 
            String email, String homeAdd, String passportNo, String passportExpiry, String mobilePhone, String billingAdd, String dob,
            String officePhone, String homePhone, String krisFlyer, String password) {
        Customer customer = new Customer();
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        
        String sqlfind = "SELECT * FROM customer where email =?";
        
        try {
            connection = dsCustomerCatalogue.getConnection();
            preparedStatement = connection.prepareStatement(sqlfind);
            preparedStatement.setString(1, email);
            resultset = preparedStatement.executeQuery();
            
            if(!resultset.first()) {
                String sqladd = "INSERT INTO customer "
                        + "(nricNo, title, name, email, homeAdd, passportNo, passportExpiry, mobilePhone, billingAdd, dob, officePhone, homePhone, krisFlyer, password)"
                        + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SHA2(?,256));";
                preparedStatement = connection.prepareStatement(sqladd);
                preparedStatement.setString(1, nricNo);
                preparedStatement.setString(2, title);
                preparedStatement.setString(3, name);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, homeAdd);
                preparedStatement.setString(6, passportNo);
                preparedStatement.setString(7, passportExpiry);
                preparedStatement.setString(8, mobilePhone);
                preparedStatement.setString(9, billingAdd);
                preparedStatement.setString(10, dob);
                preparedStatement.setString(11, officePhone);
                preparedStatement.setString(12, homePhone);
                preparedStatement.setString(13, krisFlyer);
                preparedStatement.setString(14, password);
                preparedStatement.executeUpdate();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(resultset != null) {
                try {
                    resultset.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return customer;
    }
    
    public Customer login(String email, String password)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        Customer customer = new Customer();
        
        String sqlselect = "SELECT * FROM customer WHERE email = ? AND password = SHA2(?,256)";
        
        try {
            connection = dsCustomerCatalogue.getConnection();
            preparedStatement = connection.prepareStatement(sqlselect);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            System.out.println(preparedStatement);
            
            resultset = preparedStatement.executeQuery();
            
            if(resultset.first()) {
                customer.setName(resultset.getString("name"));
                customer.setNricNo(resultset.getString("nricNo"));
                customer.setTitle(resultset.getString("title"));
                customer.setEmail(resultset.getString("email"));
                customer.setHomeAdd(resultset.getString("homeAdd"));
                customer.setBillingAdd(resultset.getString("billingAdd"));
                customer.setPassportNo(resultset.getString("passportNo"));
                customer.setPassportExpiry(resultset.getDate("passportExpiry"));
                customer.setMobilePhone(resultset.getString("mobilePhone"));
                customer.setDob(resultset.getDate("dob"));
                customer.setOfficePhone(resultset.getString("officePhone"));
                customer.setHomePhone(resultset.getString("homePhone"));
                customer.setKrisFlyer(resultset.getString("krisFlyer"));
                customer.setPassword(resultset.getString("password"));
                System.out.println(resultset.getString("name"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(resultset != null) {
                try {
                    resultset.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } 
                catch (SQLException ex) {
                    Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return customer;
    }
    
    public String getNRIC(String email) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        String customerNRIC = "";
        
        // get NRIC from db
        String sqlselect = "SELECT nricNo FROM customer WHERE email = ?";
        
        try {
            connection = dsCustomerCatalogue.getConnection();
            preparedStatement = connection.prepareStatement(sqlselect);
            preparedStatement.setString(1, email);
            System.out.println(preparedStatement);
            
            resultset = preparedStatement.executeQuery();
            
            resultset.next();
            
            customerNRIC = resultset.getString("nricNo");
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerNRIC;
    }
    
    public String getname(String nric) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        String customerName = "";
        
        // get NRIC from db
        String sqlselect = "SELECT name FROM customer WHERE nricNo = ?";
        
        try {
            connection = dsCustomerCatalogue.getConnection();
            preparedStatement = connection.prepareStatement(sqlselect);
            preparedStatement.setString(1, nric);
            System.out.println(preparedStatement);
            
            resultset = preparedStatement.executeQuery();
            
            resultset.next();
            
            customerName = resultset.getString("name");
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return customerName;
    }
}
