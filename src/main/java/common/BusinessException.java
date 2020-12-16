package common;

public class BusinessException extends Exception {

    public BusinessException(ErrorCodes errorCode, String ... args){
        super(String.format(errorCode.getMessage(), args)+" Код ошибки: "+ errorCode.getCode());
    }

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
