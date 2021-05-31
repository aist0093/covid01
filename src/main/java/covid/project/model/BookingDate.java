package covid.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.sql.Date;

@Entity
public class BookingDate {
    @Id
    private int dateID;
    private String dateDate;
    private String timeTime;


    // constructors


    public BookingDate(int dateID, String dateDate, String timeTime) {
        this.dateID = dateID;
        this.dateDate = dateDate;
        this.timeTime = timeTime;
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

    public String getDateDate() {
        return dateDate;
    }

    public void setDateDate(String dateDate) {
        this.dateDate = dateDate;
    }

    public String getTimeTime() {
        return timeTime;
    }

    public void setTimeTime(String timeTime) {
        this.timeTime = timeTime;
    }
}
