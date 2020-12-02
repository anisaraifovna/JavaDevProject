package atm.exceptions;

public class ATMCashNotAvailableException extends Exception {

    private final static String MESSAGE = "Невозможно выдать введенную сумму";

    public ATMCashNotAvailableException() {
        super(MESSAGE);
    }

    public ATMCashNotAvailableException(String message) {
        super(MESSAGE+" "+message);
    }

    public ATMCashNotAvailableException(String message, Throwable cause) {
        super(MESSAGE+" "+message, cause);
    }

    public ATMCashNotAvailableException(Throwable cause) {
        super(cause);
    }

    public ATMCashNotAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE+" "+message, cause, enableSuppression, writableStackTrace);
    }
}
