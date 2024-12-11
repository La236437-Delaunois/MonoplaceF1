package exceptions;

public class NegativeArgumentException extends RuntimeException {
    public NegativeArgumentException(String message) {
        super(message);
    }
}
