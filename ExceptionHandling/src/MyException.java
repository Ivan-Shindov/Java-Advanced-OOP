public class MyException extends RuntimeException {
    private final String MESSAGE = "Number is out of range 1...100 ! Number must contains only digits";

    public MyException(String cause) {
        super(cause);
    }
    public MyException() {}

    @Override
    public String getMessage() {
        return MESSAGE;
    }
}
