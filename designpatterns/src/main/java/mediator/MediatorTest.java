package mediator;

import java.io.Console;

/**
 * @author han
 * @Date 2019-09-24 14:06
 **/
public class MediatorTest {

    public static void main(String[] args)
    {
        AbstractCardPartner A = new APartner();
        AbstractCardPartner B = new BPartner();
        A.setMoney(20);
        B.setMoney(20);

        MediatorPater mediator = new MediatorPater(A, B);

        // A赢了
        A.ChangeMoney(5, mediator);
        System.out.println("A 现在的钱是：" + A.getMoney());
        System.out.println("A 现在的钱是：" + B.getMoney());


        // B赢了
        B.ChangeMoney(10, mediator);
        System.out.println("A 现在的钱是：" + A.getMoney());
        System.out.println("A 现在的钱是：" + B.getMoney());

    }
}
