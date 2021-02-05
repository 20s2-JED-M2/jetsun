package sg.edu.nyp.am;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

/**
 *
 * @author 182061K
 */
@Stateless
public class PasswordBean {
    @Resource(name="jdbc/project")
    private DataSource dsCustomer;
    
//   Used to compare the user input oldpassword with password in DB
    public boolean compareoldPass(String nric, String olduserpass){
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        
        String sqlselect = "SELECT password from customer WHERE nricNo = '" + nric + "'";
        
        try{
            connection = dsCustomer.getConnection();
            preparedStatement = connection.prepareStatement(sqlselect);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            String dboldpass = resultSet.getString("password");
            
            //Hash olduserpass
            String securePassword = olduserpass;
            
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(olduserpass.getBytes(StandardCharsets.UTF_8));

                BigInteger number = new BigInteger(1, hash);
                SecureRandom random = new SecureRandom();
                byte[] salt = new byte[16];
                random.nextBytes( salt);
//                StringBuilder sb = new StringBuilder(number.toString(16));
                StringBuilder sb = new StringBuilder();
//                while (sb.length() < 32) {
//                    sb.insert(0, '0');
//                }
                for (int i = 0; i < hash.length; i++) {
                sb.append(Integer.toString((hash[i] & 0xff) + 0x100, 16).substring(1));
            }
                //Convert hash to string
                securePassword = sb.toString();
            }catch(NoSuchAlgorithmException ex){
                ex.printStackTrace();
            }
            
            if(securePassword.equals(dboldpass))
            {
                return true;
            }else
                return false;
            
        }catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            
            return false;
        }   
    }
    
    public boolean compareNewPass(String newPass, String cmfnewpass)
    {
        if(newPass.equals(cmfnewpass))
        {
            return true;
        }else
            return false;
    }
    public boolean changePass(String nric, String oldpass, String pass) {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        
        
        // update stmt
        String sqlstmt = "update customer set password = SHA2(?,256) where nricNo = ?";
        
        
        try {
            connection = dsCustomer.getConnection();
            
            // run sql stmt into db
            preparedStatement = connection.prepareStatement(sqlstmt);
            preparedStatement.setString(1, pass);
            preparedStatement.setString(2, nric);
            
            preparedStatement.executeUpdate();
            return true;
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
            
            return false;
        }
    }
    
}
