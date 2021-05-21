package covid.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookingDate {
    @Id
    private int dateID;
    private String date;
    private String time;


    // constructors
    public BookingDate(int dateID, String date, String time) {
        this.dateID = dateID;
        this.date = date;
        this.time = time;
    }

    public BookingDate() {
    }

    // Getters and Setters
    @javax.persistence.Id
    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
