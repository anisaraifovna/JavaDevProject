package accesstools;

import common.BusinessException;
import lombok.Getter;
import lombok.NonNull;
import java.math.BigDecimal;
import java.util.Date;

@Getter @NonNull
public class DebitCard extends Card {
    BigDecimal returnPercent;

    public DebitCard(String number, Date expiryDate, String pin) throws BusinessException {
        super(number, expiryDate, pin);
        returnPercent = BigDecimal.valueOf(0);
    }

    public DebitCard(String number, Date expiryDate, String pin, BigDecimal returnPercent) throws BusinessException {
        super(number, expiryDate, pin);
        this.returnPercent = returnPercent;
    }
}
