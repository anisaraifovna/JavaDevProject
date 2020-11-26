package accesstools.exceptions;

public class CardFormatException extends Exception {

    public CardFormatException() {
    }

    public CardFormatException(String errorMessage) {
        super(errorMessage);
    }

    public CardFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public CardFormatException(Throwable cause) {
        super(cause);
    }

    public CardFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
