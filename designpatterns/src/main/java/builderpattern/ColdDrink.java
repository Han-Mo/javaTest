package builderpattern;

/**
 * @author han
 * @Date 2019-09-06 15:12
 **/
public abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
