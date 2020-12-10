package bank.accounts;

import bank.accounts.exceptions.NotFoundAccountException;
import common.Currency;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NonNull
public class AccountStorage<E extends Account> {
    private List<E> accounts;

    public AccountStorage() {
        this.accounts = new ArrayList<>();
        //todo  получение из базы, пока заглушка. + спросить как работать с дженериками в такой ситуации
        accounts.add((E) new Account(1, new Money(BigDecimal.valueOf(1000), Currency.RUR),"1234567891011121"));
    }

    public E getAccountByCard(String cardNumber) throws NotFoundAccountException {
        return accounts.stream()
                .filter(s -> s.getCardNumber().equals(cardNumber))
                .findAny()
                .orElseThrow(NotFoundAccountException::new);
    }
}
