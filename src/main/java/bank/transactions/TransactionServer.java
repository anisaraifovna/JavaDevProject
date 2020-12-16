package bank.transactions;

import common.BusinessException;
import common.ErrorCodes;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Getter @Setter @NonNull
public class TransactionServer {
    private List<TransactionCash> transactionCashes = new ArrayList<>();

    public void executeTransaction (TransactionCash transactionCash) throws BusinessException {

        if (transactionCashes.contains(transactionCash)) {
            transactionCash.setStatus(TransactionStatus.REJECTED);
            throw new BusinessException(ErrorCodes.ERR_DOUBLE_TRANSACTION,transactionCash.getCard().getNumber(), String.valueOf(transactionCash.getDeviceId()));
        }

        try {
            Predicate<BigDecimal> isPositive = x -> x.signum() > 0;
            transactionCash.execute(isPositive);
            transactionCash.setStatus(TransactionStatus.OK);
            transactionCashes.add(transactionCash);
        }
        catch (Exception e){
            transactionCash.setStatus(TransactionStatus.FAILED);
        }
    }
}
