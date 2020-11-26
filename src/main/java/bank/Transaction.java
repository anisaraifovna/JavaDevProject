package bank;

import accesstools.Card;
import common.Money;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter @NonNull
public class Transaction {
    @Setter
    private TransactionStatus status;
    private Money value;
    private Card card;

    public Transaction(Card card, Money value) {
        this.value = value;
        this.card = card;
        this.status = TransactionStatus.OPEN;
    }

    public boolean doTransaction(){
        setStatus(TransactionStatus.PROCESS);
        Account account = Account.findAccount(card);
        account.decrease(value);
        setStatus(TransactionStatus.CLOSE);
        return true;
    }
}
