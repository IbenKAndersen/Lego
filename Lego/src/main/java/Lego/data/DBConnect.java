package Lego.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ibenk
 */
public class DBConnect {

    private static final String URL         = "jdbc:mysql://localhost:3306/lego";
    private static final String USERNAME    = "root";
    private static final String PASSWORD    = "1234";

    private static Connection uniqueInstance;

    public static void setConnection(Connection connect) {
        uniqueInstance = connect;
    }

    public static Connection DBConnect() throws ClassNotFoundException, SQLException {
        if ( uniqueInstance == null ) {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            uniqueInstance = DriverManager.getConnection( URL, USERNAME, PASSWORD );
        }
        return uniqueInstance;
    }
    
    public Connection getConnection() {
        return uniqueInstance;
    }

}
    

