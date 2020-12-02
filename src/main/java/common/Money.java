package common;

import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.Currency;

@Getter @NonNull
public class Money {

    private BigDecimal value;
    private Currency currency;

    public Money(BigDecimal value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }
}
