package main.java.com.kimput.concurrency._1_runnable_pattern;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        var longWrapper = new LongWrapperWithKey(0L);
        Runnable r = () -> {

            for (int i = 0; i < 1_000; i++) {
                longWrapper.incrementValue();
            }
        };

        /*
            // This would work
        Thread t = new Thread(r);
        t.start();

        t.join();

        System.out.println("Value = " + longWrapper.getValue());
        */

        // This will provide us with a random number, even though we expect it to be 1000000.
        var threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("Value = " + longWrapper.getValue());
    }
}
