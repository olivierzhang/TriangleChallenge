package exception;

public enum ErrorCode {

    ILLEGAL_TRIANGLE("Illegal Triangle"),
    LENGTH_SHOULD_BIGGER_THAN_ZERO("The length should be bigger than 0"),
    ILLEGAL_LENGTH_VALUE("Illegal length value, value contains illegal character"),
    ILLEGAL_INPUT_FORMAT("Illegal Input format, input 3 lengths separated by comma");

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
