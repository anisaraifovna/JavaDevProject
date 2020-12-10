package bank.transactions.exceptions;

public class DoubleTransactionException extends Exception{

    private final static String MESSAGE = "Транзакция уже была в обработке";

    public DoubleTransactionException() {
        super(MESSAGE);
    }

    public DoubleTransactionException(String message) {
        super(MESSAGE+" "+message);
    }

    public DoubleTransactionException(String message, Throwable cause) {
        super(MESSAGE+" "+message, cause);
    }

    public DoubleTransactionException(Throwable cause) {
        super(cause);
    }

    public DoubleTransactionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(MESSAGE+" "+message, cause, enableSuppression, writableStackTrace);
    }
}
