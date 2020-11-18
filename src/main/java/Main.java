import access.Card;
import atm.ATM;

import java.util.Currency;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Card card = new Card(13456789, new Date(1682899200),1234);
        ATM atm = new ATM();
        atm.getCash(card, 100, Currency.getInstance("RUR"));
    }
}
