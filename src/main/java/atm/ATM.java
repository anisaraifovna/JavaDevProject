package atm;

import atm.exceptions.ATMAvailableSumException;
import bank.Transaction;
import common.Money;
import lombok.NonNull;
import transport.Connection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import static atm.Banknote.*;

public class ATM {

    @NonNull
    private List<Cassette> cassette;
    @NonNull
    private Connection connection;

    public ATM() {
        //todo чтение из properties количество банкнот в кассетах и коннект. это должно быть static?
        cassette = new ArrayList<>();
        cassette.add(new Cassette(RUR_100,100));
        cassette.add(new Cassette(RUR_1000,100));
        cassette.add(new Cassette(USD_20,100));
        cassette.add(new Cassette(EUR_50,100));
        connection = new Connection("Bank", 443);
    }

    private boolean checkAvailableValue(Currency currency, int value){
        int sum = cassette.stream()
                .filter(c -> c.getBanknote().getCurrency().equals(currency))
                .mapToInt(c -> c.getBanknote().getDenomination()*c.getCurrentAmount())
                .sum();
        return sum >= value;
    }

    public List<Banknote> getCash (accesstools.Card card, Currency currency, int value) throws ATMAvailableSumException {

        if (!checkAvailableValue(currency, value))
            throw new ATMAvailableSumException();

        connection.open();
        Transaction transaction = new Transaction(card, new Money(BigDecimal.valueOf(value), currency));
        transaction.doTransaction();
        connection.close();
        return getBanknotes (currency, value);
    }

    private List<Banknote> getBanknotes(Currency currency, int value) {
        //todo выемка купюр
        return new ArrayList<>();
    }
}
