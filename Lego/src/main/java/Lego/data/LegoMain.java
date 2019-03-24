package Lego.data;

import Lego.logic.BrickCalculator;
import Lego.logic.LoginException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ibenk
 */
public class LegoMain {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, LoginException {

        /* This works */
//      UserMapper mapper = new UserMapper();
//      User test = new User("Test2@Test2.dk", "Test2");
//      String email = test.getEmail();
//      String password = test.getPassword();
//      mapper.createUser(email, password);

        /* Not working yet */
//      LegoHouseOrder order = new LegoHouseOrder();
//      BrickCalculator calculator = new BrickCalculator();
//      calculator.getBricks(order);

        /* Not woriking yet */
//        LegoHouseOrderMapper mapper = new LegoHouseOrderMapper();
//        User test = UserMapper.getUser("Test1@Test1.dk");
//        LegoHouseOrder order = new LegoHouseOrder(20, 10, 3);
//        mapper.createOrder(test, order);
        
        /* This works */
        LegoHouseOrder order = new LegoHouseOrder(20, 10, 3);
        BrickCalculator calc = new BrickCalculator(order);
        
        List<LegoBrick> listOfBricks = calc.getListOfBricks(order);
        List<Integer> totalBricks = calc.getTotalBricks(listOfBricks);
        
        System.out.println(listOfBricks);
        System.out.println(totalBricks);
    }

}
