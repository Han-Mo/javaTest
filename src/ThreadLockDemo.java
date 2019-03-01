import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author han
 * @Date 2019/3/1 下午4:42
 **/
public class ThreadLockDemo {
    public static void main(String[] args){
        Res res = new Res();
        Condition condition = res.lock.newCondition();
        Out out = new Out(res,condition);
        out.start();
        Input input = new Input(res,condition);

        input.start();
    }
}

class Input extends Thread {
    Res res;
    Condition condition;
    public Input(Res res,Condition condition){
        this.res = res;
        this.condition = condition;
    }
    @Override
    public void run(){

        while (true){
            try {
                res.lock.lock();

                if(!res.flag){
                    try {
                        condition.await();
                    }catch (Exception e){

                    }

                }

                System.out.println(res.name+"  "+res.sex);
                res.flag = false;
                condition.signal();
            }catch (Exception e){

            }finally {
                res.lock.unlock();
            }


        }
    }
}
class Out extends Thread {
    Res res;
    Condition condition;
    public Out(Res res,Condition condition){
        this.res = res;
        this.condition = condition;
    }
    @Override
    public void run(){

        int count = 0;
        while (true){
            try {
                res.lock.lock();
                if(res.flag){
                    try {
                        condition.await();
                    }catch (Exception e){

                    }
                }


                if(count == 0){
                    res.name = "小红";
                    res.sex = "女";
                } else {
                    res.name = "小明";
                    res.sex = "男";
                }
                count = (count+1)%2;
                res.flag = true;
                condition.signal();
            }catch (Exception e){

            }finally {
                res.lock.unlock();
            }

        }
    }
}
class Res {
    protected String name;
    protected String sex;
    protected Boolean flag = false;

    Lock lock = new ReentrantLock();
}