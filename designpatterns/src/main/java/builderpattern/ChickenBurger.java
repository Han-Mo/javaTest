package builderpattern;

/**
 * @author han
 * @Date 2019-09-06 15:14
 **/
public class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}
