package Lego.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ibenk
 */
public class Order {
    
    private String email;
    private Date date;
    private boolean isSent;
    
    List<Order> orders = new ArrayList<Order>();
    private LegoHouse house;

    public Order(String email, Date date) {
        this.email = email;
        this.date = date;
    }

    public void setOrderSent(boolean isSent) {
        isSent = true;
    }
    
    public void setOrderNotSent(boolean isSent) {
        isSent = false;
    }
    
    public void addOrder(Order order) {
        orders.add(order);
    }
    
    
    
    
}
