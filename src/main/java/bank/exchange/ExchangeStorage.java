package bank.exchange;

import common.BusinessException;
import common.Currency;
import common.ErrorCodes;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NonNull @Getter @Setter
public class ExchangeStorage {
    private List<ExchangeRate> exchangeRates = new ArrayList<>();

    public BigDecimal getRate(Currency fromCurrency, Currency toCurrency) throws BusinessException {
        if (fromCurrency.equals(toCurrency))
            return BigDecimal.ONE;

        ExchangeRate rate = exchangeRates.stream()
                .filter(s -> s.getFromCurrency().equals(fromCurrency)&&s.getToCurrency().equals(toCurrency))
                .findAny()
                .orElseThrow(() -> new BusinessException(ErrorCodes.ERR_NOT_FOUND_RATE,fromCurrency.getCode(),toCurrency.getCode()));
        return rate.getRate();
    }
}
