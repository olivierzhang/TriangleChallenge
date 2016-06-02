package exception;

public class IllegalFormatException extends RuntimeException {

    private ErrorCode errorCode = null;
    private String detail = null;

    public IllegalFormatException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public IllegalFormatException(ErrorCode errorCode, String detail) {
        super(errorCode.getDescription() + " : " + detail);
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public String getErrorMessage() {
        return null == detail ? errorCode.getDescription() : errorCode.getDescription() + " : " + detail;
    }
}
