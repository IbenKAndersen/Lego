package Lego.data;

import Lego.logic.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibenk
 */
public class UserMapper {

    /**
     * createUser adds a new user to the database.
     *
     * The prepareStatement interface improves performance in the application by
     * using passing parameter (?) the query is compiled only once.
     */
    public void createUser(String email, String password) throws SQLException, ClassNotFoundException 
    {
       if (email != null && password != null)
       {    
        try {
            Connector connect = new Connector();
            
            String addUser
                    = "INSERT INTO lego.user (`email`, `password`) "
                    + "VALUES(?,?);";

            PreparedStatement ps = connect.connection().prepareStatement(addUser);
            ps.setString(1, email);
            ps.setString(2, password);
            ps.executeUpdate();
            } catch (SQLException ex) {
          Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);  
            }
        }
    }

    /**
     * login checks if the username and password is valid according to the
     * database.
     *
     */
    public static User login(String email, String password) throws LoginException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT id FROM user "
                    + "WHERE email=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                User user = new User(email, password);
                user.setId(id);
                return user;
            } else {
                throw new LoginException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginException(ex.getMessage());
        }
    }

    /**
     * getUser finds all information about the user with the email we give as
     * input.
     *
     */
    public User getUser(String email) throws SQLException, ClassNotFoundException {
        User user = new User();
        Connector con = new Connector();

        String query
                = "SELECT * FROM lego.user "
                + "WHERE `email`='" + email + "';";

        Connection connection = con.connection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String password = rs.getString("password");
            user.setPassword(password);
        }
        
        user.setEmail(email);
        return user;
    }
}
