package bank.transactions;

import bank.accounts.Account;
import bank.accounts.AccountStorage;
import bank.exception.BankingServerErrorCodes;
import bank.exception.BankingServerException;
import bank.exchange.ExchangeStorage;
import common.Money;
import common.accesstools.DebitCard;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

@Getter
public class TransactionCash {

    @Setter
    private TransactionStatus status;
    private final Money money;
    private final DebitCard card;
    private final LocalDateTime datetime;
    private final int deviceId;
    private final int operationId;
    @Setter
    private BigDecimal rate;
    @Setter
    private Account<DebitCard> account;

    public TransactionCash(DebitCard card, Money money, int deviceId, int operationId) {
        this.money = money;
        this.card = card;
        this.deviceId = deviceId;
        this.operationId = operationId;
        datetime = LocalDateTime.now();
    }

    public void init() throws BankingServerException {
        setAccount(new AccountStorage().getAccountByCard(getCard().getNumber()));
        setRate(new ExchangeStorage().getRate(getMoney().getCurrency(), account.getBalance().getCurrency()));
    }

    public void execute(Predicate<BigDecimal> predicate) throws BankingServerException {
        account.decrease(money, rate);
        if (!predicate.test(account.getBalance().getValue()))
            throw new BankingServerException(BankingServerErrorCodes.ERR_NOT_ENOUGH_MONEY);
    }

    public boolean doubleCheck(TransactionCash transactionCash) {
        return deviceId == transactionCash.getDeviceId() &&
                operationId == transactionCash.getOperationId() &&
                Objects.equals(money, transactionCash.getMoney()) &&
                Objects.equals(card, transactionCash.getCard());
    }
}
