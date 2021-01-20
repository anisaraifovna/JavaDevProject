package bank.transactions;

import bank.exception.BankingServerErrorCodes;
import bank.exception.BankingServerException;
import common.Money;
import common.accesstools.DebitCard;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NonNull
public class TransactionServer {
    private List<TransactionCash> transactionCashes = new ArrayList<>();

    boolean containsTransaction(TransactionCash transactionCash) {
        return transactionCashes.stream().filter(x -> x.doubleCheck(transactionCash)).findAny().isPresent();
    }

    public void executeTransaction(DebitCard card, Money money, int deviceId, int operationId) throws BankingServerException {

        TransactionCash transactionCash = new TransactionCash(card, money, deviceId, operationId);

        if (containsTransaction(transactionCash)) {
            transactionCash.setStatus(TransactionStatus.REJECTED);
            throw new BankingServerException(BankingServerErrorCodes.ERR_DOUBLE_TRANSACTION, transactionCash.getCard().getNumber(), String.valueOf(transactionCash.getDeviceId()));
        }

        try {
            transactionCash.init();
            transactionCash.execute(x -> x.signum() > 0);
            transactionCash.setStatus(TransactionStatus.OK);
            transactionCashes.add(transactionCash);
        }
        catch (Exception e){
            transactionCash.setStatus(TransactionStatus.FAILED);
        }
    }
}
