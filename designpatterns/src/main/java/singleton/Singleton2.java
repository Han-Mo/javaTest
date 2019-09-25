package singleton;

/**
 * @author han
 * @Date 2019-08-30 09:38
 **/
public class Singleton2 {
    private static class LazyHolder {
        private static final Singleton2 INSTANCE = new Singleton2();
    }
    private Singleton2 (){}
    public static Singleton2 getInstance() {
        return LazyHolder.INSTANCE;
    }
}
