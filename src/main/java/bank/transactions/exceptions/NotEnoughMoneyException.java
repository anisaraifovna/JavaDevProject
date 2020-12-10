package bank.transactions.exceptions;

public class NotEnoughMoneyException extends Exception{

    private final static String MESSAGE = "Недостаточно средтств на счете";

    public NotEnoughMoneyException() {
        super(MESSAGE);
    }

    public NotEnoughMoneyException(String message) {
        super(MESSAGE+" "+message);
    }

    public NotEnoughMoneyException(String message, Throwable cause) {
        super(MESSAGE+" "+message, cause);
    }

    public NotEnoughMoneyException(Throwable cause) {
        super(cause);
    }

    public NotEnoughMoneyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE+" "+message, cause, enableSuppression, writableStackTrace);
    }
}
