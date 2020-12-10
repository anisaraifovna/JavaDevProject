package bank.accounts.exceptions;

public class NotFoundAccountException extends Exception{
    private final static String MESSAGE = "Счет не найден";

    public NotFoundAccountException() {
        super(MESSAGE);
    }

    public NotFoundAccountException(String message) {
        super(MESSAGE+" "+message);
    }

    public NotFoundAccountException(String message, Throwable cause) {
        super(MESSAGE+" "+message, cause);
    }

    public NotFoundAccountException(Throwable cause) {
        super(cause);
    }

    public NotFoundAccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE+" "+message, cause, enableSuppression, writableStackTrace);
    }
}
