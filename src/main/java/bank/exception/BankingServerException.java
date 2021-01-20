package bank.exception;

public class BankingServerException extends Exception {

    public BankingServerException(BankingServerErrorCodes errorCode, String... args) {
        super(String.format(errorCode.getMessage(), args) + " Код ошибки: " + errorCode.getCode());
    }

    public BankingServerException() {
    }

    public BankingServerException(String message) {
        super(message);
    }

    public BankingServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankingServerException(Throwable cause) {
        super(cause);
    }

    public BankingServerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
