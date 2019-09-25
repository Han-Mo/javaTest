package strategy.strategyb.ordertype;

/**
 * @author han
 * @Date 2019-09-20 15:18
 **/
public class NormalOrder extends AbstractHandler {

    public NormalOrder() {
        setType();
    }

    @Override
    public void setType() {
        this.type = 1;
    }

    @Override
    public String handler() {
        return "处理普通订单";
    }
}
