class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    @Override
    public void run() {
        System.out.println("Running " +  threadName );
        try {
            for(int i = 100; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
               // Thread.sleep(50);
            }
        }
        catch (Exception e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class TestThread {

    public static void main(String args[]) {

        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        Thread d1 = new Thread (R1, "Thread-1");

       // R1.start();


        RunnableDemo R2 = new RunnableDemo( "Thread-2");
       //  R2.start();
        Thread d2 = new Thread (R2, "Thread-1");
        /**/
        d1.start();
        try {
            d1.join();
        }catch (Exception e){

        }
        d2.start();




    }
}