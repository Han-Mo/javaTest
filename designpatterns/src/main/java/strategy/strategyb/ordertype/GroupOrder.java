package strategy.strategyb.ordertype;

/**
 * @author han
 * @Date 2019-09-20 15:20
 **/
public class GroupOrder extends AbstractHandler {

    public GroupOrder() {
        setType();
    }

    @Override
    public void setType() {
        this.type = 2;
    }

    @Override
    public String handler() {
        return "处理团购订单";
    }
}
