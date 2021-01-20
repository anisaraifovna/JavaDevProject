package bank.accounts;

import bank.exception.BankingServerException;
import common.Currency;
import common.Money;
import common.accesstools.DebitCard;
import common.exception.BusinessCommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class AccountStorageTest {

    AccountStorage accountStorage = new AccountStorage();

    @BeforeEach
    public void initData() throws BusinessCommonException {
        List<Account<DebitCard>> list = new ArrayList<>();
        list.add(new Account<>(1, new Money(BigDecimal.ZERO, Currency.RUR), new DebitCard("0123456789101112", LocalDate.of(2020, 12, 2), "1234")));
        accountStorage.setAccounts(list);
    }

    @Test
    void testGetAccountByCardDef() throws BankingServerException {
        Account<DebitCard> account = accountStorage.getAccountByCard("0123456789101112");
        Assertions.assertEquals(account.getAccountId(), 1);
    }

    @Test
    void testGetAccountByCardEx() {
        BankingServerException thrown = Assertions.assertThrows(
                BankingServerException.class,
                () -> accountStorage.getAccountByCard("012345678910111"));
        Assertions.assertTrue(thrown.getMessage().contains("Не найден счет по карте *111. Код ошибки: 4"));
    }
}