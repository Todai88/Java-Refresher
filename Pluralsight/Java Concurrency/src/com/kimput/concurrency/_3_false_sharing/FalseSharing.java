package com.kimput.concurrency._3_false_sharing;

public class FalseSharing {
    public static int NUM_THREADS_MAX = 4;
    public final static long ITERATIONS = 50_000_000L;

    private static VolatileLongPadded[] paddedLongs;
    private static VolatileLongUnPadded[] unpaddedLongs;

    public final static class VolatileLongPadded {
        public long q1, q2, q3, q5, q6;
        public volatile long value = 0L;
        public long q11, q12, q13, q14, q15, q16;
    }

    public final static class VolatileLongUnPadded {
        public volatile long value = 0L;
    }

    static {
        paddedLongs = new VolatileLongPadded[NUM_THREADS_MAX];
        for (int i = 0; i < paddedLongs.length; i++) {
            paddedLongs[i] = new VolatileLongPadded();
        }

        unpaddedLongs = new VolatileLongUnPadded[NUM_THREADS_MAX];
        for (int i = 0; i < unpaddedLongs.length; i++) {
            unpaddedLongs[i] = new VolatileLongUnPadded();
        }
    }

    public static void main(String[] args) {
        try {
            runBenchmark();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runBenchmark() throws InterruptedException {
        long begin, end;

        for (int n = 1; n <= NUM_THREADS_MAX; n++) {
            Thread[] threads = new Thread[n];

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createPaddedRunnable(j));
            }
            runBenchmarkTest(n, threads, true);

            for (int j = 0; j < threads.length; j++) {
                threads[j] = new Thread(createUnpaddedRunnable(j));
            }

            runBenchmarkTest(n, threads, false);

        }
    }

    private static void runBenchmarkTest(int n, Thread[] threads, boolean padded) throws InterruptedException {
        long begin;
        long end;
        begin = System.currentTimeMillis();
        for (Thread t : threads) { t.start(); }
        for (Thread t : threads) { t.join(); }
        end = System.currentTimeMillis();
        if (padded) {
            System.out.printf("    Padded # threads %d - T = %dms\n", n, end - begin);
        } else {
            System.out.printf("    Unpadded # threads %d - T = %dms\n", n, end - begin);
        }
    }

    private static Runnable createUnpaddedRunnable(final int k) {
        return () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                unpaddedLongs[k].value = i;
            }
        };
    }

    private static Runnable createPaddedRunnable(final int k) {
        Runnable paddedTouch = () -> {
            long i = ITERATIONS + 1;
            while (0 != --i) {
                paddedLongs[k].value = i;
            }
        };
        return paddedTouch;
    }
}
