package atm;

import atm.exception.ATMException;
import common.Currency;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ATMTest {

    ATM atm = new ATM(1, 1);
    List<Cassette> cassettes = new ArrayList<>();

    @BeforeEach
    void init() {
        cassettes.add(new Cassette(1, Banknote.USD_20, 200));
        cassettes.add(new Cassette(2, Banknote.USD_20, 100));
        cassettes.add(new Cassette(3, Banknote.USD_50, 100));
        cassettes.add(new Cassette(4, Banknote.USD_100, 100));
        cassettes.add(new Cassette(5, Banknote.RUR_100, 200));
        cassettes.add(new Cassette(6, Banknote.RUR_500, 200));
        cassettes.add(new Cassette(7, Banknote.RUR_1000, 200));
        cassettes.add(new Cassette(8, Banknote.RUR_5000, 200));
        atm.setCassette(cassettes);
    }

    @Test
    void testSumByCurrency() {
        Assertions.assertEquals(1320000, atm.sumByCurrency(Currency.RUR));
    }

    @Test
    void testCheckAvailableCash() {
        Assertions.assertTrue(atm.checkAvailableCash(Currency.RUR, 1320000));
        Assertions.assertFalse(atm.checkAvailableCash(Currency.RUR, 1320001));
    }

    @Test
    void testGetBanknotesDefault() throws ATMException {
        Map<Banknote, Integer> cash = atm.getBanknotes(Currency.USD, 18220);
        Assertions.assertEquals(cash.get(Banknote.USD_100), 100);
        Assertions.assertEquals(cash.get(Banknote.USD_50), 100);
        Assertions.assertEquals(cash.get(Banknote.USD_20), 161);
    }

    @Test
    void testGetBanknotesException() {
        ATMException thrown = Assertions.assertThrows(
                ATMException.class,
                () -> atm.getBanknotes(Currency.USD, 28220));
        assertTrue(thrown.getMessage().contains("Невозможно выдать введенную сумму 28220 USD. Код ошибки: 1"));
    }
}