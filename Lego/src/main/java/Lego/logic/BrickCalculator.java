package Lego.logic;

import Lego.data.LegoBrick;
import Lego.data.LegoHouseOrder;
import Lego.data.LegoHouseSide;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

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
        
        /* Get height and length for all 4 sides of the house */
        LegoHouseSide w = getSide(height, width);
        LegoHouseSide l = getSide(height, length);
        List<LegoHouseSide> sides = new ArrayList<>();
        sides.add(w);
        sides.add(w);
        sides.add(l);
        sides.add(l);
        
        /* Initialize the count of the bricks */ 
        int brickone = 0;
        int bricktwo = 0;
        int brickfour = 0;
        
        /* Go through all 4 sides and get number of bricks of ones, twos and fours*/
        for (LegoHouseSide side : sides) {
            brickone += side.getBrickone();
            bricktwo += side.getBricktwo();
            brickfour += side.getBrickfour();
        }
        
        /* Set number of bricks */
        brick.setBrickone(brickone);
        brick.setBricktwo(bricktwo);
        brick.setBrickfour(brickfour);
        
        return brick;
    }

    private LegoHouseSide getSide(int height, int width) {
        return null;
    }

    private LegoHouseSide setSide(int height) {
        return null;
    }
    
}
