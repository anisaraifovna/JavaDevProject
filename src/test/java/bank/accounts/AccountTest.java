package bank.accounts;

import common.Currency;
import common.Money;
import common.accesstools.DebitCard;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class AccountTest {
    @Mock
    DebitCard debitCard;
    Account<DebitCard> account = new Account(1, new Money(BigDecimal.valueOf(500), Currency.RUR), debitCard);

    @Test
    void testDecrease() {
        account.decrease(new Money(BigDecimal.valueOf(500), Currency.RUR), BigDecimal.ONE);
        assert (account.getBalance().getValue().equals(BigDecimal.valueOf(0)));
    }

    @Test
    void testIncrease() {
        account.increase(new Money(BigDecimal.valueOf(500), Currency.RUR), BigDecimal.ONE);
        assert (account.getBalance().getValue().equals(BigDecimal.valueOf(1000)));
    }
}