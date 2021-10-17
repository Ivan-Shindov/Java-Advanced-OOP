package student;

public class InvalidPersonNameException extends RuntimeException {
    private final String MESSAGE = "Input contains not allowed symbols";

    public InvalidPersonNameException() {
    }

    public String getMessage() {
        return MESSAGE;
    }
}
