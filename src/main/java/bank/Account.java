package bank;

import accesstools.Card;
import common.Money;
import javafx.print.Printer;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Currency;

public class Account {

    @Getter @Setter @NonNull
    private Money balance;
    @Getter @Setter
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
