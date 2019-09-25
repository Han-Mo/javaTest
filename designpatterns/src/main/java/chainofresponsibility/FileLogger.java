package chainofresponsibility;

/**
 * @author han
 * @Date 2019-09-19 17:03
 **/
public class FileLogger extends AbstractLogger {

    public FileLogger(){
        this.level = AbstractLogger.DEBUG;

        setNextLogger(new ConsoleLogger());
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
