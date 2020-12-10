package atm;

import atm.exceptions.ATMCashNotAvailableException;
import bank.transactions.TransactionServer;
import bank.transactions.TransactionCash;
import bank.transactions.exceptions.DoubleTransactionException;
import common.Currency;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import transport.Connection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import static atm.Banknote.*;

@NonNull @Getter
public class ATM {

    private List<Cassette> cassette;
    private Connection connection;
    private int deviceId;
    private int operationId;

    public ATM() {
        //todo чтение из properties количество банкнот в кассетах и коннект. это должно быть static?
        cassette = new ArrayList<>();
        cassette.add(new Cassette(RUR_100,100));
        cassette.add(new Cassette(RUR_1000,100));
        cassette.add(new Cassette(USD_20,100));
        cassette.add(new Cassette(EUR_50,100));
        connection = new Connection("Bank", 443);
        deviceId = 1;
        operationId = 0;
    }

    private boolean checkAvailableCash (Currency currency, int value){
        int sum = cassette.stream()
                .filter(c -> c.getBanknote().getCurrency().equals(currency))
                .mapToInt(c -> c.getBanknote().getDenomination()*c.getCurrentAmount())
                .sum();

        return sum >= value;
    }

    public List<Banknote> getCash (accesstools.Card card, Currency currency, int value) throws ATMCashNotAvailableException, DoubleTransactionException {

        operationId++;

        if (!checkAvailableCash(currency, value))
            throw new ATMCashNotAvailableException();

        TransactionServer transactionServer = connection.open();
        TransactionCash transactionCash = new TransactionCash(card, new Money(BigDecimal.valueOf(value), currency), deviceId, operationId);
        transactionServer.executeTransaction(transactionCash);
        connection.close();
        return getBanknotes (currency, value);
    }

    private List<Banknote> getBanknotes(Currency currency, int value) {
        //todo выемка купюр
        return new ArrayList<>();
    }
}
