package exception;

public class CarNotValidException extends RuntimeException{

    public CarNotValidException(String message) {
        super(message);
    }
}
