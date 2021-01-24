package common.exception;

public class BusinessCommonException extends Exception {

    public BusinessCommonException(BusinessCommonErrorCodes errorCode, String... args) {
        super(String.format(errorCode.getMessage(), args) + " Код ошибки: " + errorCode.getCode());
    }

    public BusinessCommonException() {
    }

    public BusinessCommonException(String message) {
        super(message);
    }

    public BusinessCommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessCommonException(Throwable cause) {
        super(cause);
    }

    public BusinessCommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
