/**
 * @author han
 * @Date 2019/3/1 下午4:45
 **/


class Thread1 extends Thread {
    public volatile boolean flag = true;
    @Override
    public void run(){
        System.out.println("start.....");
        while (flag) {


        }
        System.out.println("end............");
    }

    public void stopThread(boolean flag){
        this.flag = flag;
        //System.out.println("updated flag.....");
    }
}

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException
    {
        Thread1 a1 = new Thread1();
        a1.start();

        Thread.sleep(1000L);


        a1.stopThread(false);


        System.out.println("update flag.....");

        Thread.sleep(1000L);
        System.out.println(a1.flag);
    }
}