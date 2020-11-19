package bank;

import access.Card;

import java.math.BigDecimal;
import java.util.Currency;

public class Transaction {
    private Card card;
    private BigDecimal value;
    private Currency currency;

    public Transaction(Card card, BigDecimal value, Currency currency) {
        this.card = card;
        this.value = value;
        this.currency = currency;
    }

    public void make (){
        /*todo получить счет, проверить баланс, вычесть сумму со счета,
          вернуть boolean банкомату(?) и где приводить int в BigDecimal? сразу делать BigDecimal
         */
    }
}
