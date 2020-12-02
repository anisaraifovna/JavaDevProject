import accesstools.Card;
import accesstools.exceptions.CardFormatException;
import atm.ATM;
import atm.Banknote;
import atm.exceptions.ATMCashNotAvailableException;
import java.util.Currency;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        try {
            Card card = new Card("1234567891011121", new Date(1234567890), "1324");
            List<Banknote> banknotes = atm.getCash(card, Currency.getInstance("RUR"), 1000);
            System.out.println(banknotes);
        }
        catch (CardFormatException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }
        catch (ATMCashNotAvailableException e) {
            System.out.println(e.getMessage());
            System.exit(-2);
        }
    }
}
