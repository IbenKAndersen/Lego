package Lego.logic;

import Lego.data.LegoBrick;
import Lego.data.LegoHouseOrder;
import Lego.data.LegoHouseOrderMapper;
import Lego.data.User;
import Lego.data.UserMapper;
import java.sql.SQLException;
import java.util.List;

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
    
    public static void createOrder(User user, LegoHouseOrder order) throws SQLException, ClassNotFoundException {
        LegoHouseOrderMapper.createOrder(user, order);
    }
    
    public static List<LegoHouseOrder> getOrders(User user) {
        return LegoHouseOrderMapper.getOrders(user);
    }
    
    public static List<LegoBrick> getListOfBricks(LegoHouseOrder order) {
        return BrickCalculator.getListOfBricks(order);
    }
    
    public static List<Integer> getTotalBricks(List<LegoBrick> brick) {
        return BrickCalculator.getTotalBricks(brick);
    }
    
}
