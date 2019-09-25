package mediator;

/**
 * @author han
 * @Date 2019-09-23 17:21
 **/
public abstract class AbstractCardPartner {
    public int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public abstract void ChangeMoney(int money, MediatorPater mediator);
}
