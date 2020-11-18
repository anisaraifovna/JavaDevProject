package atm;

import bank.Transaction;

import java.math.BigDecimal;
import java.util.Currency;

public class ATM {

    private Cassette[] cassettes;

    public void getCash (access.Card card, int value, Currency currency){
        Transaction transaction = new Transaction();
        transaction.getCash(card, BigDecimal.valueOf(value), currency);
        //todo выемка купюр из кассет
    }
}
