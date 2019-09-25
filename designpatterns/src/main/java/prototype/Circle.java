package prototype;

/**
 * @author han
 * @Date 2019-09-10 10:54
 **/
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}