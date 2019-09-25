package builderpattern;

/**
 * @author han
 * @Date 2019-09-06 15:14
 **/
public class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}
