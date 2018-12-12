package com.kimput.concurrency._1_understanding_concurrency;

public class FirstRunnable {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I am running in " + Thread.currentThread().getName());
        };
        Thread t = new Thread(runnable);
        t.setName("Runnable thread");

        t.start();  // "Runnable thread"
        //t.run(); // <-- Would make the thread run in 'main'
    }
}
