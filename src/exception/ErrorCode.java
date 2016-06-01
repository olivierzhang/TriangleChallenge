package exception;

public enum ErrorCode {

    ILLEGAL_TRIANGLE("Illegal Triangle"), ILLEGAL_INPUT("Illegal Input");

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
