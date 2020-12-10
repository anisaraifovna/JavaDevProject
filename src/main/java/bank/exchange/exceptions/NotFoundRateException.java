package bank.exchange.exceptions;

public class NotFoundRateException extends Exception {
    private final static String MESSAGE = "Не найден курс для конвертации";

    public NotFoundRateException() {
        super(MESSAGE);
    }

    public NotFoundRateException(String message) {
        super(MESSAGE+" "+message);
    }

    public NotFoundRateException(String message, Throwable cause) {
        super(MESSAGE+" "+message, cause);
    }

    public NotFoundRateException(Throwable cause) {
        super(cause);
    }

    public NotFoundRateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE+" "+message, cause, enableSuppression, writableStackTrace);
    }
}
