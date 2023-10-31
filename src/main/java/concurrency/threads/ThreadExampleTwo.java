package concurrency.threads;

public class ThreadExampleTwo {

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " Runnable started");
                System.out.println(Thread.currentThread().getName() + " Runnable finished");
            }
        };

        Runnable r2 = () -> {
            System.out.println(Thread.currentThread().getName() + " RunnableLambda started");
            System.out.println(Thread.currentThread().getName() + " RunnableLambda finished");
        };

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r2, "T2");

        t1.start();
        t2.start();
    }
}
