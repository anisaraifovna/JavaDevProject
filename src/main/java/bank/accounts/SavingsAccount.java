package bank.accounts;

import common.Money;
import lombok.Getter;
import lombok.NonNull;

@Getter @NonNull
public class SavingsAccount extends Account {
    private double percent; //проценты по вкладам тоде должны быть bigdecimal?

    public SavingsAccount(@NonNull int accountId, @NonNull Money balance, String cardNumber, double percent) {
        super(accountId, balance, cardNumber);
        this.percent = percent;
    }
}
