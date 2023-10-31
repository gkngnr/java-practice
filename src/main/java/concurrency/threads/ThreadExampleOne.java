package concurrency.threads;

public class ThreadExampleOne {
    public static class ThreadOne extends Thread {
        @Override
        public void run() {
            System.out.println("ThreadOne started");
            System.out.println("ThreadOne finished");
        }
    }

    public static class ThreadTwo implements Runnable {
        @Override
        public void run() {
            System.out.println("ThreadTwo started");
            System.out.println("ThreadTwo finished");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadOne();
        t1.start();

        Thread t2 = new Thread(new ThreadTwo());
        t2.start();

    }
}
