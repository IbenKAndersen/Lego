package Lego.data;

import Lego.logic.LoginException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    public void createUser(User user) throws SQLException, LoginException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO user (email, password) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginException(ex.getMessage());
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
        Connection con = Connector.connection();

        String query
                = "SELECT * FROM lego.user "
                + "WHERE `email`=?;";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();

        user.setEmail(email);
        return user;
    }
}
