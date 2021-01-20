import atm.ATM;
import atm.Banknote;
import atm.exception.ATMException;
import common.Currency;
import common.accesstools.DebitCard;
import common.exception.BusinessCommonException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws ATMException, BusinessCommonException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(ContextConfiguration.class);
        ctx.refresh();
        ATM atm = ctx.getBean(ATM.class);
        DebitCard card = new DebitCard("1234567891011121", LocalDate.of(2021, 2, 12), "1324");
        Map<Banknote, Integer> banknotes = atm.getCash(card, Currency.RUR, 100);
    }
}
