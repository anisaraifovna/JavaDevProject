package common.exception;

public enum BusinessCommonErrorCodes {
    ERR_CARD_FORMAT(6, "Неверный формат номер карты [%s]."),
    ERR_PIN_FORMAT(7, "Неверный формат пин-кода.");

    private final int code;
    private final String message;

    BusinessCommonErrorCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
