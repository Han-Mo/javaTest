import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author han
 * @Date 2019-08-16 11:30
 **/
public class Queuetest {
    public static void main(String[] args) throws Exception{
        Queue<String> queue=new ConcurrentLinkedQueue<String>();
        for(int i=0;i<1000;i++){
            queue.add(String.valueOf(i));
        }
        int num=10;//线程人个数
        System.out.println("启动10个线程");
        for(int i=0;i<num;i++){
            new ThreadConn(queue);
        }
        /*System.out.println("启动1个线程");
        new ThreadConn(queue);*/

    }
}

 class ThreadConn implements Runnable{
    Queue<String> queue;
    public ThreadConn(Queue<String> queue){
        this.queue=queue;
        Thread thread=new Thread(this);
        thread.start();
    }

    @Override
    public void run(){
        try{
            long sd=System.currentTimeMillis();
            /*while(queue.poll()!=null){
                //这里是业务逻辑
                System.out.println (queue.poll());
            }*/
            while (!queue.isEmpty()) {
                 synchronized(queue){

                    System.out.println(Thread.currentThread().getName()+" : "+queue.poll());
                }
            }

            long sn=System.currentTimeMillis();
            System.out.println ("time ： "+(sn-sd));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
