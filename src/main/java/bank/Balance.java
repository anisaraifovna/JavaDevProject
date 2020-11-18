package bank;

import java.math.BigDecimal;
import java.util.Currency;

public class Balance {
    private BigDecimal value;
    private Currency currency;

    public Balance(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public BigDecimal getValue() {
        return value;
    }

    public Currency getCurrency() {
        return currency;
    }
}
