package bank.transactions;

import bank.accounts.Account;
import bank.exception.BankingServerException;
import common.Currency;
import common.Money;
import common.accesstools.DebitCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class TransactionCashTest {

    @Mock
    DebitCard card;
    @InjectMocks
    TransactionCash transactionCash = new TransactionCash(card, new Money(BigDecimal.valueOf(50), Currency.USD), 1, 1);

    @Test
    public void testInit() {
        Account<DebitCard> account = new Account<>(1, new Money(BigDecimal.valueOf(20), Currency.USD), card);
        transactionCash.setAccount(account);
        transactionCash.setRate(BigDecimal.ONE);
        Assertions.assertEquals(transactionCash.getAccount().getAccountId(), 1);
    }

    @Test
    public void testExecuteDefault() throws BankingServerException {
        transactionCash.setAccount(new Account<>(1, new Money(BigDecimal.valueOf(500), Currency.RUR), card));
        transactionCash.setRate(BigDecimal.valueOf(1.5));
        transactionCash.execute(x -> x.signum() > 0);
        Assertions.assertEquals(transactionCash.getAccount().getBalance().getValue(), BigDecimal.valueOf(425.0));
    }

    @Test
    public void testExecuteException() {
        transactionCash.setAccount(new Account<>(1, new Money(BigDecimal.valueOf(20), Currency.USD), card));
        transactionCash.setRate(BigDecimal.ONE);
        BankingServerException thrown = Assertions.assertThrows(
                BankingServerException.class,
                () -> transactionCash.execute(x -> x.signum() > 0)
        );
        Assertions.assertTrue(thrown.getMessage().contains("Недостаточно средств. Код ошибки: 2"));
    }

    @Test
    public void testDoubleCheck() {
        TransactionCash transactionCash2 = new TransactionCash(card, new Money(BigDecimal.valueOf(50), Currency.USD), 1, 1);
        transactionCash.setAccount(new Account<>(2, new Money(BigDecimal.valueOf(20), Currency.USD), card));
        transactionCash.setRate(BigDecimal.ZERO);
        transactionCash2.setAccount(new Account<>(1, new Money(BigDecimal.valueOf(20), Currency.USD), card));
        transactionCash2.setRate(BigDecimal.ONE);
        Assertions.assertTrue(transactionCash2.doubleCheck(transactionCash));
    }
}