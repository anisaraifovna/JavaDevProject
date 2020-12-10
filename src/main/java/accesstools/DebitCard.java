package accesstools;

import accesstools.Card;
import accesstools.exceptions.CardFormatException;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter @NonNull
public class DebitCard extends Card {
    BigDecimal returnPercent;

    public DebitCard(String number, Date expiryDate, String pin) throws CardFormatException {
        super(number, expiryDate, pin);
        returnPercent = BigDecimal.valueOf(0);
    }

    public DebitCard(String number, Date expiryDate, String pin, BigDecimal returnPercent) throws CardFormatException {
        super(number, expiryDate, pin);
        this.returnPercent = returnPercent;
    }
}
