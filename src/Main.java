import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {

        ThreadDemo td = new ThreadDemo();


        FutureTask<Integer> result = new FutureTask<Integer>(td);
        new Thread(result).start();
        Integer sum;
        try {
                         //等所有线程执行完，获取值，因此FutureTask 可用于 闭锁
                        sum = result.get();
                        System.out.println("-----------------------------");
                        System.out.println(sum);
                    } catch (Exception e) {
                        e.printStackTrace();
                     }
    }
}
class ThreadDemo implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100000; i++) {
            System.out.println(i);
            sum += i;
        }
        return sum;
    }
}