package covid.project.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class BookingDate {
    @Id
    private int dateID;
    private Date date;
    private Time time;

    public BookingDate() {
    }

    public BookingDate(int dateID, Date date, Time time) {
        this.dateID = dateID;
        this.date = date;
        this.time = time;
    }
    @javax.persistence.Id
    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
