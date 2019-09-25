package abstractfactory;


/**
 * @author han
 * @Date 2019-09-05 14:47
 **/
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
