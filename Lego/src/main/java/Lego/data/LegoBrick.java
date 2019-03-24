package Lego.data;

/**
 *
 * @author ibenk
 */
public class LegoBrick {
    
    private int height, brick1, brick2, brick4;
    
    public LegoBrick() {
    }

    public LegoBrick(int brick1, int brick2, int brick4) {
        this.brick1 = brick1;
        this.brick2 = brick2;
        this.brick4 = brick4;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBrick1() {
        return brick1;
    }

    public void setBrick1(int brick1) {
        this.brick1 = brick1;
    }

    public int getBrick2() {
        return brick2;
    }

    public void setBrick2(int brick2) {
        this.brick2 = brick2;
    }

    public int getBrick4() {
        return brick4;
    }

    public void setBrick4(int brick4) {
        this.brick4 = brick4;
    }

    @Override
    public String toString() {
        return "New line: " + " brick1: " + brick1 + ", brick2: " + brick2 + ", brick4: " + brick4;
    }
    
    
    
}
