package covid.project.model;

public class ClientPage {

    private String full_name;
    private long cpr;
    private String type;
    private boolean result;
    private String date;



    public ClientPage(String full_name, long cpr, String type, boolean result, String date) {
        this.full_name = full_name;
        this.cpr = cpr;
        this.type = type;
        this.result = result;
        this.date = date;
    }

    public ClientPage() {
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public long getCpr() {
        return cpr;
    }

    public void setCpr(long cpr) {
        this.cpr = cpr;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
