package proxy;

import java.lang.reflect.Proxy;

/**
 * @author han
 * @Date 2019-09-17 14:51
 **/
public class Client {
    public static void main(String[] args) {
        //真实对象
        Subject realSubject =  new RealSubject();

        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(realSubject);
        Subject proxyClass = (Subject) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Subject.class}, myInvocationHandler);
        proxyClass.sellBooks();
        proxyClass.speak();
    }
}
