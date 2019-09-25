package abstractfactory;

/**
 * @author han
 * @Date 2019-09-05 14:55
 **/
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Green::fill() method.");
    }
}
