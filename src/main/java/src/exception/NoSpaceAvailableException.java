package exception;

/**
 * Created by Jerry on 23-04-2015.
 */
public class NoSpaceAvailableException extends RuntimeException {
    public NoSpaceAvailableException(String message) {
        super(message);
    }
}
