package concurrency.threadlocal;

public class InheritableThreadLocalTester {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        Thread t1 = new Thread(() -> {
            threadLocal.set("threadLocal");
            inheritableThreadLocal.set("inheritableThreadLocal");
            System.out.println("inside parent thread");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
            Thread child = new Thread(() -> {
                System.out.println("inside child thread");
                System.out.println(threadLocal == null ? "null" : threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
            });
            child.start();
        });

        t1.start();
    }
}
