package src.book.exercises.ch_3;

public interface IntSequence {
    static IntSequence of (int... list) {
        return new IntSequence() {
            private int pos = 0;

            @Override
            public boolean hasNext(){
                return pos < list.length;
            }

            @Override
            public int next() {
                return hasNext() ? list[pos++] : 0;
            }
        };
    }
    boolean hasNext();
    int next();
}
