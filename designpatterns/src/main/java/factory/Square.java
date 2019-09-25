package factory;

/**
 * @author han
 * @Date 2019-09-05 14:47
 **/
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
