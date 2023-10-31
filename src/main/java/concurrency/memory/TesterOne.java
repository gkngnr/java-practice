package concurrency.memory;

public class TesterOne {

    public static void main(String[] args) {
        var r1 = new BasicRunnable();
//        var r2 = new BasicRunnable();

        Thread t1 = new Thread(r1, "T1");
        Thread t2 = new Thread(r1, "T2");

        t1.start();
        t2.start();
    }
}
