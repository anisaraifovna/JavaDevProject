package bank;

import access.Card;
import java.math.BigDecimal;
import java.util.Currency;

public class Account {
    private Balance balance;
    private Card card;

    public Balance getBalance() {
        return balance;
    }

    public void decrease (BigDecimal value, Currency currency){
        //todo проверка на соответвие валюты
        balance = new Balance(balance.getValue().subtract(value), balance.getCurrency());
    }
}
