package chainofresponsibility;

/**
 * @author han
 * @Date 2019-09-19 17:03
 **/
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(){
        this.level = AbstractLogger.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
