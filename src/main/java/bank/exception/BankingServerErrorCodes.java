package bank.exception;

public enum BankingServerErrorCodes {
    ERR_DOUBLE_TRANSACTION(1, "Транзакция уже была в обработке."),
    ERR_NOT_ENOUGH_MONEY(2, "Недостаточно средств."),
    ERR_NOT_FOUND_RATE(3, "Не найден курс для конвертации из %s в %s."),
    ERR_NOT_FOUND_ACCOUNT(4, "Не найден счет по карте %s.");

    private final int code;
    private final String message;

    BankingServerErrorCodes(int code, String message) {
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
