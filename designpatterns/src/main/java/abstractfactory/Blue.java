package abstractfactory;

/**
 * @author han
 * @Date 2019-09-05 14:56
 **/
public class Blue implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
