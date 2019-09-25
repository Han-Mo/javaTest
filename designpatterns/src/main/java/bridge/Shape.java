package bridge;

/**
 * @author han
 * @Date 2019-09-11 11:06
 **/
public abstract class Shape {
    protected DrawAPI drawAPI;
    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }
    public abstract void draw();
}
