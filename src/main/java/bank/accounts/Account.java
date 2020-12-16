package bank.accounts;

import accesstools.Card;
import bank.exchange.ExchangeStorage;
import common.BusinessException;
import common.Money;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;

@Getter @Builder
public class Account<T extends Card> {

    @NonNull
    private int accountId;
    @NonNull
    private Money balance;
    private T card;

    public Account(@NonNull int accountId, @NonNull Money balance, T card) {
        this.accountId = accountId;
        this.balance = balance;
        this.card = card;
    }

    public void decrease (Money value) throws BusinessException {
        BigDecimal rate = new ExchangeStorage().getRate(value.getCurrency(),balance.getCurrency());
        balance = new Money(balance.getValue().subtract(value.getValue().multiply(rate)), balance.getCurrency());
    }

    public void increase (Money value) throws BusinessException {
        BigDecimal rate = new ExchangeStorage().getRate(value.getCurrency(),balance.getCurrency());
        balance = new Money(balance.getValue().add(value.getValue().multiply(rate)), balance.getCurrency());
    }
}
