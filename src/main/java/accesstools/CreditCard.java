package accesstools;

import accesstools.exceptions.CardFormatException;
import common.Money;
import lombok.NonNull;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Date;

@Setter @NonNull
public class CreditCard extends Card{
    Money limit;
    BigDecimal interestRate;

    public CreditCard(String number, Date expiryDate, String pin, Money limit, BigDecimal interestRate) throws CardFormatException {
        super(number, expiryDate, pin);
        this.limit = limit;
        this.interestRate = interestRate;
    }
}
