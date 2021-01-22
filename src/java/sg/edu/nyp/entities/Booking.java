package sg.edu.nyp.entities;

import java.io.Serializable;
import java.util.Date;

public class Booking implements Serializable {
    private static final long serialVersionUID = -1L;
    private String nricNo;
    private int flightcode;
    private int seatId;
    private int employeeId;
    private Date timestamp;

    public String getNricNo() {
        return nricNo;
    }

    public void setNricNo(String nricNo) {
        this.nricNo = nricNo;
    }

    public int getFlightcode() {
        return flightcode;
    }

    public void setFlightcode(int flightcode) {
        this.flightcode = flightcode;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
}
