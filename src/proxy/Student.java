package proxy;

/**
 * @author han
 * @Date 2019-08-23 14:44
 **/
public class Student implements Person{

    @Override
    public void sayHello(String content, int age) {
        // TODO Auto-generated method stub
        System.out.println("student say hello" + content + " "+ age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        // TODO Auto-generated method stub
        System.out.println("student sayGoodBye " + time + " "+ seeAgin);
    }

}

