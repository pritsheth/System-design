package exception;

/**
 * Created by Jerry on 23-04-2015.
 */
public class InvalidInputException extends RuntimeException {
    public InvalidInputException(String message) {
        super(message);
    }
}
