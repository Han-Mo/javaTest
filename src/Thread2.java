/**
 * @author han
 * @Date 2019/3/4 下午4:50
 **/
class ThreadDemo1 extends Thread{
    private Integer trainCount = 10;

    @Override
    public void run(){
        while (trainCount > 0){
            try {
                Thread.sleep(50L);
            }catch (Exception e){

            }
            sale();
        }
    }

    public void sale()
    {
        synchronized(trainCount){
            if(trainCount > 0){
                System.out.println(Thread.currentThread().getName()+ ",出售 "+(10-trainCount+1)+" 张");
                trainCount--;
            }

        }

    }
}

public class Thread2{
    public static void main(String[] args)
    {
        ThreadDemo1 demo1 = new ThreadDemo1();
        Thread t1 = new Thread(demo1,"窗口1");
        Thread t2 = new Thread(demo1,"窗口2");
        t1.start();
        t2.start();
    }
}