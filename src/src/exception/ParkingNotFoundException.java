package exception;

public class ParkingNotFoundException extends RuntimeException{

    public ParkingNotFoundException(String message) {
        super(message);
    }
}
