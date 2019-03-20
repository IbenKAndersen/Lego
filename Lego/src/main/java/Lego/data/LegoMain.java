package Lego.data;

import Lego.logic.LoginException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibenk
 */
public class LegoMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, LoginException {

        
            UserMapper mapper = new UserMapper();
            
            User test = new User("Tests@Test.dk", "Test", "Test");
            
            mapper.createUser(test);

    }

}
