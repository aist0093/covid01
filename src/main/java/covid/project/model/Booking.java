package covid.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Booking {
    @Id
    private int bookID;
    private int clientID;
    private String type;
    private boolean result;
    private int dateID;


    // Constructors

    public Booking() {
    }
    public Booking(int bookID, int clientID, String type, boolean result, int dateID) {
        this.bookID = bookID;
        this.clientID = clientID;
        this.type = type;
        this.result = result;
        this.dateID = dateID;
    }


    // Getters and Setters

    @javax.persistence.Id
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public int getDateID() {
        return dateID;
    }

    public void setDateID(int dateID) {
        this.dateID = dateID;
    }



}
