package Lego.data;

import Lego.logic.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ibenk
 */
public class UserMapper {
    
    /**
     * createUser adds a new user to the database.
     * 
     * The prepareStatement interface improves performance in the application
     * by using passing parameter (?) the query is compiled only once. 
     */
    public void createUser(String username, String password, int isAdmin) throws SQLException {
        try {
            if (username != null || password != null || isAdmin >1 || isAdmin <0) {
                DBConnect connect = new DBConnect();
                String create
                        = "INSERT INTO lego.user (`username`,`password`,`isAdmin`) "
                        + "VALUES (?,?,?);";
                PreparedStatement prep = connect.getConnection().prepareStatement(create);
                prep.setString(1, username);
                prep.setString(2, password);
                prep.setInt(3, isAdmin);
                prep.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    /**
     * login checks if the username and password is valid according to the database.
     * 
     * If isAdmin has the value 1, the user is admin (an employee)
     * If isAdmin has the value 0, the user is not admin (a customer)
     */
    public void login(String username, String password) throws ClassNotFoundException, SQLException {
        try {
            Connection connect = DBConnect.DBConnect();
            String login
                    = "SELECT isAdmin from user "
                    + "WHERE username=? AND password=?;";
            PreparedStatement prep = connect.prepareStatement(login);
            prep.setString(1, username);
            prep.setString(2, password);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                int admin = rs.getInt("isAdmin");
                System.out.println(admin);
                
                /* if user is admin */
                if (admin == 1) {
                    System.out.println("This user is admin");
                }
            
                /* if user is not admin*/
                if (admin != 1) {
                    System.out.println("This user is not admin");
                }
            
            /* if user is not in the database*/                
            } else {
                throw new LoginException("User not valid.");
            }
        } catch (LoginException | ClassNotFoundException | SQLException e) {
            e.getMessage();
        }
        
    }
    
}
