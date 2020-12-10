package bank.exchange;

import bank.exchange.exceptions.NotFoundRateException;
import common.Currency;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NonNull @Getter
public class ExchangeStorage {
    private List<ExchangeRate> exchangeRates = new ArrayList<>();

    public BigDecimal getRate(Currency fromCurrency, Currency toCurrency) throws NotFoundRateException {
        if (fromCurrency.equals(toCurrency))
            return BigDecimal.valueOf(1);

        ExchangeRate rate = exchangeRates.stream()
                .filter(s -> s.getFromCurrency().equals(fromCurrency)&&s.getToCurrency().equals(toCurrency))
                .findAny()
                .orElseThrow(NotFoundRateException::new);

        return rate.getRate();
    }
}
