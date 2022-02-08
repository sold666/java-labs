package lab2.exceptions;

public class OverflowException extends OutOfMemoryError {
    public OverflowException(String message) {
        super(message);
    }
}
