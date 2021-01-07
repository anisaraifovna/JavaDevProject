package bank.exchange;

import common.Currency;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;

@Getter @NonNull
public class ExchangeRate {
    private Currency fromCurrency;
    private Currency toCurrency;
    private BigDecimal rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, BigDecimal rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }
}
