package bank.accounts;

import bank.exchange.ExchangeStorage;
import bank.exchange.excpeitons.NotFoundRateException;
import common.Money;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;

@Getter
public class Account {

    @NonNull
    private int accountId;
    @NonNull
    private Money balance;
    private String cardNumber;

    public Account(@NonNull int accountId, @NonNull Money balance, String cardNumber) {
        this.accountId = accountId;
        this.balance = balance;
        this.cardNumber = cardNumber;
    }

    public void decrease (Money value) throws NotFoundRateException {
        BigDecimal rate = new ExchangeStorage().getRate(value.getCurrency(),balance.getCurrency());
        balance = new Money(balance.getValue().subtract(value.getValue().multiply(rate)), balance.getCurrency());
    }

    public void increase (Money value) throws NotFoundRateException {
        BigDecimal rate = new ExchangeStorage().getRate(value.getCurrency(),balance.getCurrency());
        balance = new Money(balance.getValue().add(value.getValue().multiply(rate)), balance.getCurrency());
    }
}
