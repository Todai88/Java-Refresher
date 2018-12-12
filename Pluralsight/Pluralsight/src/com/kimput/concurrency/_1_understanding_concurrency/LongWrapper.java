package com.kimput.concurrency._1_understanding_concurrency;

public class LongWrapper {
    long l;

    public LongWrapper(long l) {
        this.l = l;
    }

    public long getValue() {
        return l;
    }

    public void incrementValue() {
        l = l + 1;
    }
}
