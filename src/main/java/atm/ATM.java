package atm;

import accesstools.DebitCard;
import bank.transactions.TransactionServer;
import bank.transactions.TransactionCash;
import common.BusinessException;
import common.Currency;
import common.ErrorCodes;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import transport.Connection;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NonNull @Getter
public class ATM {

    private List<Cassette> cassette = new ArrayList<>();
    private Connection connection = new Connection("Bank", 443);
    private int deviceId = 1;
    private int operationId = 0;

    private boolean checkAvailableCash (Currency currency, int value){
        int sum = cassette.stream()
                .filter(c -> c.getBanknote().getCurrency().equals(currency))
                .mapToInt(c -> c.getBanknote().getDenomination()*c.getCurrentAmount())
                .sum();

        return sum >= value;
    }

    public List<Banknote> getCash (DebitCard card, Currency currency, int value) throws BusinessException {

        operationId++;

        if (!checkAvailableCash(currency, value))
            throw new BusinessException(ErrorCodes.ERR_ATM_CASH_AVAIL,String.valueOf(value),currency.getCode());

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
