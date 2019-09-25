package command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author han
 * @Date 2019-09-20 14:26
 **/
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
