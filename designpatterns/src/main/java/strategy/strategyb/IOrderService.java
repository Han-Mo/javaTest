package strategy.strategyb;

import strategy.strategyb.OrderDTO;

/**
 * @author han
 * @Date 2019-09-20 15:01
 **/
public interface IOrderService {
    String handle(OrderDTO dto);
}
