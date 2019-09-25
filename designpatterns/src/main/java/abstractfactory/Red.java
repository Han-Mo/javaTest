package abstractfactory;

/**
 * @author han
 * @Date 2019-09-05 14:55
 **/
public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
