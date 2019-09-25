package strategy.strategyb;

import java.math.BigDecimal;

/**
 * @author han
 * @Date 2019-09-20 16:55
 **/
public class DemoTest {
    public static void main(String[] args) {
        OrderDTO order = new OrderDTO();
        order.setType(1);
        order.setPrice(new BigDecimal(1000));
        order.setCode("oder1234");

        IOrderServiceImpl impl = new IOrderServiceImpl();
        String result = impl.handle(order);
        System.out.println(result);
    }
}
