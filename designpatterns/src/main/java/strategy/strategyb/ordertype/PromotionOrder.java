package strategy.strategyb.ordertype;

/**
 * @author han
 * @Date 2019-09-20 15:21
 **/
public class PromotionOrder extends AbstractHandler {
    public PromotionOrder() {
        setType();
    }

    @Override
    public void setType() {
        this.type = 3;
    }

    @Override
    public String handler() {
        return "处理促销订单";
    }
}
