package chainofresponsibility;

/**
 * @author han
 * @Date 2019-09-19 17:05
 **/
public class ChainPatternDemo {

    public static void main(String[] args) {
        AbstractLogger loggerChain = new ErrorLogger();
        //1
        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        //2
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug level information.");
        //3
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
