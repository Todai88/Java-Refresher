package main.com.kimput.b2csite.common;

public class DataAccessException extends Exception {
    private static final long serialVersionUID = -1530578540919250393L;

    public DataAccessException(String message) {
        super(message);
    }

    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
