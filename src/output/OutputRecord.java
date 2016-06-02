package output;

public class OutputRecord {

    private String input;
    private String result;
    private boolean hasError = false;

    public OutputRecord(String input, String result, boolean hasError) {
        this.input = input;
        this.result = result;
        this.hasError = hasError;
    }

    @Override
    public String toString() {
        return input + "---> " + result;
    }
}
