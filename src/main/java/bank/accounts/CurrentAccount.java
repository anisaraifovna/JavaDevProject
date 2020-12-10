package bank.accounts;

import common.Money;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class CurrentAccount extends Account {

    public CurrentAccount(@NonNull int accountId, @NonNull Money balance, String cardNumber) {
        super(accountId, balance, cardNumber);
    }
}
