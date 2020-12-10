import accesstools.Card;
import atm.ATM;
import atm.Banknote;
import common.Currency;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ATM atm = new ATM();
        try {
            Card card = new Card("1234567891011121", new Date(1234567890), "1324");
            List<Banknote> banknotes = atm.getCash(card, Currency.RUR, 1001);
            System.out.println(banknotes);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
