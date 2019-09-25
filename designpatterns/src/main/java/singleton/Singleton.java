package singleton;

/**
 * 单例模式
 * @author han
 * @Date 2019-08-30 09:10
 **/
public class Singleton {
    //volatile 阻止变量访问前后的指令重排，保证了命令的执行顺序
    private volatile static Singleton instance = null;//单例对象
    private Singleton(){//私有构造函数

    }
    //静态工厂方法
    public static Singleton getInstance(){
        if (instance == null){ //双重检测机制
            synchronized (Singleton.class){ //同步锁
                if (instance == null){//双重检测机制
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}
