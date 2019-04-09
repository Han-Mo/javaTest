/**
 * @author han
 * @Date 2019/3/4 下午4:50
 **/
class ThreadDemo3 implements Runnable{
    private Integer trainCount = 100;
    public boolean flag = true;
   // private Object obj = new Object();

    @Override
    public void run(){
        if(flag){
            while (trainCount > 0){
                try {
                    Thread.sleep(50L);
                }catch (Exception e){

                }
                synchronized (this) {
                    if(trainCount > 0){
                        System.out.println(Thread.currentThread().getName()+ ",出售 "+(100-trainCount+1)+" 张");
                        trainCount--;
                    }

                }
            }
        }else{
            while (trainCount > 0){
                try {
                    Thread.sleep(50L);
                }catch (Exception e){

                }
                sale();
            }
        }
    }


    public synchronized void sale()
    {

        if(trainCount > 0){
            System.out.println(Thread.currentThread().getName()+ ",出售 "+(100-trainCount+1)+" 张");

            trainCount--;
        }

    }


}

public class Thread3{
    public static void main(String[] args) throws InterruptedException
    {
        ThreadDemo3 demo1 = new ThreadDemo3();
        Thread t1 = new Thread(demo1,"窗口1");
        Thread t2 = new Thread(demo1,"窗口2");
        t1.start();

        demo1.flag = false;
        Thread.sleep(60L);
        t2.start();

    }
}