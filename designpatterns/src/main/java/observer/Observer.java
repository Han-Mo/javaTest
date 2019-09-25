package observer;

/**
 * @author han
 * @Date 2019-09-24 14:35
 **/
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
