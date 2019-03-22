package Lego.data;

/**
 *
 * @author ibenk
 */
public class User {

    private int id;
    private String email;
    private String password; 
    private String role;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() { 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + ", email: " + email + ", password: " + password + ", role: " + role;
    }

    
    
}
