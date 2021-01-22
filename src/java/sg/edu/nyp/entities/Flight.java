package sg.edu.nyp.entities;

import java.io.Serializable;
import java.util.Date;

public class Flight implements Serializable {
    private static final long serialVersionUID = -1L;
    private int flightcode;
    private String departure;
    private String destination;
    private Seat departureDate;
    private int flightVacancy;
    private String employeeId;

    public int getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(int flightcode) {
        this.flightcode = flightcode;
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

    public Seat getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Seat departureDate) {
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
