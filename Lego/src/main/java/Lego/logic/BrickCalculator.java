package Lego.logic;

import Lego.data.LegoBrick;
import Lego.data.LegoHouseOrder;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ibenk
 */
public class BrickCalculator {

    private LegoHouseOrder legohouse;
    private int length;
    private int width;
    private int height;

    public BrickCalculator(LegoHouseOrder legohouse) {
        if (legohouse.getWidth() < 6 || legohouse.getHeight() < 2 || legohouse.getLength() < 6) {
            throw new IllegalArgumentException();
        }
        this.legohouse = legohouse;
        length = legohouse.getLength();
        width = legohouse.getWidth();
        height = legohouse.getHeight();
    }

    /**
     * These 4 methods calculate and return bricks to the Lego House.
     *
     * Length/width First divide the length/width with 4 to get the amount of
     * brick4 Then calculate modulus of whats left. If whats left is bigger or
     * the same as 2, divide it with 2 to get the amount of brick2 Then brick1
     * is modulus of whats left. If whats left is smaller than 2, brick2 is 0
     * and brick1 is 1
     *
     * Height If height is an even number: #1 Divide the height with 2, multiply
     * the bricks on the 1st line. #2 Multiply the other half of the height with
     * the bricks on the 2nd line.
     *
     * If height is an odd number: #1 Divide the height with 2 and add 1,
     * multiply the bricks on the 1st line. #2 Divide the height with 2,
     * multiply the bricks on the 2nd line.
     *
     */
    public LegoBrick bricksLength1stLine() {
        int brick1 = 0, brick2 = 0, brick4 = 0, whatsleft = 0, halfheight = 0;

        /* Calculating the number of bricks on odd lines, length side */
        brick4 = length / 4;
        whatsleft = length % 4;

        if (whatsleft >= 2) {
            brick2 = whatsleft / 2;
            brick1 = whatsleft % 2;
        } else if (whatsleft > 0 && whatsleft < 2) {
            brick2 = 0;
            brick1 = 1;
        }
        

//        /* Calculate from height*/
//        /* If the height is an even number */
//        if (height % 2 == 0) {
//            halfheight = height / 2;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//
//        /* If the height is an uneven number */
//        } else {
//            halfheight = (height / 2) + 1;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//        }

        /* Overview of bricks on first (bottom) line, length side */
        LegoBrick length1stLine = new LegoBrick(brick1, brick2, brick4);
        System.out.println("4: " + brick4 + " on odd lines, length");
        System.out.println("2: " + brick2 + " on odd lines, length");
        System.out.println("1: " + brick1 + " on odd lines, length");
        System.out.println("================================================");
        return length1stLine;
    }

    public LegoBrick bricksLength2ndLine() {
        int brick1 = 0, brick2 = 0, brick4 = 0, whatsleft = 0, halfheight = 0;
        int newLength = 0;
        
        /* Calculating the number of bricks on even lines, length side */
        newLength = length - 4;
        brick4 = newLength / 4;
        whatsleft = newLength % 4;

        if (whatsleft >= 2) {
            brick2 = whatsleft / 2;
            brick1 = whatsleft % 2;
        } else if (whatsleft > 0 && whatsleft < 2) {
            brick2 = 0;
            brick1 = 1;
        }

//        /* Calculate from height*/
//        /* If the house has more than 2 lines, or has 2 lines */
//        if (height >= 2) {
//            halfheight = height / 2;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//        } 
        
        /* Overview of bricks on the second line, length side */
        LegoBrick length2ndLine = new LegoBrick(brick1, brick2, brick4);
        System.out.println("4: " + brick4 + " on even lines, length");
        System.out.println("2: " + brick2 + " on even lines, length");
        System.out.println("1: " + brick1 + " on even lines, length");
        System.out.println("================================================");
        return length2ndLine;
    }

    public LegoBrick bricksWidth1stLine() {
        int brick1 = 0, brick2 = 0, brick4 = 0, whatsleft = 0, halfheight = 0;
        int newWidth = 0;
        
        /* Calculating the number of bricks on odd lines, width side */
        newWidth = width - 4;
        brick4 = newWidth / 4;
        whatsleft = newWidth % 4;
        
        if (whatsleft >= 2) {
            brick2 = whatsleft / 2;
            brick1 = whatsleft % 2;
        } else if (whatsleft > 0 && whatsleft < 2) {
            brick2 = 0;
            brick1 = 1;
        }

//        /* Calculate from height*/
//        /* If the height is an even number */
//        if (height % 2 == 0) {
//            halfheight = height / 2;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//
//        /* If the height is an uneven number */
//        } else {
//            halfheight = (height / 2) + 1;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//        }
        
        /* Overview of bricks on first (bottom) line, width side */
        LegoBrick width1stLine = new LegoBrick(brick1, brick2, brick4);
        System.out.println("4: " + brick4 + " on odd lines, width");
        System.out.println("2: " + brick2 + " on odd lines, width");
        System.out.println("1: " + brick1 + " on odd lines, width");
        System.out.println("================================================");
        return width1stLine;
    }

    public LegoBrick bricksWidth2ndLine() {
        int brick1 = 0, brick2 = 0, brick4 = 0, whatsleft = 0, halfheight = 0;

        /* Calculating the number of bricks on even lines, width side */
        brick4 = width / 4;
        whatsleft = width % 4;

        if (whatsleft >= 2) {
            brick2 = whatsleft / 2;
            brick1 = whatsleft % 2;
        } else if (whatsleft > 0 && whatsleft < 2) {
            brick2 = 0;
            brick1 = 1;
        }

//        /* Calculate from height*/
//        /* If the house has more than 2 lines, or has 2 lines */
//        if (height >= 2) {
//            halfheight = height / 2;
//            brick4 = brick4 * halfheight;
//            brick2 = brick2 * halfheight;
//            brick1 = brick1 * halfheight;
//        } 
        
         /* Overview of bricks on second line, width side */
        LegoBrick width2ndLine = new LegoBrick(brick1, brick2, brick4);
        System.out.println("4: " + brick4 + " on even lines, width");
        System.out.println("2: " + brick2 + " on even lines, width");
        System.out.println("1: " + brick1 + " on even lines, width");
        System.out.println("================================================");
        return width2ndLine;
    }

    /**
     * getListOfBricks returns a list of all bricks in a Lego House.
     */
    public static List<LegoBrick> getListOfBricks(LegoHouseOrder order) {
        List<LegoBrick> brickList = new ArrayList<>();
        BrickCalculator c = new BrickCalculator(order);
        
//        brickList.add(c.bricksLength1stLine());
//        brickList.add(c.bricksWidth1stLine());
//        brickList.add(c.bricksLength1stLine());
//        brickList.add(c.bricksWidth1stLine());
//
//        brickList.add(c.bricksLength2ndLine());
//        brickList.add(c.bricksWidth2ndLine());
//        brickList.add(c.bricksLength2ndLine());
//        brickList.add(c.bricksWidth2ndLine());
        
        for(int i = 0; i < order.getHeight(); i++) {
            if (i % 2 != 0) {
                brickList.add(c.bricksLength1stLine());
                brickList.add(c.bricksWidth1stLine());
                brickList.add(c.bricksLength1stLine());
                brickList.add(c.bricksWidth1stLine());
            } else {
                brickList.add(c.bricksLength2ndLine());
                brickList.add(c.bricksWidth2ndLine());
                brickList.add(c.bricksLength2ndLine());
                brickList.add(c.bricksWidth2ndLine());
            }
        }
        return brickList;
    }
    
    public static List<Integer> getTotalBricks(List<LegoBrick> brick) {
        List<Integer> list = new ArrayList();
        int totalFour = 0, totalTwo = 0, totalOne = 0;
        for (LegoBrick l : brick) {
            totalFour += l.getBrick4();
            totalTwo += l.getBrick2();
            totalOne += l.getBrick1();
        }
        list.add(totalFour);
        list.add(totalTwo);
        list.add(totalOne);
        return list;
    }
}
