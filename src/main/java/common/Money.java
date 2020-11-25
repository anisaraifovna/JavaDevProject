package common;

import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Currency;

public class Money {
    @Getter @NonNull
    private BigDecimal value;
    @Getter @NonNull
    private Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
