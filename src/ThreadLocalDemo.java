/**
 * @author han
 * @Date 2019/3/6 下午3:34
 **/
class ThreadLocalDemoRes{
    public int count = 0;
   public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
       @Override
         protected Integer initialValue(){
             return 0;
         }
   };
    public String getNumber(){
      //  count++;
        count = threadLocal.get()+1;
        threadLocal.set(count);
        return count+"";
    }
}

public class ThreadLocalDemo extends Thread{

    private ThreadLocalDemoRes res;

    public ThreadLocalDemo(ThreadLocalDemoRes res){
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 0;i<3;i++){
            System.out.println(getName()+","+res.getNumber());
        }
    }
}

class ThreadLocalDemo1{
    public static void main(String[] args){
        ThreadLocalDemoRes demoRes = new ThreadLocalDemoRes();
        ThreadLocalDemo demo1 = new ThreadLocalDemo(demoRes);
        ThreadLocalDemo demo2 = new ThreadLocalDemo(demoRes);
        ThreadLocalDemo demo3 = new ThreadLocalDemo(demoRes);
        demo1.start();
        demo2.start();
        demo3.start();
    }
}