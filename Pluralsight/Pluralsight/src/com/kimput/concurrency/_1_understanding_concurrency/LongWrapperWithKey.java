package com.kimput.concurrency._1_understanding_concurrency;

public class LongWrapperWithKey extends LongWrapper {

    private Object key = new Object();

    public LongWrapperWithKey(long l) {
        super(l);
    }

    @Override
    public void incrementValue(){
        synchronized (key) {
            this.l = this.l + 1;
        }
    }
}
