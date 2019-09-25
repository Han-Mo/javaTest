package mediator;

/**
 * @author han
 * @Date 2019-09-23 17:29
 **/
public class BPartner extends AbstractCardPartner {
    @Override
    public void ChangeMoney(int money, MediatorPater mediator) {
        mediator.BWin(money);
    }
}
