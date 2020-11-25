import accesstools.Card;
import accesstools.exceptions.CardFormatException;
import atm.ATM;
import atm.Banknote;
import atm.exceptions.ATMAvailableSumException;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        Card card = null;
        List<Banknote> banknotes = null;

        try {
            card = new Card("1234567891011121", new Date(1234567890));
            card.setPin("1234");
        }
        catch (CardFormatException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        try {
            banknotes = atm.getCash(card, Currency.getInstance("RUR"), 1000);
        }
        catch (ATMAvailableSumException e) {
            System.out.println(e.getMessage());
            System.exit(-2);
        }

        System.out.println(banknotes.toString());
    }
}
