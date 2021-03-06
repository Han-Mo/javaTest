package cachedthreadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author han
 * @Date 2019-09-16 10:52
 * 创建一个可缓存线程池，如果线程池长度超过处理需要，
 * 可灵活回收空闲线程，若无可回收，则新建线程。示例代码如下：
 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，
 * 会复用执行第一个任务的线程，而不用每次新建线程
 **/
public class CachedThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0;i < 10;i++){
            final int index = i;
            try {
                Thread.sleep(index * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }
    }
}
