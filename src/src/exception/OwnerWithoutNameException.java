package exception;

/**
 * Created by Jerry on 23-04-2015.
 */
public class OwnerWithoutNameException extends RuntimeException{
    public OwnerWithoutNameException(String s) {
        super(s);

    }
}
