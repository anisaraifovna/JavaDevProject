package bank;

import accesstools.Card;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Currency;

@Getter @Setter
public class Account {

    @NonNull
    private Money balance;
    private Card card;

    public static Account findAccount(Card card) {
        //todo поиск акканута и получение его инфы из хранилища данных
        Account account = new Account();
        account.setBalance(new Money(BigDecimal.valueOf(2000), Currency.getInstance("RUR")));
        return account;
    }

    public void decrease (Money value){
        //todo проверка на соответвие валюты и/или конвертация
        balance = new Money(balance.getValue().subtract(value.getValue()), balance.getCurrency());
    }
}
