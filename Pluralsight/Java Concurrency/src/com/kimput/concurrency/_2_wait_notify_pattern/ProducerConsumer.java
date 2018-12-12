package com.kimput.concurrency._2_wait_notify_pattern;

public class ProducerConsumer {
    private static int[] buffer;
    private static int count;

    static class Producer {
        void produce() {
            while (isFull(buffer)) {}
            buffer[count++] = 1;
        }
    }
    static class Consumer {
        void consume() {
            while (isEmpty(buffer)) {}
            buffer[--count] = 0;
        }
    }

    static boolean isEmpty(int[] buffer) {
        return count == 0;
    }

    static boolean isFull(int[] buffer) {
        return count == buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;

        var producer = new Producer();
        var consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i = 0; i < 50; i++) {
                producer.produce();
            }
            System.out.println("Done producing");
        };

        Runnable consumeTask = () -> {
            for (int i = 0; i < 50; i++) {
                consumer.consume();
            }
            System.out.println("Done consuming");
        };

        var consumerThread = new Thread(consumeTask);
        var producerThread = new Thread(produceTask);

        consumerThread.start();
        producerThread.start();

        consumerThread.join();
        producerThread.join();

        System.out.println("Data in the buffer: " + count);
    }
}
