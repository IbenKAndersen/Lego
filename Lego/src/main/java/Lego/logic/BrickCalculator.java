package Lego.logic;

import Lego.data.LegoBrick;
import Lego.data.LegoHouseOrder;
import java.sql.Array;

/**
 *
 * @author ibenk
 */
public class BrickCalculator {
    
    public BrickCalculator() { 
    }
    
    public LegoBrick getBricks(LegoHouseOrder order) {
        return makeBricks(order);
    }

    private LegoBrick makeBricks(LegoHouseOrder order) {
        
        /* Get the variables from the order */
        int height = order.getHeight();
        int width = order.getWidth();
        int length = order.getLength();
        
        /* Initialize a legobrick to get acces to its methods */ 
        LegoBrick brick = new LegoBrick();
        
        
        
        /* Initialize the count of the bricks */ 
        int brickone = 0;
        int bricktwo = 0;
        int brickfour = 0;
        
        return brick;
    }
    
}
