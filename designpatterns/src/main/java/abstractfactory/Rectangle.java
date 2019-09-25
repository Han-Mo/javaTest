package abstractfactory;


/**
 * @author han
 * @Date 2019-09-05 14:46
 **/
public class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
