package exception;

public class AgentWithoutNameException extends RuntimeException{


    public AgentWithoutNameException(String message) {
        super(message);
    }
}
