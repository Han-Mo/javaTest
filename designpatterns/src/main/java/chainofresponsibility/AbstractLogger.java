package chainofresponsibility;

/**
 * @author han
 * @Date 2019-09-19 17:01
 **/
public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    public int getLevel(){
        return this.level;
    }

    //责任链中的下一个元素
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        /*switch (this.level) {
            case 1:
                System.out.println("info");
                break;
            case 2:
                System.out.println("debug");
                break;
            case 3:
                System.out.println("error");
                break;
        }*/

        if (this.level <= level) {
            System.out.println("this level: " + this.level + " level:" + level);
            write(message);
        }
        if (nextLogger != null) {
            System.out.println("next level is " + nextLogger.getLevel());
            nextLogger.logMessage(level, message);
        }
        System.out.println("=========================");
    }

    abstract protected void write(String message);
}
