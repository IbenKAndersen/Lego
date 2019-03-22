package Lego.data;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibenk
 */
public class LegoHouseOrderMapper {

    /**
     * createOrder adds a new order to the database.
     *
     * The prepareStatement interface improves performance in the application by
     * using passing parameter (?) the query is compiled only once.
     */
    public static void createOrder(User user, LegoHouseOrder order) throws SQLException, ClassNotFoundException {
            try {
                Connector connect = new Connector();

                String addOrder
                        = "INSERT INTO lego.order (`iduser`, `length`, `width`, `height`) "
                        + "VALUES(?,?,?,?);";

                PreparedStatement ps = connect.connection().prepareStatement(addOrder);
                ps.setInt(1, user.getId());
                ps.setInt(2, order.getLength());
                ps.setInt(3, order.getWidth());
                ps.setInt(4, order.getHeight());
                
                ps.executeUpdate();
                
            } catch (SQLException ex) {
                Logger.getLogger(UserMapper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    public static List<LegoHouseOrder> getOrders(User user) {
        List<LegoHouseOrder> orders = new ArrayList<>();
        
        
        
        return orders;
    }
    

}