package concurrency.threadlocal;

public class ThreadLocalTester {

    record LocalState(String name, String val){}

    public static void main(String[] args) {
        ThreadLocal<LocalState> tl1 = ThreadLocal.withInitial(() ->  new LocalState("default", "default-thread"));
        ThreadLocal<LocalState> tl2 = ThreadLocal.withInitial(() ->  new LocalState("default", "default-thread"));

        Runnable r1 = () -> {
            final var tName = Thread.currentThread().getName();
            tl1.set(new LocalState(tName, "r1"));
            System.out.println(tl1.get());
            if (tName.equalsIgnoreCase("t1")) {
                System.out.println(tl2.get());
            } else {
                tl2.set(new LocalState(tName, "r1-t2"));
                System.out.println(tl2.get());
            }
        };

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r1, "T2");
        Thread t3 = new Thread(r1, "T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
