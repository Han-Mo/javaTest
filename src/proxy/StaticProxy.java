package proxy;

/**
 * @author han
 * @Date 2019-08-23 14:41
 **/
public class StaticProxy implements Person{
    private Person o;

    public StaticProxy(Person o) {
        this.o = o;
    }

    public static void main(String[] args) {
        Student s = new Student();

        //创建代理类对象
        StaticProxy proxy = new StaticProxy(s);
        //调用代理类对象的方法
        proxy.sayHello("welcome to java", 20);
        System.out.println("******");
        //调用代理类对象的方法
        proxy.sayGoodBye(true, 100);

    }

    @Override
    public void sayHello(String content, int age) {
        // TODO Auto-generated method stub
        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        o.sayHello(content, age);
        System.out.println("ProxyTest sayHello end");
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        // TODO Auto-generated method stub
        System.out.println("ProxyTest sayHello begin");
        //在代理类的方法中 间接访问被代理对象的方法
        o.sayGoodBye(seeAgin, time);
        System.out.println("ProxyTest sayHello end");
    }

}
