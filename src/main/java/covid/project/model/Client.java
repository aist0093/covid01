package covid.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    private int clientID;
    private long cpr;
    private boolean vac_status;
    private boolean inf_status;


    // Constructors

    public Client() { }

    public Client(int clientID, long cpr, boolean vac_status, boolean inf_status) {
        this.clientID = clientID;
        this.cpr = cpr;
        this.vac_status = vac_status;
        this.inf_status = inf_status;
    }


    // Getters and Setters

    @javax.persistence.Id
    public int getClientID() { return clientID; }

    public void setClientID(int clientID) { this.clientID = clientID; }

    public long getCpr() { return cpr; }

    public void setCpr(long cpr) { this.cpr = cpr; }

    public boolean isVac_status() { return vac_status; }

    public void setVac_status(boolean vac_status) { this.vac_status = vac_status; }

    public boolean isInf_status() { return inf_status; }

    public void setInf_status(boolean inf_status) { this.inf_status = inf_status; }
}
