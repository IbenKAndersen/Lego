package Lego.logic;

import Lego.data.User;
import Lego.data.UserMapper;
import java.sql.SQLException;

/**
 *
 * @author ibenk
 */
public class LogicFacade {
    
    public static void createUser(String email, String password) throws SQLException, ClassNotFoundException {
        UserMapper.createUser(email, password);
    }
    
    public static User login(String email, String password) throws LoginException {
        return UserMapper.login(email, password);
    }
    
    public static User getUser(String email) throws SQLException, ClassNotFoundException {
        return UserMapper.getUser(email);
    }
    
}
