package abstractfactory;

/**
 * @author han
 * @Date 2019-09-05 14:57
 **/
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape) ;
}
