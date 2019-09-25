package mediator;

/**
 * @author han
 * @Date 2019-09-23 17:23
 **/
public class MediatorPater {
    protected AbstractCardPartner aPartner;
    protected AbstractCardPartner bPartner;

    public MediatorPater(AbstractCardPartner a, AbstractCardPartner b)
    {
        aPartner = a;
        bPartner = b;
    }

    public void AWin(int money) {
        aPartner.money += money;
        bPartner.money -=money;
    }

    public void BWin(int money) {
        bPartner.money += money;
        aPartner.money -=money;
    }
}
