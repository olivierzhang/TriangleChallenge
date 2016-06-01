package exception;

public class IllegalConditionException extends RuntimeException {

    public IllegalConditionException(ErrorCode errorCode) {
        this(errorCode.getDescription());
    }

    public IllegalConditionException(String message) {
        super(message);
    }
}
