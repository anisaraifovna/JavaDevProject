package atm;

import lombok.Getter;

import java.util.Currency;

public enum Banknote {

    RUR_100 (100,Currency.getInstance("RUR")),
    RUR_500 (500,Currency.getInstance("RUR")),
    RUR_1000 (1000,Currency.getInstance("RUR")),
    RUR_5000 (5000,Currency.getInstance("RUR")),
    USD_20 (20,Currency.getInstance("USD")),
    USD_50 (50,Currency.getInstance("USD")),
    USD_100 (100,Currency.getInstance("USD")),
    EUR_20 (20,Currency.getInstance("EUR")),
    EUR_50 (50,Currency.getInstance("EUR")),
    EUR_100 (100,Currency.getInstance("EUR"));

    @Getter private final int denomination;
    @Getter private final Currency currency;

    Banknote(int denomination, Currency currency) {
        this.denomination = denomination;
        this.currency = currency;
    }
}
