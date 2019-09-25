package prototype;

/**
 * @author han
 * @Date 2019-09-10 10:54
 **/
public class Square extends Shape {

    public Square(){
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}