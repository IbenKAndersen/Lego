package Lego.data;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibenk
 */
public class LegoMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        
            UserMapper mapper = new UserMapper();
            
            mapper.createUser("Test", "Test", 0);
            
            //mapper.login("Test", "Test");
            //mapper.login("Admin", "Admin");

    }

}
