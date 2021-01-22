package sg.edu.nyp.entities;

import java.io.Serializable;

class Seat implements Serializable {
    private static final long serialVersionUID = -1L;
    private int Id;
    private String seatNum;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(String seatNum) {
        this.seatNum = seatNum;
    }
}
