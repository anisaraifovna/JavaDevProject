package bank.transactions;

import accesstools.DebitCard;
import bank.accounts.Account;
import bank.accounts.AccountStorage;
import common.BusinessException;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

@Getter @NonNull
public class TransactionCash {

    @Setter
    private TransactionStatus status;
    private Money money;
    private DebitCard card;
    private LocalDateTime datetime;
    private int deviceId;
    private int operationId;

    public TransactionCash(DebitCard card, Money money, int deviceId, int operationId) {
        this.money = money;
        this.card = card;
        this.deviceId = deviceId;
        this.operationId = operationId;
        datetime = LocalDateTime.now();
    }

    public void execute(Predicate<BigDecimal> predicate) throws BusinessException {
        Account<DebitCard> account = new AccountStorage().getAccountByCard(card);
        account.decrease(money);
        predicate.test(account.getBalance().getValue());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionCash that = (TransactionCash) o;
        return deviceId == that.deviceId &&
                operationId == that.operationId &&
                Objects.equals(money, that.money) &&
                Objects.equals(card, that.card);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, card, deviceId, operationId);
    }
}
