package bank;

import accesstools.Card;
import common.Money;
import lombok.Getter;
import lombok.Setter;

public class Transaction {
    @Getter @Setter
    private TransactionStatus status;
    @Getter
    private Money value;
    @Getter
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
