package builderpattern;

/**
 * @author han
 * @Date 2019-09-06 15:16
 **/
public class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}
