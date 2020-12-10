package bank.transactions;

import bank.transactions.exceptions.DoubleTransactionException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NonNull
public class TransactionServer {
    private List<TransactionCash> transactionCashes = new ArrayList<>();

    public void executeTransaction (TransactionCash transactionCash) throws DoubleTransactionException {

        if (transactionCashes.contains(transactionCash)) {
            transactionCash.setStatus(TransactionStatus.REJECTED);
            throw new DoubleTransactionException();
        }

        try {
            transactionCash.execute();
            transactionCash.setStatus(TransactionStatus.OK);
            transactionCashes.add(transactionCash);
        }
        catch (Exception e){
            transactionCash.setStatus(TransactionStatus.FAILED);
        }
    }
}
