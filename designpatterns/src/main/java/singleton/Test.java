package singleton;

import singleton.Singleton2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author han
 * @Date 2019-08-30 09:44
 **/
public class Test {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //获得构造器
        Constructor con = Singleton2.class.getDeclaredConstructor();
//设置为可访问
        con.setAccessible(true);
//构造两个不同的对象
        Singleton2 singleton1 = (Singleton2)con.newInstance();
        Singleton2 singleton2 = (Singleton2)con.newInstance();
//验证是否是不同对象
        System.out.println(singleton1.equals(singleton2));
    }
}
