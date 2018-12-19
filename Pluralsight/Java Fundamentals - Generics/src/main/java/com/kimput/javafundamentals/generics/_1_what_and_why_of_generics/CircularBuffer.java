package main.com.kimput.javafundamentals.generics._1_what_and_why_of_generics;

class CircularBuffer<T> {
    private T[] buffer;
    private int readCursor = 0;
    private int writeCursor = 0;

    CircularBuffer(int size) {
        buffer =  (T[]) new Object[size];
    }

    boolean offer(T value) {
        if (buffer[writeCursor] != null) {
            return false;
        }
        buffer[writeCursor] = value;
        writeCursor = next(writeCursor);
        return true;
    }

    T poll() {
        final T value = buffer[readCursor];
        if (value != null) {
            buffer[readCursor] = null;
            readCursor = next(readCursor);
       }
        return value;
    }

    private int next(int index) {
        return (index + 1) % buffer.length;
    }
}
