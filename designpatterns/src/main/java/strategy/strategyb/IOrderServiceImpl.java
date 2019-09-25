package strategy.strategyb;

import strategy.strategyb.OrderDTO;

/**
 * @author han
 * @Date 2019-09-20 15:31
 **/
public class IOrderServiceImpl implements IOrderService {

    @Override
    public String handle(OrderDTO dto) {
        HandlerContext handlerContext = new HandlerContext();
        return handlerContext.handler(dto.getType());
    }
}
