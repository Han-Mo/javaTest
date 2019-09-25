package builderpattern;

/**
 * @author han
 * @Date 2019-09-06 15:12
 **/
public abstract class Burger implements Item {

    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
