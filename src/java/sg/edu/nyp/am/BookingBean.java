package sg.edu.nyp.am;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import sg.edu.nyp.entities.Booking;
import sg.edu.nyp.entities.Customer;
import sg.edu.nyp.entities.Flight;
import sg.edu.nyp.entities.Seat;

@Stateless
public class BookingBean {
    @Resource(name="jdbc/project")
    private DataSource collabproject;
    
    public List<Object> retrieveBookings (String nricNo)  {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultset = null;
        
        List<Object> retrieveValues = new ArrayList<>();
        List<Booking> retrieveBookings = new ArrayList<>();
        List<Seat> retrieveSeats = new ArrayList<>();
        List<Flight> retrieveFlights = new ArrayList<>();
        List<Customer> retrieveCustomers = new ArrayList<>();
        
        String sqlSelect = "select b.nricNo, c.name, c.passportNo, f.flightCode, b.timestamp, f.departure, f.destination, f.departureDate, s.seatNum from booking b join flight f on b.flightCode = f.flightCode join seat s on b.seatId = s.Id join customer c on b.nricNo = c.nricNo where b.nricNo = ?";
        
            System.out.println(nricNo);
        try {
            connection = collabproject.getConnection();
            
            preparedStatement = connection.prepareStatement(sqlSelect);
            preparedStatement.setString(1, nricNo);
            System.out.println(preparedStatement);
            resultset = preparedStatement.executeQuery();
            
            while (resultset.next()) {
                Booking booking = new Booking();
                Seat seat = new Seat();
                Customer customer = new Customer();
                Flight flight = new Flight();
                
                customer.setNricNo(resultset.getString("nricNo"));
                customer.setName(resultset.getString("name"));
                customer.setPassportNo(resultset.getString("passportNo"));
                flight.setFlightcode(resultset.getInt("flightCode"));
                flight.setDeparture(resultset.getString("departure"));
                flight.setDestination(resultset.getString("destination"));
                flight.setDepartureDate(resultset.getDate("departureDate"));
                seat.setSeatNum(resultset.getString("seatNum"));
                booking.setTimestamp(resultset.getDate("timestamp"));

                retrieveBookings.add(booking);
                retrieveSeats.add(seat);
                retrieveCustomers.add(customer);
                retrieveFlights.add(flight);
//                System.out.println(preparedStatement);
                
                retrieveValues.add(retrieveBookings);                
                retrieveValues.add(retrieveSeats);
                retrieveValues.add(retrieveCustomers);                
                retrieveValues.add(retrieveFlights);

            }
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        }
        finally {
            if (resultset != null) {
                try {
                    resultset.close();
                }
                catch (SQLException ex) {
                    try {
                        connection.rollback();
                    }
                    catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                }
                catch (SQLException ex) {
                    try {
                        connection.rollback();
                    }
                    catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                }
                catch (SQLException ex) {
                    try {
                        connection.rollback();
                    }
                    catch (SQLException ex1) {
                        ex1.printStackTrace();
                        System.err.println(ex1.getMessage());
                    }
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        return retrieveValues;
    }
}
    
    
