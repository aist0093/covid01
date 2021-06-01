package covid.project.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private int user_id;
    private String password;
    private String role;
    private boolean enabled;
    private String username;


    // Constructors

    public User() {}

    public User(int user_id, String password, String role, boolean enabled, String username) {
        this.user_id = user_id;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
        this.username = username;
    }


    // Getters and Setters

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
