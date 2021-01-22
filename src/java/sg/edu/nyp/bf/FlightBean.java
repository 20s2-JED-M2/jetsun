/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.bf;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
/**
 *
 * @author 182281M
 */
public class FlightBean {
    @Resource(name="jdbc/project")
    private DataSource dsFlightManagement;
    public List<Flight> searchFlight(String departure, String destination){
        List<Flight> flightList = new ArrayList<Flight>();
        //Declare the connection, statement and resultset objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultset = null;
     
        try {
            //Initialise the connection, statement and resultset 
	
		// Get the connection from the DataSource 
            connection = dsFlightManagement.getConnection();
		// Create a Statement using the Connection
            statement = connection.createStatement();
            PreparedStatement preparedStatement = null;
            
            preparedStatement = connection.prepareStatement("SELECT * FROM flight WHERE departure LIKE ? OR destination LIKE ? ");
            // Make a query to the DB using ResultSet through the Statement
            preparedStatement.setString(1, "%" + departure + "%");
            preparedStatement.setString(2, "%" + destination + "%");
            
            resultset = preparedStatement.executeQuery();
                                    
            //Rertieve all records from the resultset
            while(resultset.next()) {
                //Create a Book object
                Flight flight = new Flight();
                
                //Retrieve flightcode from the resultset and store it in flight
                int dbflightCode = resultset.getInt("flightCode");
                String dbdeparture = resultset.getString("departure");
                String dbdestination = resultset.getString("destination");
                Date dbdepartureDate = resultset.getDate("departureDate");
                int dbflightVacancy = resultset.getInt("flightVacancy");
                String dbemployeeId = resultset.getString("employeeId");
                
                flight.setFlightCode(dbflightCode);
                flight.setDeparture(dbdeparture);
                flight.setDestination(dbdestination);
                flight.setDepartureDate(dbdepartureDate);
                flight.setFlightVacancy(dbflightVacancy);
                flight.setEmployeeId(dbemployeeId);
               
                flightList.add(flight);
            }
        } catch(SQLException ex) {
            //Usually, the error should be logged somewhere in the system log.
            //Sometimes, users may also need to be notified regarding such error
            ex.printStackTrace();
            System.err.println(ex.getMessage());
        } finally {
            //Resultset, Statement and Connection are closed in the finally 
            // clause to ensure that they will be closed no matter what 
            // happens to the system.
            if(resultset != null) {
                try {
                    resultset.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch(SQLException ex) {
                    ex.printStackTrace();
                    System.err.println(ex.getMessage());
                }
            }
        }
        return flightList;
    }
}
