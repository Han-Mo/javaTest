package strategy.strategyb.ordertype;

/**
 * @author han
 * @Date 2019-09-20 15:15
 **/
public abstract class AbstractHandler {
    public Integer type;
    abstract public void setType();
    public Integer getType() {
        return this.type;
    }
    abstract public String handler();
}
