package chainofresponsibility;

/**
 * @author han
 * @Date 2019-09-19 17:03
 **/
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(){
        this.level = AbstractLogger.ERROR;

        setNextLogger(new FileLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
