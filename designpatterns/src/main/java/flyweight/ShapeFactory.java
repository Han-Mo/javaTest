package flyweight;

import java.util.HashMap;

/**
 * @author han
 * @Date 2019-09-17 14:27
 **/
public class ShapeFactory {
    private static final HashMap<String, Shape> circleMap = new HashMap<String, Shape>();

    public static Shape getCircle(String color) {
        Circle circle = (Circle) circleMap.get(color);

        if(circle == null){
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Creating circle of color : " + color);
        }
        return circle;
    }
}
