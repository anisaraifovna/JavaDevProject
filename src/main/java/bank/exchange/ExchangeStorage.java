package bank.exchange;

import bank.exchange.excpeitons.NotFoundRateException;
import common.Currency;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NonNull @Getter
public class ExchangeStorage {
    private List<ExchangeRate> exchangeRates = new ArrayList<>();

    public ExchangeStorage() {
        //todo  получение из базы
        exchangeRates.add(new ExchangeRate(Currency.RUR, Currency.USD, BigDecimal.valueOf(0.014)));
        exchangeRates.add(new ExchangeRate(Currency.RUR, Currency.EUR, BigDecimal.valueOf(0.011)));
        exchangeRates.add(new ExchangeRate(Currency.EUR, Currency.RUR, BigDecimal.valueOf(89.11)));
        exchangeRates.add(new ExchangeRate(Currency.USD, Currency.RUR, BigDecimal.valueOf(73.67)));
    }

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
