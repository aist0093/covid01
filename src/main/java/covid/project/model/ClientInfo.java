package covid.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ClientInfo {

    @Id
    private long cpr;
    private String first_name;
    private String last_name;

    public ClientInfo() {
    }

    public ClientInfo(long cpr, String first_name, String last_name) {
        this.cpr = cpr;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @javax.persistence.Id
    public long getCpr() { return cpr; }

    public void setCpr(long cpr) { this.cpr = cpr; }

    public String getFirst_Name() { return first_name; }

    public void setFirst_Name(String first_name) { this.first_name = first_name; }

    public String getLast_Name() { return last_name; }

    public void setLast_Name(String last_name) { this.last_name = last_name; }
}
