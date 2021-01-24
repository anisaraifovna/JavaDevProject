package bank.exchange;

import bank.exception.BankingServerException;
import common.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

class ExchangeStorageTest {

    ExchangeStorage exchangeStorage = new ExchangeStorage();

    @BeforeEach
    public void initData() {
        List<ExchangeRate> listRate = new ArrayList<>();
        listRate.add(new ExchangeRate(Currency.USD, Currency.RUR, BigDecimal.valueOf(60)));
        exchangeStorage.setExchangeRates(listRate);
    }

    @Test
    public void testGetRateSameCur() throws BankingServerException {
        Assertions.assertEquals(exchangeStorage.getRate(Currency.RUR, Currency.RUR), BigDecimal.ONE);
    }

    @Test
    public void testGetRateDifCur() throws BankingServerException {
        Assertions.assertEquals(exchangeStorage.getRate(Currency.USD, Currency.RUR), BigDecimal.valueOf(60));
    }

    @Test
    public void testGetRateException() {
        BankingServerException thrown = Assertions.assertThrows(
                BankingServerException.class,
                () -> exchangeStorage.getRate(Currency.RUR, Currency.USD)
        );
        Assertions.assertTrue(thrown.getMessage().contains("Не найден курс для конвертации из RUR в USD. Код ошибки: 3"));
    }

}