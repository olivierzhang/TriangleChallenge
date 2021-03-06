package exception;

public class IllegalConditionException extends RuntimeException {

    private ErrorCode errorCode = null;
    private String detail = null;

    public IllegalConditionException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public IllegalConditionException(ErrorCode errorCode, String detail) {
        super(errorCode.getDescription() + " : " + detail);
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public String getErrorMessage() {
        return null == detail ? errorCode.getDescription() : errorCode.getDescription() + " : " + detail;
    }
}
