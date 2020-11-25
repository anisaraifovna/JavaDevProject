package atm.exceptions;

public class ATMAvailableSumException extends Exception {
    public ATMAvailableSumException() {
        super("Невозможно выдать введенную сумму");
    }
}
