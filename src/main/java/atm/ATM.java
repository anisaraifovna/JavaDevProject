package atm;

import atm.exception.ATMErrorCodes;
import atm.exception.ATMException;
import bank.transactions.TransactionServer;
import common.Currency;
import common.Money;
import common.accesstools.DebitCard;
import common.transport.Connection;
import lombok.Getter;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NonNull
@Getter
public class ATM {

    private final Connection connection = new Connection("Bank", 443);
    private final int deviceId;
    private List<Cassette> cassettes = new ArrayList<>();
    private int operationId;

    public ATM(int deviceId, int operationId) {
        this.deviceId = deviceId;
        this.operationId = operationId;
    }

    public void setCassette(List<Cassette> cassette) {
        this.cassettes = cassette;
        cassettes.sort((Cassette o1, Cassette o2) -> o2.getBanknote().getDenomination() - o1.getBanknote().getDenomination());
    }

    public int sumByCurrency(Currency currency) {
        return cassettes.stream()
                .filter(c -> c.getBanknote().getCurrency().equals(currency))
                .mapToInt(c -> c.getBanknote().getDenomination() * c.getCurrentAmount())
                .sum();
    }

    public boolean checkAvailableCash(Currency currency, int value) {
        return sumByCurrency(currency) >= value;
    }

    public Map<Banknote, Integer> getCash(DebitCard card, Currency currency, int value) throws ATMException {

        cleanCache();
        operationId++;

        if (!checkAvailableCash(currency, value))
            throw new ATMException(ATMErrorCodes.ERR_ATM_CASH_AVAIL, String.valueOf(value), currency.getCode());

        TransactionServer transactionServer = connection.open();
        try {
            transactionServer.executeTransaction(card, new Money(BigDecimal.valueOf(value), currency), deviceId, operationId);
        } catch (Exception e) {
            throw new ATMException(ATMErrorCodes.ERR_SERVER, e.getMessage());
        }
        connection.close();
        return getBanknotes(currency, value);
    }

    public void cleanCache() {
        cassettes.forEach(x -> x.setCache(0));
    }

    public Map<Banknote, Integer> getBanknotes(Currency currency, int value) throws ATMException {
        int tmpVal = value;
        Map<Banknote, Integer> banknotes = new HashMap<>();
        for (Cassette cassette : cassettes) {
            if (cassette.getBanknote().getCurrency().equals(currency) && cassette.getCurrentAmount() > 0) {
                int count = Math.min(cassette.getCurrentAmount(), value / cassette.getBanknote().getDenomination());
                banknotes.put(cassette.getBanknote(), banknotes.get(cassette.getBanknote()) != null ? banknotes.get(cassette.getBanknote()) : +count);
                cassette.setCache(count);
                tmpVal = tmpVal - count * cassette.getBanknote().getDenomination();
            }
        }
        if (value == 0)
            cassettes.forEach(Cassette::popBanknotes);
        else
            throw new ATMException(ATMErrorCodes.ERR_ATM_CASH_AVAIL, String.valueOf(value), currency.getCode());
        return banknotes;
    }

}
