package common;

public enum ErrorCodes {
    ERR_DOUBLE_TRANSACTION(1, "Транзакция уже была в обработке."),
    ERR_NOT_ENOUGH_MONEY(2, "Недостаточно средств."),
    ERR_NOT_FOUND_RATE(3, "Не найден курс для конвертации из %s в %s."),
    ERR_NOT_FOUND_ACCOUNT(4, "Не найден счет по карте %s."),
    ERR_ATM_CASH_AVAIL(5, "Невозможно выдать введенную сумму %s %s."),
    ERR_CARD_FORMAT(6, "Неверный формат номер карты [%s]."),
    ERR_PIN_FORMAT(7, "Неверный формат пин-кода.");

    private int code;
    private String message;

    ErrorCodes(int code, String message) {
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
