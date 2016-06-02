package exception;

public class OutOfRangeException extends RuntimeException {

    private ErrorCode errorCode = null;
    private String detail = null;

    public OutOfRangeException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public OutOfRangeException(ErrorCode errorCode, String detail) {
        super(errorCode.getDescription() + " : " + detail);
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public String getErrorMessage() {
        return null == detail ? errorCode.getDescription() : errorCode.getDescription() + " : " + detail;
    }
}
