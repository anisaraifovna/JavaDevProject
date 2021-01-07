import accesstools.DebitCard;
import atm.ATM;
import atm.Banknote;
import common.BusinessException;
import common.Currency;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws BusinessException {
        ATM atm = new ATM();
        DebitCard card = new DebitCard("1234567891011121", new Date(1234567890), "1324");
        List<Banknote> banknotes = atm.getCash(card, Currency.RUR, 100);
        System.out.println(banknotes);
    }
}
