package sg.edu.nyp.am;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.activation.DataSource;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import sg.edu.nyp.entities.Booking;
import sg.edu.nyp.entities.Customer;
import sg.edu.nyp.entities.Flight;
import sg.edu.nyp.entities.Seat;

@Stateless
public class BookingBean {
    @Resource(name="jdbc/Project")
    private DataSource collabproject;
    
    public List<Customer> verifyNricNo(String nricNo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        //Rusyda & Spelmen
        //cont next week
        // sql and bean statements
        List<Booking> booking = new ArrayList<> ();
        String sqlSelect = "SELECT * FROM booking WHERE nricNo = ?";
        
        try {
//            connection = collabproject.getConnection();
            
            preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1, nricNo);
            
        } catch (SQLException ex) {
            
        }
        
        List<Flight> flight = new ArrayList<> ();
        String sqlSelect1 = "SELECT * FROM flight WHERE flightcode = ?";
        
        try {
            preparedStatement = connection.prepareStatement(sqlSelect1);
            
        } catch (SQLException ex) {
            
        }
        
        List<Seat> seat = new ArrayList<> ();
        String sqlSelect2 = "SELECT * FROM seat WHERE Id = ?";

        try {
            
            preparedStatement = connection.prepareStatement(sqlSelect2);
            
        } catch (SQLException ex) {
            
        }
        return null;
            
    }   
}
