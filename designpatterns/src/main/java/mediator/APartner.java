package mediator;

/**
 * @author han
 * @Date 2019-09-23 17:29
 **/
public class APartner extends AbstractCardPartner {
    @Override
    public void ChangeMoney(int money, MediatorPater mediator) {
        mediator.AWin(money);
    }
}
