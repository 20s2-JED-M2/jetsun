/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sg.edu.nyp.bf;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author 182281M
 */
public class Flight implements Serializable {
    private int flightCode;
    private String departure;
    private String destination;
    private Date departureDate;
    private int flightVacancy;
    private String employeeId;

    public Flight() {
    }

    public int getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(int flightCode) {
        this.flightCode = flightCode;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightVacancy() {
        return flightVacancy;
    }

    public void setFlightVacancy(int flightVacancy) {
        this.flightVacancy = flightVacancy;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    
    
}
