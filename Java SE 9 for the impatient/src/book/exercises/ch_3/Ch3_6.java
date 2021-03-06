package src.book.exercises.ch_3;

import java.math.BigInteger;

public class Ch3_6 {
    interface Sequence<T> {
        default boolean hasNext() {
            return true;
        }

        T next();
    }

    public static class SquareSequence implements Sequence<BigInteger> {
        private Integer value = 1;

        @Override
        public BigInteger next() {
            var v = new BigInteger(value.toString());
            value++;
            return v.multiply(v);
        }
    }
}
