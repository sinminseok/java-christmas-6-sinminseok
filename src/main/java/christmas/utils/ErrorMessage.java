package christmas.utils;

public class ErrorMessage extends IllegalArgumentException {
    private static final String ERROR_MESSAGE = "[ERROR] %s";

    public ErrorMessage(String message) {
        super(String.format(ERROR_MESSAGE, message));
        System.out.println(String.format(ERROR_MESSAGE, message));
    }
}