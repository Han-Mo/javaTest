import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author han
 * @Date 2019/3/6 下午3:03
 **/
public class VolatileNotAtomic extends Thread {
    //十个线程共享count
 //   private volatile static int count = 0;
  //  private  static int count = 0;
    private  static AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run(){
        for (int i =0 ;i<10000;i++)
        {
           // count++;
           count.incrementAndGet();
        }
        System.out.println(getName()+","+count);
    }

    public static void main(String[] args){
        VolatileNotAtomic[] demos = new VolatileNotAtomic[10];
        for (int i =0;i < demos.length;i++){
            demos[i] = new VolatileNotAtomic();
        }
       /* for (VolatileNotAtomic demo : demos ){
            demo.start();
        }*/
        for (int i =0;i < demos.length;i++){
            demos[i].start();
        }

    }
}
